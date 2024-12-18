package requests;

public class Formatter {

    public static class URI {

        public static String format(String uri) {

            if(uri == null) return null;

            String[] uriSplitted = uri.split("//");
            if(uriSplitted.length != 2) return uri;

            String uriFormatted = uriSplitted[1];
            uriFormatted = uriFormatted.replaceAll("%", "%25");
            uriFormatted = uriFormatted.replaceAll(":", "%3A");
            uriFormatted = uriFormatted.replaceAll(" ", "%20");

            return uriSplitted[0] + "//" + uriFormatted;
        }
    }
}
