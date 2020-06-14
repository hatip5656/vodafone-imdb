package com.vodafone.imdb.controller;

import com.vodafone.imdb.model.ActorFilmRelation;
import com.vodafone.imdb.model.Actor_Actress;
import com.vodafone.imdb.model.Film_TvSeries;
import com.vodafone.imdb.repository.ActorFilmRelationRepository;
import com.vodafone.imdb.repository.ActorOrActressRepository;
import com.vodafone.imdb.repository.FilmOrTvSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/************************
 *    13.06.2020  *
 *    hatipaksunger  *
 ************************/
@RestController
@RequestMapping("/actorFilmRelation")
public class ActorFilmRelationController {

    @Autowired
    ActorFilmRelationRepository repo;

    @Autowired
    ActorOrActressRepository actorRepo;

    @Autowired
    FilmOrTvSeriesRepository filmRepo;

    @PostMapping("/save")
    public Object create(@RequestBody ActorFilmRelation model) {
        try {
            return repo.save(model);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestBody ActorFilmRelation model) {
        try {
            repo.delete(model);
            return "Field with ID: " + model.getId() + " is deleted.";
        } catch (Exception e) {
            e.printStackTrace();
            return "error occurred please check logs";
        }
    }

    @GetMapping("/list")
    public Object list() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/findAllByActor")
    public Object findAllByActor(@RequestParam String actorName) {
        try {
            Actor_Actress model = actorRepo.findByPrimaryName(actorName);
            return repo.findByActorActress_Id(model.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/findAllByFilm")
    public Object findAllByFilm(@RequestParam String filmTitle) {
        try {
            Film_TvSeries model = filmRepo.findByPrimaryTitle(filmTitle);
            return repo.findByFilmTVSeries_Id(model.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/findAllByActorsBothIncluded")
    public Object findAllByActorsBothIncluded(@RequestParam String actor1, @RequestParam String actor2) {
        try {
            List<Film_TvSeries> result = new ArrayList<>();

            Actor_Actress actorActress1 = actorRepo.findByPrimaryName(actor1);
            Actor_Actress actorActress2 = actorRepo.findByPrimaryName(actor2);
            List<ActorFilmRelation> actorFilmRelations1 = repo.findByActorActress_Id(actorActress1.getId());
            List<ActorFilmRelation> actorFilmRelations2 = repo.findByActorActress_Id(actorActress2.getId());

            for (ActorFilmRelation filmRelation1 : actorFilmRelations1) {
                for (ActorFilmRelation filmRelation2 : actorFilmRelations2) {
                    if (filmRelation1.getFilmTVSeries() == filmRelation2.getFilmTVSeries()) {
                        result.add(filmRelation1.getFilmTVSeries());
                    }
                }
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
