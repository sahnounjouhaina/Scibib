package scibib.demo.models;

import java.util.List;

public record GSPublication(
        Integer ID,
        List<Author> authors,
        String title,
        String url,
        String date

) {

}
