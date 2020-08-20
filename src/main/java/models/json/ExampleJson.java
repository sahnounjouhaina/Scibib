package models.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public record ExampleJson(@JsonProperty("alias") @SerializedName("alias") String alias) {

}
