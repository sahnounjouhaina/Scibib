package scibib.demo.models.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public record ResultJson(@JsonProperty("query") @SerializedName("query") String query,
						 @JsonProperty("status") @SerializedName("status") StatusJson statusJson ,
						 @JsonProperty("time") @SerializedName("time") TimeJson timeJson ,
						 @JsonProperty("completions") @SerializedName("completions") CompletionsJson completionsJson ,
						 @JsonProperty("hits") @SerializedName("hits") HitsJson hitsJson) {

}
