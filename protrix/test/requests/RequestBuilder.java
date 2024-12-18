package requests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.intino.alexandria.logger.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RequestBuilder {

    private final RequestType requestType;
    private String topic;
    private String uriBase;

    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> queryParams = new HashMap<>();
    private String body = "";
    private BodyType bodyType = BodyType.RAW;
    private Integer timeout;

    public RequestBuilder(RequestType requestType, String uriBase) {

        if(uriBase == null || uriBase.equals("")) throw new RuntimeException("No se ha definido la URL");
        if(requestType == null) throw new RuntimeException("No se ha definido el tipo de petición");

        this.requestType = requestType;
        this.uriBase = uriBase;
    }

    public RequestBuilder addToPath(String subPath) {
        uriBase += subPath;
        return this;
    }

    public RequestBuilder topic(String topic) {
        this.topic = (topic == null || topic.equals("")) ? "" : topic;
        return this;
    }

    public RequestBuilder headers(Map<String, String> headers) {
        if(headers == null) return this;
        this.headers = headers;
        return this;
    }

    public RequestBuilder addHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public RequestBuilder queryParams(Map<String, String> queryParams) {
        if(queryParams == null) return this;
        this.queryParams = queryParams;
        return this;
    }

    public RequestBuilder addQueryParam(String key, String value) {
        this.queryParams.put(key, value);
        return this;
    }

    public RequestBuilder body(String body, BodyType bodyType) {
        this.body = body;
        this.bodyType = bodyType;
        return this;
    }

    public RequestBuilder bearerAuthorization(String token) {
        addHeader("Authorization", "Bearer " + token);
        return this;
    }

    public RequestBuilder timeout(int time) {
        this.timeout = time;
        return this;
    }

    /* -------------------------------------------------------------------------------------------------------------- */

    public HttpEntityWrapper call() {

        HttpRequestBase request = getRequest();
        if (request == null) return new HttpEntityWrapper();
        setHeadersTo(request);
        if(requestType.equals(RequestType.POST) || requestType.equals(RequestType.PUT)) setBodyTo(request);
        if(timeout != null) request.setConfig(RequestConfig.custom().setConnectTimeout(timeout).build());

        try {
            CloseableHttpClient client = client();
            HttpResponse response = client.execute(request);
            StatusLine statusLine = response.getStatusLine();
            Logger.info(requestType.name() + " " + topic + " - Status Code: " + statusLine.getStatusCode() + " - Reason: " + statusLine.getReasonPhrase());

            return new HttpEntityWrapper(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* -------------------------------------------------------------------------------------------------------------- */

    private HttpRequestBase getRequest() {
        try {
            if (requestType.equals(RequestType.GET)) return new HttpGet(getUri());
            if (requestType.equals(RequestType.POST)) return new HttpPost(getUri());
            if (requestType.equals(RequestType.DELETE)) return new HttpDelete(getUri());
            if (requestType.equals(RequestType.PUT)) return new HttpPut(getUri());
            return new HttpGet(getUri());
        } catch (IllegalArgumentException e) {
            Logger.error(e);
            return null;
        }
    }

    private String getUri() {

        StringBuilder sb = new StringBuilder();
        sb.append(uriBase);

        String uri;

        if(queryParams.size() > 0) {

            sb.append("?");
            queryParams.forEach((key, value) -> sb.append(key).append("=").append(Formatter.URI.format(value)).append("&"));

            uri = sb.substring(0, sb.toString().length() - 1);
        } else {

            uri = sb.toString();
        }

        return Formatter.URI.format(uri);
    }

    private void setHeadersTo(HttpRequestBase request) {
        headers.forEach(request::setHeader);
    }

    private void setBodyTo(HttpRequestBase request) {

        if(body == null || body.equals("")) return;

        if(bodyType.equals(BodyType.RAW)) {
            if(request instanceof HttpPost) {
                ((HttpPost) request).setEntity(new StringEntity(body, "UTF-8"));
            } else {
                ((HttpPut) request).setEntity(new StringEntity(body, "UTF-8"));
            }
        } else if(bodyType.equals(BodyType.FORM)) {

            Map<String, String> form = new Gson().fromJson(body, new TypeToken<Map<String, String>>(){}.getType());
            List<NameValuePair> params = form.entrySet().stream().map(e -> new BasicNameValuePair(e.getKey(), e.getValue())).collect(Collectors.toList());

            try {
                ((HttpPost) request).setEntity(new UrlEncodedFormEntity(params));
            } catch (UnsupportedEncodingException e) {
                Logger.error(e);
            }
        }
    }

    private CloseableHttpClient client() throws IOException {
        try {
            SSLContextBuilder builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(builder.build(), NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", new PlainConnectionSocketFactory())
                    .register("https", sslConnectionSocketFactory)
                    .build();

            PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
            cm.setMaxTotal(100);
            return HttpClients.custom()
                    .setSSLSocketFactory(sslConnectionSocketFactory)
                    .setConnectionManager(cm)
                    .build();
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            throw new IOException("Error getting client");
        }
    }

    /* -------------------------------------------------------------------------------------------------------------- */

    public String uri() {
        return uriBase;
    }

    public String topic() {
        return topic;
    }

    public Map<String, String> headers() {
        return headers;
    }

    public Map<String, String> queryParams() {
        return queryParams;
    }

    public String body() {
        return body;
    }

    public BodyType bodyType() {
        return bodyType;
    }

    /* -------------------------------------------------------------------------------------------------------------- */

    public enum RequestType {
        GET, POST, DELETE, PUT
    }

    public enum BodyType {
        FORM, RAW
    }
}
