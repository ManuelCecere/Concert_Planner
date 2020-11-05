package com.concertPlanner.tests;

import com.concertPlanner.model.Condition;
import com.concertPlanner.model.Instruments;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConditionTest {
    private Condition condition;
    @BeforeEach
    void setUp() {
        condition = new Condition(2, Instruments.SECONDA_TROMBA);
    }

    @Test
    void getCountInstruments() {
        assertEquals(2,condition.getCountInstruments());
    }

    @Test
    void setCountInstruments() {
        condition.setCountInstruments(4);
        assertEquals(4,condition.getCountInstruments());
    }

    @Test
    void getTypeOfInstrument() {
        assertEquals(Instruments.SECONDA_TROMBA,condition.getTypeOfInstrument());
    }

    @Test
    void setTypeOfInstrument() {
        condition.setTypeOfInstrument(Instruments.PRIMO_FLICORNO);
        assertEquals(Instruments.PRIMO_FLICORNO,condition.getTypeOfInstrument());
    }
}