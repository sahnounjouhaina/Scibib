package models.adapter;

import models.Author;
import models.DblpAuthor;
import models.DblpPublication;
import models.Publication;

import java.util.List;
import java.util.Map;

public class DblpPublicationAdabter implements Publication {

    private DblpPublication dblpPublication;

    public DblpPublicationAdabter(DblpPublication dblpPublication) {
        this.dblpPublication = dblpPublication;
    }


    @Override
    public Integer getId() {
        return dblpPublication.ID();
    }

    @Override
    public String getTitle() {
        return dblpPublication.title();
    }

    @Override
    public List<Author> getAutors() {
        return dblpPublication.authors();
    }


}
