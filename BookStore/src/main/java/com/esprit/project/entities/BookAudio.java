package com.esprit.project.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="BookAudio")
public class BookAudio {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "prix")
	private  Double prix;
	
	@Column(name = "statut")
	private String statut;
	
	@Column(name = "langue")
	private String langue;
	
	@Column(name = "titre")
	private String titre;
	
	@Column(name = "couverture")
	private String couverture;
	
	@ManyToOne
    @JoinColumn(name = "auteurId")
	private Auteur auteur;
	
	@ManyToOne
    @JoinColumn(name = "categorieId")
	private Categorie categorie ;
	
	@Column(name = "langueOrigine")
	private String langueOrigine;
	
	@Column(name = "dateDeParution")
	private String dateDeParution;
	
	@Column(name = "lieuParution")
	private String lieuParution;
	
	@Column(name = "traducteur")
	private String traducteur;
	
	@Column(name = "editeur")
	private String editeur;
	
	@Column(name = "collection")
	private String collection;
	
	@Column(name = "adaptation")
	private String adaptation;
	
	@Column(name = "sommaire")
	private String sommaire;
	
	@Column(name = "filePath")
	private String filePath;
	
	@Column(name = "narrateur")
	private String narrateur;
	    
	@Column(name = "duree")
	private Integer duree;
	    
	@Column(name = "tailleFile")
	private String tailleFile;
	
	@Column(name = "format")
	private String format;

	@JsonIgnore
	@OneToMany(mappedBy = "bookA", cascade = CascadeType.REMOVE )
	private List<Commentaire> commentaire;

	@JsonIgnore
	@OneToMany(mappedBy = "bookA", cascade = CascadeType.REMOVE )
	private List<Rating> rating;
	
}
