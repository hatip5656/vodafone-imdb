package com.vodafone.imdb.repository;

import com.vodafone.imdb.model.ActorFilmRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/************************
 *    13.06.2020  *
 *    hatipaksunger  *
 ************************/
@Repository
public interface ActorFilmRelationRepository extends JpaRepository<ActorFilmRelation,Long> {
    List<ActorFilmRelation> findByActorActress_Id(Long id);
    List<ActorFilmRelation> findByFilmTVSeries_Id(Long id);
}
