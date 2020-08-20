package models.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public record HitsJson(@JsonProperty("@total") @SerializedName("@total") String total,
                       @JsonProperty("@computed") @SerializedName("@computed") String computed,
                       @JsonProperty("@sent") @SerializedName("@sent") String sent,
                       @JsonProperty("@first") @SerializedName("@first") String first,
                       @JsonProperty("hit") @SerializedName("hit") List<HitJson> hitJson) {

}
