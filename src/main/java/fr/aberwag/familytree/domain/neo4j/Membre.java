package fr.aberwag.familytree.domain.neo4j;

import java.util.Date;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateString;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NodeEntity
public class Membre {

	@GraphId
	private Long id;

	@Index(unique = true, primary = true)
	@Property(name = "pseudo")
	private String pseudo;

	@Property(name = "nom")
	private String nom;

	@Property(name = "prenom")
	private String prenom;

	@Property(name = "civilite")
	private String civilite;

	@Property(name = "date_naissance")
	@DateString("yyyy-MM-dd")
	private Date dateNaissance;

	@Property(name = "lieu_naissance")
	private String lieuDeNaissance;

	@Property(name = "latitude_naissance")
	private Long latitudeNaissance;

	@Property(name = "longitude_naissance")
	private Long longitudeNaissance;

	@Property(name = "description")
	private String description;

	@Property(name = "photo")
	private String photo;

	@Property(name = "actif")
	private boolean actif;

	@Property(name = "vivant")
	private boolean vivant;

	@Property(name = "numero_portable")
	private String numeroPortable;

	@Property(name = "numero_fixe")
	private String numeroFixe;

	@Property(name = "pays_residence")
	private String paysDeResidence;

	@Property(name = "ville_residence")
	private String villeDeResidence;

	@Property(name = "adresse")
	private String adresse;

	@Property(name = "date_deces")
	@DateString("yyyy-MM-dd")
	private Date dateDeces;

	@Relationship(type = "PERE", direction = Relationship.INCOMING)
	private Membre pere;

	@Relationship(type = "MERE", direction = Relationship.INCOMING)
	private Membre mere;

	@Relationship(type = "CONJOINT", direction = Relationship.INCOMING)
	private Membre conjoint;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
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

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getLieuDeNaissance() {
		return lieuDeNaissance;
	}

	public void setLieuDeNaissance(String lieuDeNaissance) {
		this.lieuDeNaissance = lieuDeNaissance;
	}

	public Long getLatitudeNaissance() {
		return latitudeNaissance;
	}

	public void setLatitudeNaissance(Long latitudeNaissance) {
		this.latitudeNaissance = latitudeNaissance;
	}

	public Long getLongitudeNaissance() {
		return longitudeNaissance;
	}

	public void setLongitudeNaissance(Long longitudeNaissance) {
		this.longitudeNaissance = longitudeNaissance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public boolean isVivant() {
		return vivant;
	}

	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}

	public String getNumeroPortable() {
		return numeroPortable;
	}

	public void setNumeroPortable(String numeroPortable) {
		this.numeroPortable = numeroPortable;
	}

	public String getNumeroFixe() {
		return numeroFixe;
	}

	public void setNumeroFixe(String numeroFixe) {
		this.numeroFixe = numeroFixe;
	}

	public String getPaysDeResidence() {
		return paysDeResidence;
	}

	public void setPaysDeResidence(String paysDeResidence) {
		this.paysDeResidence = paysDeResidence;
	}

	public String getVilleDeResidence() {
		return villeDeResidence;
	}

	public void setVilleDeResidence(String villeDeResidence) {
		this.villeDeResidence = villeDeResidence;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateDeces() {
		return dateDeces;
	}

	public void setDateDeces(Date dateDeces) {
		this.dateDeces = dateDeces;
	}

	public Membre getPere() {
		return pere;
	}

	public void setPere(Membre pere) {
		this.pere = pere;
	}

	public Membre getMere() {
		return mere;
	}

	public void setMere(Membre mere) {
		this.mere = mere;
	}

	public Membre getConjoint() {
		return conjoint;
	}

	public void setConjoint(Membre conjoint) {
		this.conjoint = conjoint;
	}
}
