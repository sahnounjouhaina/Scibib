package models.adapter;

import models.Author;
import models.DblpAuthor;
import models.GSAuthor;
import models.Publication;

import java.util.List;
import java.util.Map;

public class GSAuthorAdabter implements Author {

    private GSAuthor gsAuthor;

    public GSAuthorAdabter(GSAuthor gsAuthor) {
        this.gsAuthor = gsAuthor;
    }

    @Override
    public Integer getId() {
        return gsAuthor.ID();
    }

    @Override
    public String getFullName() {
        return gsAuthor.fullName();
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String geProfession() {
        return null;
    }

    @Override
    public Map<String, String> getDomaines() {
        return null;
    }

    @Override
    public List<Publication> getPublications() {
        return null;
    }

    @Override
    public String toString() {
        return "DblpAuthorAdabter{" +
                "dblpAuthor=" + gsAuthor +
                '}';
    }
}
