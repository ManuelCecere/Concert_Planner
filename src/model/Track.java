package com.concertPlanner.model;

import java.util.List;

public class Track {
    private String name;
    private List<Condition> conditions;
    private boolean doable;

    public Track(String name, List<Condition> conditions) {
        this.name = name;
        this.conditions = conditions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }
    public boolean isDoable() {
        return doable;
    }

    public void setDoable(boolean doable) {
        this.doable = doable;
    }
}
