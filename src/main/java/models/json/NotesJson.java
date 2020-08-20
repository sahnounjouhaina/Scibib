package models.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;


public record NotesJson(@JsonProperty("note") @SerializedName("note") NoteJson noteJson) {

}
