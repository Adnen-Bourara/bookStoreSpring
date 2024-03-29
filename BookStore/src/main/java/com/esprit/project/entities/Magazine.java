package com.esprit.project.entities;

import java.util.Date;
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
@Table(name="Magazine")
public class Magazine {
	
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
	
	@Column(name = "edition")
	private Integer edition;
	
	@Column(name = "titre")
	private String titre;
	
	@Column(name = "nom")
	private String nom;
	
	@ManyToOne
    @JoinColumn(name = "auteurId")
	private Auteur auteur;
	
	@Column(name = "couverture")
	private String couverture;
	
	@Column(name = "sommaire")
	private String sommaire;
	
	@Column(name = "quantiteStock")
	private Integer quantiteStock;

	@JsonIgnore
	@OneToMany(mappedBy = "magazine", cascade = CascadeType.REMOVE )
	private List<Commentaire> commentaire;

	@JsonIgnore
	@OneToMany(mappedBy = "magazine", cascade = CascadeType.REMOVE )
	private List<Rating> rating;

	
}
