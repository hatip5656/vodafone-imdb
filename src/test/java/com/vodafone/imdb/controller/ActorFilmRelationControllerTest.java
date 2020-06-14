package com.vodafone.imdb.controller;

import com.vodafone.imdb.model.ActorFilmRelation;
import com.vodafone.imdb.model.Actor_Actress;
import com.vodafone.imdb.model.Film_TvSeries;
import com.vodafone.imdb.repository.ActorFilmRelationRepository;
import com.vodafone.imdb.repository.ActorOrActressRepository;
import com.vodafone.imdb.repository.FilmOrTvSeriesRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

/************************
 *    13.06.2020  *
 *    hatipaksunger  *
 ************************/
public class ActorFilmRelationControllerTest {
    @Mock
    ActorFilmRelationRepository repo;
    @Mock
    ActorOrActressRepository actorRepo;
    @Mock
    FilmOrTvSeriesRepository filmRepo;

    @InjectMocks
    ActorFilmRelationController actorFilmRelationController;

    Actor_Actress actorActress = new Actor_Actress(1,"John Doe",1992,null,new ArrayList<>());
    Film_TvSeries filmTvSeries = new Film_TvSeries(1,"Film","Harry Potter","Harry Potter",false,2004,null,new Date(),new ArrayList<>());
    ActorFilmRelation actorF = new ActorFilmRelation(1, actorActress, filmTvSeries,"Actor","Action",new ArrayList<String>());
    Actor_Actress actorActress2 = new Actor_Actress(2,"John Wick",1990,null,new ArrayList<>());
    ActorFilmRelation actorF2 = new ActorFilmRelation(1, actorActress2, filmTvSeries,"Actor","Action",new ArrayList<String>());
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        List<ActorFilmRelation> actorFilmRelations = new ArrayList<>();
        List<ActorFilmRelation> actorFilmRelations2 = new ArrayList<>();
        actorFilmRelations.add(actorF);
        actorFilmRelations2.add(actorF2);
        when(repo.save(any())).thenReturn(actorF);
        when(repo.findAll()).thenReturn(actorFilmRelations);
        when(repo.findByActorActress_Id(1L)).thenReturn(actorFilmRelations);
        when(repo.findByActorActress_Id(2L)).thenReturn(actorFilmRelations2);
        when(repo.findByFilmTVSeries_Id(any())).thenReturn(actorFilmRelations);
        when(actorRepo.findByPrimaryName("John Doe")).thenReturn(actorActress);
        when(actorRepo.findByPrimaryName("John Wick")).thenReturn(actorActress2);
        when(filmRepo.findByPrimaryTitle(anyString())).thenReturn(filmTvSeries);

    }

    @Test
    public void testCreate() throws Exception {
        Object result = actorFilmRelationController.create(actorF);
        Assert.assertEquals(actorF,  result);
    }

    @Test
    public void testDelete() throws Exception {
        String result = actorFilmRelationController.delete(new ActorFilmRelation());
        verify(repo,times(1)).delete(any());
    }

    @Test
    public void testList() throws Exception {
        Object result = actorFilmRelationController.list();
        Assert.assertEquals(actorF.getId(), ((List<ActorFilmRelation>) result).get(0).getId());
    }
    @Test
    public void testFindAllByActor() throws Exception {
        Object result = actorFilmRelationController.findAllByActor(actorActress.getPrimaryName());
        Assert.assertEquals(actorF.getActorActress().getId(), ((List<ActorFilmRelation>) result).get(0).getActorActress().getId());
    }
    @Test
    public void testFindAllByFilm() throws Exception {
        Object result = actorFilmRelationController.findAllByFilm(filmTvSeries.getPrimaryTitle());
        Assert.assertEquals(actorF.getFilmTVSeries().getId(), ((List<ActorFilmRelation>) result).get(0).getFilmTVSeries().getId());
    }
    @Test
    public void testFindAllByActorsBothIncluded() throws Exception {
        Object result = actorFilmRelationController.findAllByActorsBothIncluded("John Doe","John Wick");
        Assert.assertEquals(filmTvSeries, ((List<Film_TvSeries>) result).get(0));
    }
}

