package models;

import models.json.AuthorJson;
import models.json.HitJson;


public record DblpAuthor(
		Integer ID,
		String fullName,
		String nom,
		String prenom,
		String score,
		String url
) {

	public static DblpAuthor fromHit(HitJson hitJson){
		return new DblpAuthor(Integer.parseInt(hitJson.id()) , hitJson.infoJson().author() , "" , "" , hitJson.score() , hitJson.infoJson().url());
	}

	public static DblpAuthor fromAuthor(AuthorJson author){
		return new DblpAuthor(null , author.text() ,  null, null , null,null);
	}

}
