package services;

import models.Author;
import models.Publication;

import java.util.Set;

public interface Api {
    Set<Author> getAuthorsByName(String name);
    Set<Publication> getPublicationsByTitle(String title);
}
