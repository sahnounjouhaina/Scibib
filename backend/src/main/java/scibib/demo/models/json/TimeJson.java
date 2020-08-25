package scibib.demo.models.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public record TimeJson(@JsonProperty("@unit") @SerializedName("@unit") String unit,
                       @JsonProperty("text") @SerializedName("text") String text) {

}
