import models.Author;
import models.Publication;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import services.Api;
import services.DblpApi;
import services.GSApi;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test {
	
    public static void main(String[] args) throws IOException {
    	Api api = null ;
        Set<Author> authorSet = new HashSet<>();
        Set<Publication> publicationList = new HashSet<>();


//        api = new DblpApi();
//        Set<Author> dblpAuthorList =  api.getAuthorsByName("Pascal Poizat");
//        System.out.println("**************************** DBLP -- DISPLAY RESULT (getAuthorsByName) ***********************");
//        dblpAuthorList.forEach(author -> System.out.println(author.getFullName()));
//
//    	api = new GSApi();
//        Set<Author> gsAuthorList =  api.getAuthorsByName("Pascal Poizat");
//        System.out.println("**************************** GS -- DISPLAY RESULT (getAuthorsByName) ***********************");
//        gsAuthorList.forEach(author -> System.out.println(author.getFullName()));

//

    	api = new DblpApi();
        publicationList.addAll(api.getPublicationsByTitle("bpmn"));
    	api = new GSApi();
        publicationList.addAll(api.getPublicationsByTitle("bpmn"));
        System.out.println("********************************************************************************************");
        System.out.println("**************************** DISPLAY RESULT (getPublicationsByTitle) ***********************");
        System.out.println("********************************************************************************************");
        publicationList.forEach(publication -> System.out.println(publication.getTitle()));

        api = new DblpApi();
        authorSet.addAll(api.getAuthorsByName("Pascal"));
        api = new GSApi();
        authorSet.addAll(api.getAuthorsByName("Pascal"));
        System.out.println("********************************************************************************************");
        System.out.println("**************************** DISPLAY RESULT (getAuthorsByName) ***********************");
        System.out.println("********************************************************************************************");
        authorSet.forEach(author -> System.out.println(author.getFullName()));
    }
	
}
