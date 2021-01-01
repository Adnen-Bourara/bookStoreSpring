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
@Table(name="Commentaire")
public class Commentaire {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "texte")
	private String texte;
	
	@Column(name = "date")
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId")
	private Client client;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookAudioId")
	private BookAudio bookA;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookNumeriqueId")
	private BookNumerique bookN;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BookPhysiqueId")
	private BookPhysique bookP;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CDid")
	private CD cd;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MagazineId")
	private Magazine magazine;
	
}
