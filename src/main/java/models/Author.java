package models;

import java.util.List;
import java.util.Map;

public interface Author {
    Integer getId();
    String getFullName();
    String getFirstName();
    String getLastName();
    String getEmail();
    String geProfession();
    Map<String,String> getDomaines();
    List<Publication> getPublications();


}
