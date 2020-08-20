 package models.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public record HitJson(@JsonProperty("@score") @SerializedName("@score") String score,
					  @JsonProperty("@id") @SerializedName("@id") String id,
					  @JsonProperty("info") @SerializedName("info") InfoJson infoJson ,
					  @JsonProperty("url") @SerializedName("url") String url) {

}
