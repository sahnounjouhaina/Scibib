import java.util.List;

public class Auteur {
private Integer ID;	
private String nom;
private String prenom;
List<Publication> Publication;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
