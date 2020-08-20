package models.adapter;

import models.Author;
import models.GSPublication;
import models.Publication;

import java.util.List;

public class GSPublicationAdabter implements Publication {

    private GSPublication gsPublication;


    public GSPublicationAdabter(GSPublication gsPublication) {
        this.gsPublication = gsPublication;
    }

    @Override
    public Integer getId() {
        return gsPublication.ID();
    }

    @Override
    public String getTitle() {
        return gsPublication.title();
    }

    @Override
    public List<Author> getAutors() {
        return gsPublication.authors();
    }


}
