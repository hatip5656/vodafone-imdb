package com.vodafone.imdb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
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
public class Actor_Actress implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String primaryName;
    private Integer birthYear;
    private Integer deathYear;
    @Lob
    public ArrayList<String> primaryProfessions;


}
