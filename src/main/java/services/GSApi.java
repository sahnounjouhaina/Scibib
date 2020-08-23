package services;
import models.GSAuthor;
import models.GSPublication;
import models.adapter.GSAuthorAdabter;
import models.adapter.GSPublicationAdabter;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Author;
import models.Publication;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.EncodingUrl;

import java.util.*;

public class GSApi extends Service implements Api {

    private static Logger logger = Logger.getLogger(GSApi.class);


    private final String baseApi = "https://scholar.google.com";
    private final String authorEndPoint = "https://scholar.google.com/scholar?q=";

    @Override
    public Set<Author> getAuthorsByName(String name) {
        Set<Author> authorList = new HashSet<>();
        try {
            Document doc = Jsoup.connect(authorEndPoint+ EncodingUrl.encode(name)).get();
            Elements userProfiles = doc.select(".gs_rt2");
            for (Element userProfile : userProfiles) {
//                System.out.println(newsHeadlines.toString());
//                System.out.println(newsHeadlines.attr("href"));
                String targetURL = userProfile.select("a").attr("href");

                doc = Jsoup.connect(baseApi +targetURL).get();
                Element fullNameElement = doc.select("#gsc_prf_in").first();
                Element professionElement = doc.select(".gsc_prf_il").first();
                Element domainesElement = doc.select("#gsc_prf_int").first();
                Map<String,String> domaines = new HashMap<>();
                for (Element domaineElement : domainesElement.children()) {
//                    System.out.println(domaineElement.toString());
//                    System.out.println(domaineElement.attr("href"));
                    domaines.put(domaineElement.text(),domaineElement.attr("href"));
                }
                Elements articlesElement = doc.select(".gsc_a_tr");
                for (Element articleElement : articlesElement) {
//                    System.out.println(articleElement.toString());
//                    System.out.println(articleElement.attr("href"));
                }
                authorList.add(new GSAuthorAdabter(new GSAuthor(null,fullNameElement.text(),professionElement.text(),domaines)));

            }

            return authorList;

        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
        return Collections.EMPTY_SET;
    }

    @Override
    public Set<Publication> getPublicationsByTitle(String title) {
        Set<Publication> publicationSet = new HashSet<>();
        try {
            Document doc = Jsoup.connect(authorEndPoint+ EncodingUrl.encode(title)).get();
            Elements publicationTitles = doc.select(".gs_rt");
            for (Element publicationTitle : publicationTitles) {

                Element ttt = publicationTitle.select("a").first() ;
//                Element professionElement = doc.select(".gsc_prf_il").first();
//                Element domainesElement = doc.select("#gsc_prf_int").first();
//                Map<String,String> domaines = new HashMap<>();
//                for (Element domaineElement : domainesElement.children()) {
//                    System.out.println(domaineElement.toString());
//                    System.out.println(domaineElement.attr("href"));
//                    domaines.put(domaineElement.text(),domaineElement.attr("href"));
//                }
//                Elements articlesElement = doc.select(".gsc_a_tr");
//                for (Element articleElement : articlesElement) {
//                    System.out.println(articleElement.toString());
//                    System.out.println(articleElement.attr("href"));
//                }
                if(ttt != null)
                publicationSet.add(new GSPublicationAdabter(new GSPublication(null,null,ttt.text(),null)));

            }

            return publicationSet;
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
        return Collections.EMPTY_SET;
    }


}
