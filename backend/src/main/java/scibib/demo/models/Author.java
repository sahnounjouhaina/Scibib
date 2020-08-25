package scibib.demo.models;

import java.util.List;
import java.util.Map;

public interface Author {
    Integer getId();
    String getFullName();
    String getFirstName();
    String getLastName();
    String getEmail();
    String geProfession();
    String getCitations();
    String getIndiceH();
    String getIndiceO10();
    Map<String,String> getDomaines();
    List<Publication> getPublications();
    String getURL();


//    String display();

    public default void display(Author author) {
        System.out.println();
        System.out.print("Author {" +
                "ID=" + author.getId() +
                " FullName=" + author.getFullName() +
                " Domaines= ["); author.getDomaines().forEach((k,v) -> System.out.print(" "+k));
//                "Publications=" + author.getPublications().toString() +
                System.out.print(" ] }");
//        return "ok" ;
    }


}
