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
    private double prix;

    @Column(name = "description")
    private double description;

    @Column(name = "imageCouverture")
    private String imageCouverture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evenement")
    private Evenement evenement ;
}
