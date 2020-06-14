package com.vodafone.imdb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/************************
 *    13.06.2020  *
 *    hatipaksunger  *
 ************************/
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Film_TvSeries implements Serializable  {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    @Column(unique = true)
    private String primaryTitle;
    @Column(unique = true)
    private String originalTitle;
    private boolean isAdult;
    private Integer startYear;
    private Integer endYear;
    @JsonFormat(pattern="hh:mm:dd")
    @DateTimeFormat(pattern="hh:mm:ss" )
    @Temporal(TemporalType.TIME)
    private Date runtimeMinutes;

    @Lob
    private ArrayList<String> genres;

}
