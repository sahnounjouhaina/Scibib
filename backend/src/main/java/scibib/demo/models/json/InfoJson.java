package scibib.demo.models.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public record InfoJson(@JsonProperty("author") @SerializedName("author") String author,
					   @JsonProperty("aliases") @SerializedName("aliases") AliasesJson aliasesJson ,
					   @JsonProperty("url") @SerializedName("url") String url,
					   @JsonProperty("notes") @SerializedName("notes") NotesJson notesJson ,
					   @JsonProperty("authors") @SerializedName("authors") AuthorsJson authorsJson ,
					   @JsonProperty("title") @SerializedName("title") String title,
					   @JsonProperty("venue") @SerializedName("venue") String venue,
					   @JsonProperty("volume") @SerializedName("volume") String volume,
					   @JsonProperty("year") @SerializedName("year") String year,
					   @JsonProperty("type") @SerializedName("type") String type,
					   @JsonProperty("key") @SerializedName("key") String key,
					   @JsonProperty("ee") @SerializedName("ee") String ee

	) {

}
