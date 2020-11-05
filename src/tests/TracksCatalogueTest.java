package com.concertPlanner.tests;

import com.concertPlanner.model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TracksCatalogueTest {
    private TracksCatalogue tracksCatalogue;
    private PlayersManager playersManager;

    @BeforeEach
    void setUp() {
        playersManager = PlayersManager.getInstance();
        tracksCatalogue = TracksCatalogue.getInstance(playersManager);
        tracksCatalogue.clearAll();
        List<Condition> c1 = new ArrayList<>();
        c1.add(new Condition(1, Instruments.SECONDO_CLARINETTO));
        List<Condition> c2 = new ArrayList<>();
        c2.add(new Condition(2, Instruments.SECONDA_TROMBA));
        List<Condition> c3 = new ArrayList<>();
        c3.add(new Condition(1, Instruments.PRIMO_SAX));
        tracksCatalogue.addTrack(new Track("Nettuno", c1));
        tracksCatalogue.addTrack(new Track("Memory", c2));
        tracksCatalogue.addTrack(new Track("Danza Ungherese", c3));
    }

    @Test
    void getInstance() {
        assertEquals(tracksCatalogue,TracksCatalogue.getInstance(playersManager));
    }

    @Test
    void update() {
        playersManager.removePlayer(0);
        assertFalse(tracksCatalogue.isTrackDoable(0));
    }

    @Test
    void getNamesList() {
        List<String> strings = new ArrayList<>();
        strings.add("Nettuno");
        strings.add("Memory");
        strings.add("Danza Ungherese");
        assertEquals(strings,tracksCatalogue.getNamesList());

    }

    @Test
    void getConditionList() {
         Condition condition = tracksCatalogue.getConditionList(1).get(0);
         assertEquals(2,condition.getCountInstruments());
         assertEquals(Instruments.SECONDA_TROMBA,condition.getTypeOfInstrument());

    }

    @Test
    void getTrackName() {
        assertEquals("Danza Ungherese",tracksCatalogue.getTrackName(2));
    }

    @Test
    void isTrackDoable() {
        tracksCatalogue.update(playersManager,null);
        assertTrue(tracksCatalogue.isTrackDoable(2));
    }


    @Test
    void modifyTrack() {
        List<Condition> conditions = new ArrayList<>();
        conditions.add(new Condition(2, Instruments.CASSA));
        conditions.add(new Condition(1,Instruments.BATTERIA));
        Track track = new Track("Omaggio a Morricone", conditions);
        tracksCatalogue.modifyTrack(track,2);
        Condition c1 = tracksCatalogue.getConditionList(2).get(0);
        Condition c2 = tracksCatalogue.getConditionList(2).get(1);
        assertEquals("Omaggio a Morricone",tracksCatalogue.getTrackName(2));
        assertEquals(2,c1.getCountInstruments());
        assertEquals(Instruments.CASSA,c1.getTypeOfInstrument());
        assertEquals(1,c2.getCountInstruments());
        assertEquals(Instruments.BATTERIA,c2.getTypeOfInstrument());
        assertFalse(tracksCatalogue.isTrackDoable(2));
    }

    @Test
    void removeTrack() {
        tracksCatalogue.removeTrack(1);
        Condition c = tracksCatalogue.getConditionList(1).get(0);
        assertEquals(2,tracksCatalogue.getNamesList().size());
        assertEquals("Danza Ungherese",tracksCatalogue.getTrackName(1));
        assertEquals(1,c.getCountInstruments());
        assertEquals(Instruments.PRIMO_SAX,c.getTypeOfInstrument());
    }

    @Test
    void addTrack() {
        List<Condition> conditions = new ArrayList<>();
        conditions.add(new Condition(2, Instruments.CASSA));
        conditions.add(new Condition(1,Instruments.BATTERIA));
        Track track = new Track("Omaggio a Morricone", conditions);
        tracksCatalogue.addTrack(track);
        Condition c1 = tracksCatalogue.getConditionList(3).get(0);
        Condition c2 = tracksCatalogue.getConditionList(3).get(1);
        assertEquals("Omaggio a Morricone",tracksCatalogue.getTrackName(3));
        assertEquals(2,c1.getCountInstruments());
        assertEquals(Instruments.CASSA,c1.getTypeOfInstrument());
        assertEquals(1,c2.getCountInstruments());
        assertEquals(Instruments.BATTERIA,c2.getTypeOfInstrument());
        assertFalse(tracksCatalogue.isTrackDoable(3));
        assertEquals(4,tracksCatalogue.getNamesList().size());
    }

    @Test
    void ClearAll() {
        tracksCatalogue.clearAll();
        assertEquals(0,tracksCatalogue.getNamesList().size());
    }


}