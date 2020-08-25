package scibib.demo;

import org.springframework.web.bind.annotation.*;
import scibib.demo.models.Author;
import scibib.demo.models.Publication;
import scibib.demo.services.Api;
import scibib.demo.services.DblpApi;
import scibib.demo.services.GSApi;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AppBiblioController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/authors")
    public Set<Author> getAuthors() {
        Set<Author> authorSet = new HashSet<>();
        Api api = null ;
        try {
            api = new DblpApi();
            authorSet.addAll(api.getAuthorsByName(""));
            api = new GSApi();
            authorSet.addAll(api.getAuthorsByName(""));
            System.out.println("********************************************************************************************");
            System.out.println("**************************** DISPLAY RESULT (getAuthorsByName) ***********************");
            System.out.println("********************************************************************************************");
            authorSet.forEach(author -> author.display(author));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorSet;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/authors/{name}")
    public Set<Author> getAuthorByNmae(@PathVariable("name") String name) {
        Set<Author> authorSet = new HashSet<>();
        Api api = null ;
        try {
            api = new DblpApi();
            authorSet.addAll(api.getAuthorsByName(name));
            api = new GSApi();
            authorSet.addAll(api.getAuthorsByName(name));
            System.out.println("********************************************************************************************");
            System.out.println("**************************** DISPLAY RESULT (getAuthorsByName) ***********************");
            System.out.println("********************************************************************************************");
            authorSet.forEach(author -> author.display(author));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorSet;
    }

    @GetMapping("/publications/{title}")
    public Set<Publication> getPublications(@PathVariable("title") String title) {
        Set<Publication> publicationSet = new HashSet<>();
        Api api = null ;
        try {
            api = new DblpApi();
            publicationSet.addAll(api.getPublicationsByTitle(title));
            api = new GSApi();
            publicationSet.addAll(api.getPublicationsByTitle(title));
            System.out.println("********************************************************************************************");
            System.out.println("**************************** DISPLAY RESULT (getPublicationsByTitle) ***********************");
            System.out.println("********************************************************************************************");
            publicationSet.forEach(publication -> System.out.println(publication.getTitle()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publicationSet;
    }


}