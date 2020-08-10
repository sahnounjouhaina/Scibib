import java.util.List;

public class Personne {
private PersonneInfors informations;
	private Integer ID;	
	private String nom;
	private String prenom;
	private String Profession;
	private String email;
	private Integer citation;
	private Integer indiceh;
	private Integer indicei10 ;
	private String discipline;

	public PersonneInfors getInformations() {
		return informations;
	}

	public void setInformations(PersonneInfors informations) {
		this.informations = informations;
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

	public String getProfession() {
		return Profession;
	}

	public void setProfession(String profession) {
		Profession = profession;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCitation() {
		return citation;
	}

	public void setCitation(Integer citation) {
		this.citation = citation;
	}

	public Integer getIndiceh() {
		return indiceh;
	}

	public void setIndiceh(Integer indiceh) {
		this.indiceh = indiceh;
	}

	public Integer getIndicei10() {
		return indicei10;
	}

	public void setIndicei10(Integer indicei10) {
		this.indicei10 = indicei10;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public List<Publication> getPublication() {
		return Publication;
	}

	public void setPublication(List<Publication> publication) {
		Publication = publication;
	}

	
	List<Publication> Publication;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
