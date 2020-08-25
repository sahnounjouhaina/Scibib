package scibib.demo.services;
import scibib.demo.models.GSAuthor;
import scibib.demo.models.GSPublication;
import scibib.demo.models.adapter.GSAuthorAdabter;
import scibib.demo.models.adapter.GSPublicationAdabter;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import scibib.demo.models.Author;
import scibib.demo.models.Publication;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import scibib.demo.utils.EncodingUrl;

import java.util.*;
import java.util.stream.Collectors;

public class GSApi extends Service implements Api {

    private static Logger logger = Logger.getLogger(GSApi.class);


    private final String baseApi = "https://scholar.google.com";
    private final String searchEndPoint = "https://scholar.google.com/scholar?start=0&q=";

    @Override
    public Set<Author> getAuthorsByName(String name) {
        Set<Author> authorList = new HashSet<>();
        try {
            String url = searchEndPoint+ EncodingUrl.encode(name) ;
            System.out.println(url);
            Document doc = Jsoup.connect(url).get();
            Elements userProfiles = doc.select(".gs_rt2");
            for (Element userProfile : userProfiles) {
//                System.out.println(newsHeadlines.toString());
//                System.out.println(newsHeadlines.attr("href"));
                String targetURL = userProfile.select("a").attr("href");
                System.out.println(targetURL);

                doc = Jsoup.connect(baseApi +targetURL).get();
                Element fullNameElement = doc.select("#gsc_prf_in").first();
                Element professionElement = doc.select(".gsc_prf_il").first();
                Element domainesElement = doc.select("#gsc_prf_int").first();
                Map<String,String> domaines = new HashMap<>();
                for (Element domaineElement : domainesElement.children()) {
//                    System.out.println(domaineElement.toString());
//                    System.out.println(domaineElement.attr("href"));
                    domaines.put(domaineElement.text(),baseApi+domaineElement.attr("href"));
                }
                List<Publication> publicationList = new ArrayList<>();
                Elements articlesElement = doc.select(".gsc_a_tr");
                for (Element articleElement : articlesElement) {
//                    System.out.println(articleElement.toString());
//                    System.out.println(articleElement.attr("href"));
                    Element td = articleElement.selectFirst("td");
                    String title = td.selectFirst("a").text();
                    String articleUrl = td.selectFirst("a").attr("href");
                    List<String> articleAuthorsString = Arrays.asList(td.selectFirst(".gs_gray").text().split(","));
                    List<Author> articleAuthors = articleAuthorsString.stream().map(
                            author -> new GSAuthorAdabter(new GSAuthor(null,author,null,new HashMap<>(),new ArrayList<>(),null,null,null,null))
                    ).collect(Collectors.toList());
//                    List<Author> articleAuthors = Arrays.asList(
//                            td.selectFirst("gs_gray").text().split("\\s*,\\s*")
//                            new GSPublicationAdabter(new GSPublication(null,null,title,articleUrl,null))
//                    );
                    publicationList.add(
                            new GSPublicationAdabter(new GSPublication(null,articleAuthors,title,articleUrl,null))
                    );
                }
                Elements citeeparelements = doc.select("td.gsc_rsb_std");
                String citations = "" ;
                String indiceH = "" ;
                String indicei10 = "" ;
                if(citeeparelements != null){
                    citations = citeeparelements.get(0).text();
                    indiceH = citeeparelements.get(2).text();
                    indicei10 = citeeparelements.get(4).text();
                }
//                for (Element element : citeeparelements) {
////                    System.out.println(domaineElement.toString());
////                    System.out.println(domaineElement.attr("href"));
//                    domaines.put(domaineElement.text(),domaineElement.attr("href"));
//                }

                authorList.add(new GSAuthorAdabter(new GSAuthor(null,fullNameElement.text(),professionElement.text(),domaines,publicationList,citations,indiceH,indicei10,baseApi +targetURL)));

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
            Document doc = Jsoup.connect(searchEndPoint+ EncodingUrl.encode(title)).get();
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
                publicationSet.add(new GSPublicationAdabter(new GSPublication(null,null,ttt.text(),null,"")));

            }

            return publicationSet;
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
        return Collections.EMPTY_SET;
    }


}
