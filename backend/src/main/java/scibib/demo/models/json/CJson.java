package scibib.demo.models.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public record CJson(@JsonProperty("@sc") @SerializedName("@sc") String sc,
                    @JsonProperty("@dc") @SerializedName("@dc") String dc,
                    @JsonProperty("@oc") @SerializedName("@oc") String oc,
                    @JsonProperty("@id") @SerializedName("@id") String id,
                    @JsonProperty("text") @SerializedName("text") String text) {

}
