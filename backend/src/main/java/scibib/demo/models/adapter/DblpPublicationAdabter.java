package scibib.demo.models.adapter;

import scibib.demo.models.Author;
import scibib.demo.models.DblpAuthor;
import scibib.demo.models.DblpPublication;
import scibib.demo.models.Publication;

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
