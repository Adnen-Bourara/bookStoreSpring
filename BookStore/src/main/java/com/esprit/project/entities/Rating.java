package com.esprit.project.entities;

import java.util.Date;

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
@Table(name="Rating")
public class Rating {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "note")
	private Float note;
	
	@ManyToOne()
    @JoinColumn(name = "clientId")
	private Client client;
	
	@ManyToOne
    @JoinColumn(name = "bookAudioId")
	private BookAudio bookA;
	
	@ManyToOne
    @JoinColumn(name = "bookNumeriqueId")
	private BookNumerique bookN;
	
	@ManyToOne
    @JoinColumn(name = "BookPhysiqueId")
	private BookPhysique bookP;
	
	@ManyToOne
    @JoinColumn(name = "CDid")
	private CD cd;
	
	@ManyToOne
    @JoinColumn(name = "MagazineId")
	private Magazine magazine;
	

}
