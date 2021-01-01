package com.esprit.project.entities;

import java.util.Date;

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
@Table(name="Evenement")
public class Evenement {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "dateDebut")
	private Date dateDebut;
	
	@Column(name = "dateFin")
	private Date dateFin;
	
	@Column(name = "titre")
	private String titre;
	
	@Column(name = "lieu")
	private String lieu;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "description")
	private String description;
	
	

}
