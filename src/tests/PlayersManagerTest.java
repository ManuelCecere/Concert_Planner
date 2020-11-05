package com.concertPlanner.tests;

import com.concertPlanner.model.Instruments;
import com.concertPlanner.model.Player;
import com.concertPlanner.model.PlayersManager;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class PlayersManagerTest {
    private PlayersManager playersManager;
    @BeforeEach
    void setUp() {
        playersManager= PlayersManager.getInstance();
        playersManager.clearAll();
        playersManager.addPlayer(new Player("Manuel","Cecere Palazzo",Instruments.SECONDO_CLARINETTO,true));
        playersManager.addPlayer(new Player("Mario","Rossi",Instruments.SECONDO_SAX,true));
    }

    @Test
    void getInstance() {
        assertEquals(playersManager,PlayersManager.getInstance());
    }

    @Test
    void getInfoList() {
        List<String> strings = new ArrayList<>();
        strings.add("Manuel Cecere Palazzo, secondo_clarinetto, presente");
        strings.add("Mario Rossi, secondo_sax, presente");
        assertEquals(strings, playersManager.getInfoList());
    }

    @Test
    void getPlayerName() {
        assertEquals("Mario",playersManager.getPlayerName(1));
    }

    @Test
    void getPlayerSurname() {
        assertEquals("Rossi",playersManager.getPlayerSurname(1));
    }

    @Test
    void getPlayerInstrument() {
        assertEquals(Instruments.SECONDO_SAX,playersManager.getPlayerInstrument(1));
    }

    @Test
    void isPlayerAvailable() {
        assertTrue(playersManager.isPlayerAvailable(0));
    }

    @Test
    void getPlayersLenght() {
        assertEquals(2,playersManager.getPlayersLenght());
    }

    @Test
    void modifyPlayer() {
        playersManager.modifyPlayer("Giuseppe","Esposito",Instruments.CASSA,false,1);
        assertEquals("Giuseppe",playersManager.getPlayerName(1));
        assertEquals("Esposito",playersManager.getPlayerSurname(1));
        assertEquals(Instruments.CASSA,playersManager.getPlayerInstrument(1));
        assertFalse(playersManager.isPlayerAvailable(1));
    }

    @Test
    void addAndRemovePlayer() {
        Player player = new Player("Marco","Bianchi", Instruments.FLAUTO, true);
        playersManager.addPlayer(player);
        assertEquals("Marco",playersManager.getPlayerName(2));
        assertEquals("Bianchi",playersManager.getPlayerSurname(2));
        assertEquals(Instruments.FLAUTO,playersManager.getPlayerInstrument(2));
        assertTrue(playersManager.isPlayerAvailable(2));
    }

    @Test
    void removePlayer() {
        playersManager.removePlayer(0);
        assertEquals(1,playersManager.getPlayersLenght());
        assertEquals("Mario",playersManager.getPlayerName(0));
        assertEquals("Rossi",playersManager.getPlayerSurname(0));
        assertEquals(Instruments.SECONDO_SAX,playersManager.getPlayerInstrument(0));
        assertTrue(playersManager.isPlayerAvailable(0));

    }

    @Test
    void ClearAll() {
        playersManager.clearAll();
        assertEquals(0,playersManager.getPlayersLenght());
    }
}