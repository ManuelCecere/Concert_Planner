package com.concertPlanner.model;

public class Condition {
    private int countInstruments;
    private Instruments typeOfInstrument;

    public Condition(int countInstruments, Instruments typeOfInstrument) {
        this.countInstruments = countInstruments;
        this.typeOfInstrument = typeOfInstrument;
    }

    public int getCountInstruments() {
        return countInstruments;
    }

    public void setCountInstruments(int countInstruments) {
        this.countInstruments = countInstruments;
    }

    public Instruments getTypeOfInstrument() {
        return typeOfInstrument;
    }

    public void setTypeOfInstrument(Instruments typeOfInstrument) {
        this.typeOfInstrument = typeOfInstrument;
    }
}
