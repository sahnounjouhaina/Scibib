package scibib.demo.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import scibib.demo.models.Author;
import scibib.demo.models.DblpAuthor;
import scibib.demo.models.DblpPublication;
import scibib.demo.models.Publication;
import scibib.demo.models.adapter.DblpAuthorAdabter;
import scibib.demo.models.adapter.DblpPublicationAdabter;
import scibib.demo.models.json.ResponseApiDblp;
import scibib.demo.utils.AlwaysListTypeAdapterFactory;

public class DblpApi extends Service implements Api {

    private final String PublicationEndPoint = "https://dblp.org/search/publ/api?";
    private final String authorEndPoint = "https://dblp.org/search/author/api?";
    private final String venueEndPoint = "https://dblp.org/search/venue/api?";

//    private Gson gson = new GsonBuilder()
//            .serializeNulls()
//            .create();
    private Gson gson = new GsonBuilder().registerTypeAdapterFactory(new AlwaysListTypeAdapterFactory()).create();


    @Override
    public Set<Author> getAuthorsByName(String name) {
        try {
            final Map<String, String> parameters = new HashMap<>();
            parameters.put("format" , "json");
            parameters.put("q" , name);
            parameters.put("h" , "100");

            String rsponseAPi = doGet(authorEndPoint , parameters);

            ResponseApiDblp responseApiDblp = gson.fromJson(rsponseAPi.toString() , ResponseApiDblp.class); // deserializes json into target2
//            System.out.println(responseApiDblp.resultJson().hitsJson().hitJson());

            if(responseApiDblp.resultJson().hitsJson().hitJson() == null )
                return Collections.EMPTY_SET ;

            return responseApiDblp
                    .resultJson().hitsJson().hitJson()
                    .stream()
                    .map(hitJson -> new DblpAuthorAdabter((DblpAuthor.fromHit(hitJson))))
                            .collect(Collectors.toSet());

        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
        return Collections.EMPTY_SET ;
    }

    @Override
    public Set<Publication> getPublicationsByTitle(String title) {
        try {
            final Map<String, String> parameters = new HashMap<>();
            parameters.put("format" , "json");
            parameters.put("q" , title);
            parameters.put("h" , "100");

            String rsponseAPiString = doGet(PublicationEndPoint , parameters);

            ResponseApiDblp responseApiDblp = gson.fromJson(rsponseAPiString.toString() , ResponseApiDblp.class); // deserializes json into target2
//            System.out.println(responseApiDblp.resultJson().hitsJson().hitJson());

            return responseApiDblp
                    .resultJson().hitsJson().hitJson()
                    .stream()
                    .map(hitJson -> new DblpPublicationAdabter((DblpPublication.fromHit(hitJson))))
                    .collect(Collectors.toSet());
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
        return Collections.EMPTY_SET;
    }


}
