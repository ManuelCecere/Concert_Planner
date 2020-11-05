package com.concertPlanner.tests;

import com.concertPlanner.model.Instruments;
import com.concertPlanner.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;
    @BeforeEach
    void setUp() {
        player=new Player("Manuel","Cecere", Instruments.SECONDO_CLARINETTO,true);
    }

    @Test
    void getName() {
        assertEquals("Manuel",player.getName());
    }

    @Test
    void setName() {
        player.setName("Marco");
        assertEquals("Marco",player.getName());
    }

    @Test
    void getSurname() {
        assertEquals("Cecere",player.getSurname());
    }

    @Test
    void setSurname() {
        player.setSurname("Rossi");
        assertEquals("Rossi",player.getSurname());
    }

    @Test
    void getInstrument() {
        assertEquals(Instruments.SECONDO_CLARINETTO,player.getInstrument());
    }

    @Test
    void setInstrument() {
        player.setInstrument(Instruments.BATTERIA);
        assertEquals(Instruments.BATTERIA,player.getInstrument());

    }

    @Test
    void isAvailable() {
        assertTrue(player.isAvailable());
    }

    @Test
    void setAvailable() {
        player.setAvailable(false);
        assertFalse(player.isAvailable());
    }
}