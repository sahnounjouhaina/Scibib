package scibib.demo.models.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public record NoteJson(@JsonProperty("@type") @SerializedName("@type") String type,
					   @JsonProperty("text") @SerializedName("text") String text) {

}
