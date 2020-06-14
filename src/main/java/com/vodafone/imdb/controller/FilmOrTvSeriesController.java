package com.vodafone.imdb.controller;

import com.vodafone.imdb.model.Film_TvSeries;
import com.vodafone.imdb.repository.FilmOrTvSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/************************
 *    13.06.2020  *
 *    hatipaksunger  *
 ************************/
@RestController
@RequestMapping("/filmOrTvSeries")
public class FilmOrTvSeriesController {
    @Autowired
    FilmOrTvSeriesRepository repo;

    @PostMapping("/save")
    public Object create(@RequestBody Film_TvSeries model ){
        try {
            return repo.save(model);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @PostMapping("/delete")
    public String delete(@RequestBody Film_TvSeries model) {
        try {
            repo.delete(model);
            return "Field with ID: "+ model.getId() +" is deleted.";
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
}
