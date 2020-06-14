package com.vodafone.imdb.controller;

import com.vodafone.imdb.model.Actor_Actress;
import com.vodafone.imdb.repository.ActorOrActressRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

/************************
 *    13.06.2020  *
 *    hatipaksunger  *
 ************************/
public class ActorActressControllerTest {
    @Mock
    ActorOrActressRepository repo;
    @InjectMocks
    ActorOrActressController actorOrActressController;
    Actor_Actress actorActress = new Actor_Actress(1,"John Doe",1990,null,new ArrayList<>());
    ArrayList<Actor_Actress> actorActresses = new ArrayList<>();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        actorActresses.add(actorActress);
        when(repo.save(actorActress)).thenReturn(actorActress);
        when(repo.findAll()).thenReturn(actorActresses);
    }

    @Test
    public void testCreate() throws Exception {
        Object result = actorOrActressController.create(actorActress);
        Assert.assertEquals(actorActress, result);
    }

    @Test
    public void testDelete() throws Exception {
        String result = actorOrActressController.delete(actorActress);
      verify(repo,times(1)).delete(actorActress);
    }

    @Test
    public void testList() throws Exception {
        Object result = actorOrActressController.list();
        Assert.assertEquals(actorActresses, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme