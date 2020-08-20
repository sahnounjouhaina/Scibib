package models.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public record AliasesJson(@JsonProperty("result") @SerializedName("result") ResultJson resultJson,
            @JsonProperty("alias") @SerializedName("alias") String alias) {

}
