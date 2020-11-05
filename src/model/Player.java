package com.concertPlanner.model;

public class Player {

    private String name;
    private String surname;
    private Instruments instrument;
    private boolean available;

    public Player(String name, String surname, Instruments instrument, boolean available) {
        this.name = name;
        this.surname = surname;
        this.instrument = instrument;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Instruments getInstrument() {
        return instrument;
    }

    public void setInstrument(Instruments instrument) {
        this.instrument = instrument;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
