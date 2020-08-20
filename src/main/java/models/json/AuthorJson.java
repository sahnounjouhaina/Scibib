package models.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public record AuthorJson(@JsonProperty("@pid") @SerializedName("@pid") String unit,
                         @JsonProperty("text") @SerializedName("text") String text) {

}
