package models;

import models.json.HitJson;

import java.util.List;
import java.util.stream.Collectors;

public interface Publication {

    Integer getId();
    String getTitle();
    List<Author> getAutors();
}
