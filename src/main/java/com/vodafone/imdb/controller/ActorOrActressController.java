package com.vodafone.imdb.controller;

import com.vodafone.imdb.model.Actor_Actress;
import com.vodafone.imdb.repository.ActorOrActressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/************************
 *    13.06.2020  *
 *    hatipaksunger  *
 ************************/
@RestController
@RequestMapping("/actorOrActress")
public class ActorOrActressController {
    @Autowired
    ActorOrActressRepository repo;

    @PostMapping("/save")
    public Object create(@RequestBody Actor_Actress model ){
        try {
            return repo.save(model);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @PostMapping("/delete")
    public String delete(@RequestBody Actor_Actress model) {
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
