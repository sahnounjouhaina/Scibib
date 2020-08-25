package scibib.demo.models.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import scibib.demo.utils.AlwaysListTypeAdapterFactory;

import java.util.List;


public record AuthorsJson(@JsonProperty("author") @SerializedName("author") List<AuthorJson> author) {
//public record AuthorsJson(@JsonProperty("author") @SerializedName("author")  @JsonAdapter(AlwaysListTypeAdapterFactory.class)  List<AuthorJson> author) {

}
