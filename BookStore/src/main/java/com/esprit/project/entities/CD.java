package com.esprit.project.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CD")
public class CD {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "prix")
	private double prix;
	
	@Column(name = "statut")
	private String statut;
	
	@Column(name = "langue")
	private String langue;
	
	@Column(name = "dateProduction")
	private String dateProduction;
	
	@Column(name = "titre")
	private String titre;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "taille")
	private int taille;
	
	@Column(name = "quantiteStock")
	private int quantiteStock;
	
	
	@Column(name = "couverture")
	private String couverture;
	
	@Column(name = "reference")
	private String reference;
	
	@OneToMany(mappedBy = "cd", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE )
	private List<Commentaire> commentaire;
	    
	@OneToMany(mappedBy = "cd", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE )
	private List<Rating> rating;

//	public CD() {
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public double getPrix() {
//		return prix;
//	}
//
//	public void setPrix(double prix) {
//		this.prix = prix;
//	}
//
//	public String getStatut() {
//		return statut;
//	}
//
//	public void setStatut(String statut) {
//		this.statut = statut;
//	}
//
//	public String getLangue() {
//		return langue;
//	}
//
//	public void setLangue(String langue) {
//		this.langue = langue;
//	}
//
//	public String getDateProduction() {
//		return dateProduction;
//	}
//
//	public void setDateProduction(String dateProduction) {
//		this.dateProduction = dateProduction;
//	}
//
//	public String getTitre() {
//		return titre;
//	}
//
//	public void setTitre(String titre) {
//		this.titre = titre;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public int getTaille() {
//		return taille;
//	}
//
//	public void setTaille(int taille) {
//		this.taille = taille;
//	}
//
//	public int getQuantiteStock() {
//		return quantiteStock;
//	}
//
//	public void setQuantiteStock(int quantiteStock) {
//		this.quantiteStock = quantiteStock;
//	}
//
//	public String getCouverture() {
//		return couverture;
//	}
//
//	public void setCouverture(String couverture) {
//		this.couverture = couverture;
//	}
//
//	public String getReference() {
//		return reference;
//	}
//
//	public void setReference(String reference) {
//		this.reference = reference;
//	}
//
//	public List<Commentaire> getCommentaire() {
//		return commentaire;
//	}
//
//	public void setCommentaire(List<Commentaire> commentaire) {
//		this.commentaire = commentaire;
//	}
//
//	public List<Rating> getRating() {
//		return rating;
//	}
//
//	public void setRating(List<Rating> rating) {
//		this.rating = rating;
//	}
}
