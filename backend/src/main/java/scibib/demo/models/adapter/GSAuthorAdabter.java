package scibib.demo.models.adapter;

import scibib.demo.models.Author;
import scibib.demo.models.DblpAuthor;
import scibib.demo.models.GSAuthor;
import scibib.demo.models.Publication;

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
        return gsAuthor.profession();
    }

    @Override
    public String getCitations() {
        return gsAuthor.citations();
    }

    @Override
    public String getIndiceH() {
        return gsAuthor.indiceH();
    }

    @Override
    public String getIndiceO10() {
        return gsAuthor.indicei10();
    }

    @Override
    public Map<String, String> getDomaines() {
        return gsAuthor.domaines() ;
    }

    @Override
    public List<Publication> getPublications() {
        return gsAuthor.publications();
    }

    @Override
    public String getURL() {
        return gsAuthor.url();
    }

    @Override
    public String toString() {
        return "DblpAuthorAdabter{" +
                "dblpAuthor=" + gsAuthor +
                '}';
    }
}
