package com.vodafone.imdb.controller;

import com.vodafone.imdb.model.Film_TvSeries;
import com.vodafone.imdb.repository.FilmOrTvSeriesRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.*;

/************************
 *    13.06.2020  *
 *    hatipaksunger  *
 ************************/
public class FilmTvSeriesControllerTest {
    @Mock
    FilmOrTvSeriesRepository repo;
    @InjectMocks
    FilmOrTvSeriesController filmOrTvSeriesController;
    Film_TvSeries filmTvSeries = new Film_TvSeries(1, "Film", "Harry Potter", "Harry Potter", false, 2004, null, new Date(), new ArrayList<>());
    ArrayList<Film_TvSeries> filmTvSeriesList = new ArrayList<>();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        filmTvSeriesList.add(filmTvSeries);
        when(repo.save(filmTvSeries)).thenReturn(filmTvSeries);
        when(repo.findAll()).thenReturn(filmTvSeriesList);
    }

    @Test
    public void testCreate() throws Exception {
        Object result = filmOrTvSeriesController.create(filmTvSeries);
        Assert.assertEquals(filmTvSeries, result);
    }

    @Test
    public void testDelete() throws Exception {
        String result = filmOrTvSeriesController.delete(filmTvSeries);
        verify(repo,times(1)).delete(filmTvSeries);
    }

    @Test
    public void testList() throws Exception {
        Object result = filmOrTvSeriesController.list();
        Assert.assertEquals(filmTvSeriesList, filmTvSeriesList);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme