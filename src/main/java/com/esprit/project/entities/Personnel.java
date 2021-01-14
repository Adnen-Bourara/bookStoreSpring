package com.esprit.project.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="Personnel")
public class Personnel {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "cin")
	private int cin;
	
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

	@Column(name = "dateSignature")
	private Date dateSignature;
	
	@Column(name = "salaire")
	private int salaire;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "soldeConge")
	private int soldeConge;

}
