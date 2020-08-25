package scibib.demo.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import scibib.demo.models.json.ResultJson;
import scibib.demo.utils.EncodingUrl;

public class Service {

	public String doGet(String endPoint,Map<String, String> parameters) throws IOException {
            final List<ResultJson> pubs = new ArrayList<>();
            final String query = parameters.keySet().stream()
                    .map(k -> String.format("%s=%s", k, EncodingUrl.encode(parameters.get(k))))
                    .collect(Collectors.joining("&", endPoint, ""));
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
//            System.out.println(input.toString());
            return input.toString();
	}


//	public void getHTML(String endPoint){
//	    String html = "" ;
//        URL url;
//
//        try {
//            url = new URL(endPoint);
//            URLConnection conn = url.openConnection();
//
//            // open the stream and put it into BufferedReader
//            BufferedReader br = new BufferedReader(
//                    new InputStreamReader(conn.getInputStream()));
//
//            String inputLine;
//            while ((inputLine = br.readLine()) != null) {
//                System.out.println(inputLine);
//            }
//            br.close();
//
//            System.out.println("Done");
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
