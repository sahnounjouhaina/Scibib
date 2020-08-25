package scibib.demo.services;

import scibib.demo.models.Author;
import scibib.demo.models.Publication;

import java.util.Set;

public interface Api {
    Set<Author> getAuthorsByName(String name);
    Set<Publication> getPublicationsByTitle(String title);
}
