package com.esprit.project.entities;

import lombok.*;

import javax.persistence.*;

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
    private  Double prix;

    @Column(name = "description")
    private String description;

    @Column(name = "imageCouverture")
    private String imageCouverture;

    @ManyToOne
    @JoinColumn(name = "evenement")
    private Evenement evenement ;
}
