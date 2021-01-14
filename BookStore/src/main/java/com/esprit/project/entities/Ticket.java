package com.esprit.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="Ticket")
public class Ticket {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "prix")
	private double prix;
	
	@Column(name = "description")
	private double description;
	
	@Column(name = "imageCouverture")
	private String imageCouverture;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evenement")
	private Evenement evenement ;
}
