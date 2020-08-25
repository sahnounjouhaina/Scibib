package scibib.demo.models.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public record ResponseApiDblp(
		@JsonProperty("result") @SerializedName("result") ResultJson resultJson
        ) { }