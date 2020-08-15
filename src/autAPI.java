

import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.UnsupportedEncodingException;
        import java.net.HttpURLConnection;
        import java.net.URL;
        import java.net.URLEncoder;
        import java.nio.charset.StandardCharsets;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
        import java.util.stream.Collectors;
        import com.fasterxml.jackson.databind.*;
public class autAPI {
    public static String encode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            return value;
        }
    }
    public static void main(String[] args) {
        try {
            // parameter
            final String title = "VBPMN";
            // API related
            final String api = "http://dblp.org/search/author/api?";
            final Map<String, String> parameters = new HashMap<>();
            parameters.put("format", "json");
            parameters.put("q", "\"VBPMN\"");
            // open URL
            final List<Auteur> auteur = new ArrayList<>();
            final String query = parameters.keySet().stream()
                    .map(k -> String.format("%s=%s", k, encode(parameters.get(k))))
                    .collect(Collectors.joining("&", api, ""));
            System.out.println(query);
            URL url = new URL(query);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
            }
            // read from URL
            final BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            final StringBuffer input = new StringBuffer();
            while ((line = in.readLine()) != null) {
                input.append(line);
            }
            in.close();
            conn.disconnect();
            // deal with JSON
           
            // print
            auteur.forEach(aut -> System.out.println(auteur));
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    }
}