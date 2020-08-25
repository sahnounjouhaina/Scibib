package scibib.demo.models.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public record CompletionsJson(@JsonProperty("@total") @SerializedName("@total") String total,
                              @JsonProperty("@computed") @SerializedName("@computed") String computed,
                              @JsonProperty("@sent") @SerializedName("@sent") String sent,
                              @JsonProperty("c") @SerializedName("@c") CJson cJson) {

}
