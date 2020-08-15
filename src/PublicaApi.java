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
public class PublicaApi {
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
            final String name = "Pascal Poizat";
            // API related
            final String api = "https://dblp.org/search/publ/api?";
            final Map<String, String> parameters = new HashMap<>();
            parameters.put("format", "json");
            parameters.put("q", "\"Pascal Poizat\"");
            // open URL
            final List<Publication> pubs = new ArrayList<>();
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
            final ObjectMapper mapper = new ObjectMapper();
            final JsonNode hits = mapper.readTree(input.toString()).path("result").path("hits");
            final int nbPubs = hits.path("@total").asInt();
            System.out.println("nb publications : " + nbPubs);
            hits.path("hit").forEach(hit -> {
                JsonNode info = hit.path("info");
                String title = info.path("title").asText();
                int year = info.path("year").asInt();
                pubs.add(new Publication(title, year));
            });
            // print
            pubs.forEach(pub -> System.out.println(pub));
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    }
}