package com.concertPlanner.tests;

import com.concertPlanner.model.Condition;
import com.concertPlanner.model.Instruments;
import com.concertPlanner.model.Track;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {
    private Track track;
    private List<Condition> conditions;

    @BeforeEach
    void setUp() {
        conditions = new ArrayList<>();
        conditions.add(new Condition(2, Instruments.CASSA));
        conditions.add(new Condition(1,Instruments.BATTERIA));
        track= new Track("Omaggio a Morricone",new ArrayList<>(conditions));
    }
    @Test
    void getConditions() {
        assertEquals(conditions,track.getConditions());
    }

    @Test
    void getName() {
        assertEquals("Omaggio a Morricone",track.getName());
    }

    @Test
    void setName() {
        track.setName("Libertango");
        assertEquals("Libertango",track.getName());
    }

    @Test
    void setConditions() {
        conditions = new ArrayList<>();
        conditions.add(new Condition(1, Instruments.PRIMO_CLARINETTO));
        conditions.add(new Condition(1,Instruments.PRIMO_SAX));
        track.setConditions(new ArrayList<>(conditions));
        assertEquals(conditions,track.getConditions());
    }

    @Test
    void isDoable() {
        assertFalse(track.isDoable());
    }

    @Test
    void setDoable() {
        track.setDoable(true);
        assertTrue(track.isDoable());
    }
}