package com.vodafone.imdb.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

/************************
 *    13.06.2020  *
 *    hatipaksunger  *
 ************************/
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActorFilmRelation {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    Actor_Actress actorActress;
    @OneToOne
    Film_TvSeries filmTVSeries;
    private String job;
    private String category;
    @Lob
    private ArrayList<String> caracters;

}
