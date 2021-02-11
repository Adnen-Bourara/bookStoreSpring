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
@Table(name="Client")
public class Client {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "numero")
	private Integer numero;
	
	@Column(name = "cin")
	private Integer cin;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "mdp")
	private String mdp;

	@Column(name = "mail")
	private String mail;
	
	@Column(name = "adresse")
	private String adresse;

	@Column(name = "idFiscale")
	private Integer idFiscale;

	@Column(name = "isBanned")
	private Boolean isBanned = false;

	@JsonIgnore
	@OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE )
	private List<Commentaire> commentaire;

	@JsonIgnore
	@OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE )
	private List<Rating> rating;
}
