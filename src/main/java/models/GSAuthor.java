package models;

import models.json.AuthorJson;
import models.json.HitJson;

import java.util.List;
import java.util.Map;
import java.util.Objects;

//
public record GSAuthor(
		Integer ID,
		String fullName,
		String profession,
		Map<String,String> domaines
){


}
//
//public class GSAuthor{
//		private Integer ID;
//		private String fullName;
//		private String profession;
//		private Map<String,String> domaines;
//
//	public Integer getID() {
//		return ID;
//	}
//
//	public void setID(Integer ID) {
//		this.ID = ID;
//	}
//
//	public String getFullName() {
//		return fullName;
//	}
//
//	public void setFullName(String fullName) {
//		this.fullName = fullName;
//	}
//
//	public String getProfession() {
//		return profession;
//	}
//
//	public void setProfession(String profession) {
//		this.profession = profession;
//	}
//
//	public Map<String, String> getDomaines() {
//		return domaines;
//	}
//
//	public void setDomaines(Map<String, String> domaines) {
//		this.domaines = domaines;
//	}
//
//	public GSAuthor(Integer ID , String fullName , String profession , Map<String, String> domaines) {
//		this.ID = ID;
//		this.fullName = fullName;
//		this.profession = profession;
//		this.domaines = domaines;
//	}
//
//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (!(o instanceof GSAuthor)) return false;
//		GSAuthor gsAuthor = (GSAuthor) o;
//		return Objects.equals(ID , gsAuthor.ID) &&
//				Objects.equals(fullName , gsAuthor.fullName) &&
//				Objects.equals(profession , gsAuthor.profession) &&
//				Objects.equals(domaines , gsAuthor.domaines);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(ID , fullName , profession , domaines);
//	}
//
//	@Override
//	public String toString() {
//		return "GSAuthor{" +
//				"ID=" + ID +
//				", fullName='" + fullName + '\'' +
//				", profession='" + profession + '\'' +
//				", domaines=" + domaines +
//				'}';
//	}
//}