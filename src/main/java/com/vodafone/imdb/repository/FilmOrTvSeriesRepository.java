package com.vodafone.imdb.repository;

import com.vodafone.imdb.model.Film_TvSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/************************
 *    13.06.2020  *
 *    hatipaksunger  *
 ************************/
@Repository
public interface FilmOrTvSeriesRepository extends JpaRepository<Film_TvSeries,Long> {
    Film_TvSeries findByPrimaryTitle(String title);

}
