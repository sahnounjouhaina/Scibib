package scibib.demo.models.adapter;


import scibib.demo.models.Author;
import scibib.demo.models.DblpAuthor;
import scibib.demo.models.Publication;

import java.util.List;
import java.util.Map;

public class DblpAuthorAdabter implements Author {

    private DblpAuthor dblpAuthor;

    public DblpAuthorAdabter(DblpAuthor dblpAuthor) {
        this.dblpAuthor = dblpAuthor;
    }

    @Override
    public Integer getId() {
        return dblpAuthor.ID();
    }

    @Override
    public String getFullName() {
        return dblpAuthor.fullName() != null ? dblpAuthor.fullName() : dblpAuthor.nom() + dblpAuthor.prenom();
    }

    @Override
    public String getFirstName() {
        return dblpAuthor.prenom();
    }

    @Override
    public String getLastName() {
        return dblpAuthor.nom();
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
    public String getCitations() {
        return null;
    }

    @Override
    public String getIndiceH() {
        return null;
    }

    @Override
    public String getIndiceO10() {
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
    public String getURL() {
        return dblpAuthor.url();
    }


}
