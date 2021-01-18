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


import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="AUTEUR")
public class Auteur {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
    private String prenom;
    
	@Column(name = "nationalite")
    private String nationalite;
    
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "activites")
	private String activites;
	
	@Column(name = "formation")
    private String formation;
    
	@Column(name = "biographie")
    private String biographie;
    
	@Column(name = "dateOfBirth")
	private String dateOfBirth;
	
	@Column(name = "dateOfdeath")
    private String dateOfdeath;

	@JsonIgnore
	@OneToMany(mappedBy = "auteur", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE )
	private List<BookAudio> bookAudio;

	@JsonIgnore
	@OneToMany(mappedBy = "auteur", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE )
	private List<BookNumerique> bookNumerique;

	@JsonIgnore
	@OneToMany(mappedBy = "auteur", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE )
	private List<BookPhysique> bookPhysique;

	@JsonIgnore
	@OneToMany(mappedBy = "auteur", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE )
	private List<Magazine> magazine;
}
