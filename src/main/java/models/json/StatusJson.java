package models.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public record StatusJson(@JsonProperty("@code") @SerializedName("@code") String code,
						 @JsonProperty("text") @SerializedName("text") String text) {

}
