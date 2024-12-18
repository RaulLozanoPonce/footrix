package requests;

import io.intino.alexandria.logger.Logger;
import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpEntityWrapper {

    private final HttpResponse response;

    public HttpEntityWrapper() {
        this(null);
    }

    public HttpEntityWrapper(HttpResponse response) {
        this.response = response;
    }

    public int andGetStatusCode() {
        return response.getStatusLine().getStatusCode();
    }

    public String andGetContent() {

        if(response == null) return null;

        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) result.append(line);
            return result.toString();
        } catch (IOException e) {
            Logger.error(e);
            return null;
        }
    }

    public ApiObjectWrapper andGetObject() {
        return new ApiObjectWrapper(andGetContent());
    }
}
