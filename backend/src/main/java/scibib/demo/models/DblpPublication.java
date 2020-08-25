package scibib.demo.models;

import scibib.demo.models.adapter.DblpAuthorAdabter;
import scibib.demo.models.json.HitJson;

import java.util.List;
import java.util.stream.Collectors;

public record DblpPublication(
        Integer ID,
        List<Author> authors,
        String title
        ) {

    public static DblpPublication fromHit(HitJson hitJson){
        return new DblpPublication(
                Integer.parseInt(hitJson.id()),
                hitJson.infoJson().authorsJson().author().stream().map(author -> new DblpAuthorAdabter(DblpAuthor.fromAuthor(author))).collect(Collectors.toList()),
                hitJson.infoJson().title());
//        DblpPublication dblpPublication = new DblpPublication(
//                Integer.parseInt(hitJson.id()),
//                hitJson.infoJson().authorsJson().author().stream().map(author -> new DblpAuthorAdabter(DblpAuthor.fromAuthor(author))).collect(Collectors.toList()),
//                hitJson.infoJson().title());
//        System.out.println(dblpPublication);
//        return dblpPublication ;
    }

}
