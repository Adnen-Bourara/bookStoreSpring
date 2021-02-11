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
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Categorie")
public class Categorie {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	 
	@Column(name = "nom")
	private String nom ;

	@JsonIgnore
	@OneToMany(mappedBy = "categorie",cascade = CascadeType.REMOVE )
	private List<BookAudio> bookAudio;

	@JsonIgnore
	@OneToMany(mappedBy = "categorie",cascade = CascadeType.REMOVE )
	private List<BookNumerique> bookNumerique;

	@JsonIgnore
	@OneToMany(mappedBy = "categorie",cascade = CascadeType.REMOVE )
	private List<BookPhysique> bookPhysique;
	
	@JsonIgnore
	@OneToMany(mappedBy = "categorie",cascade = CascadeType.REMOVE )
	private List<Pub> pub;
}
