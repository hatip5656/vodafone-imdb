package com.vodafone.imdb.repository;

import com.vodafone.imdb.model.Actor_Actress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/************************
 *    13.06.2020  *
 *    hatipaksunger  *
 ************************/
@Repository
public interface ActorOrActressRepository extends JpaRepository<Actor_Actress,Long> {
   Actor_Actress findByPrimaryName(String name);

}
