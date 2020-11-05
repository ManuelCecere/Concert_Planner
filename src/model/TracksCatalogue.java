package com.concertPlanner.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class TracksCatalogue implements Observer {
    private List<Track> tracks;
    private static TracksCatalogue instance = null;
    private PlayersManager playersManager;

    private TracksCatalogue(PlayersManager observable) {
        tracks = new ArrayList<>();
        List<Condition> c1 = new ArrayList<>();
        c1.add(new Condition(1, Instruments.PRIMO_CLARINETTO));
        List<Condition> c2 = new ArrayList<>();
        c2.add(new Condition(2, Instruments.PRIMA_TROMBA));
        List<Condition> c3 = new ArrayList<>();
        c3.add(new Condition(1, Instruments.PRIMO_SAX));
        tracks.add(new Track("Nettuno", c1));
        tracks.add(new Track("Memory", c2));
        tracks.add(new Track("Danza Ungherese", c3));
        observable.addObserver(this);
        playersManager = observable;

    }

    public static TracksCatalogue getInstance(PlayersManager observable) {
        if (instance == null) {
            instance = new TracksCatalogue(observable);
        }
        return instance;
    }


    public void modifyTrack(Track newTrack, int trackIndex) {
        Track oldTrack = tracks.get(trackIndex);
        oldTrack.setConditions(newTrack.getConditions());
        oldTrack.setName(newTrack.getName());
        update(playersManager, null);
    }


    public void removeTrack(int trackIndex) {
        tracks.remove(trackIndex);
        update(playersManager, null);
    }


    public void addTrack(Track track) {
        tracks.add(track);
        update(playersManager, null);
    }

    public List<String> getNamesList() {
        List<String> strings = new ArrayList<>();
        for (Track track : tracks
        ) {
            strings.add(track.getName());
        }
        return strings;
    }

    public List<Condition> getConditionList(int trackIndex) {
        List<Condition> list = new ArrayList<>();
        Track track = tracks.get(trackIndex);
            for (Condition condition : track.getConditions()){
                list.add(new Condition(condition.getCountInstruments(),condition.getTypeOfInstrument()));
            }
        return list;
    }

    public String getTrackName(int trackIndex) {
        return tracks.get(trackIndex).getName();
    }

    public boolean isTrackDoable(int trackIndex) {
        return tracks.get(trackIndex).isDoable();
    }


    @Override
    public void update(Observable o, Object arg) {
        for (Track track : tracks) {
            track.setDoable(true);
            for (Condition condition : track.getConditions()) {
                int instrumentCount = condition.getCountInstruments();
                for (int i = 0; i < playersManager.getPlayersLenght(); i++) {
                    if (condition.getTypeOfInstrument() == playersManager.getPlayerInstrument(i)
                            && playersManager.isPlayerAvailable(i)) {
                        instrumentCount--;
                    }
                }
                if (instrumentCount > 0) {
                    track.setDoable(false);
                }
            }
        }

    }

    public void clearAll(){
        tracks.clear();
        update(playersManager,null);
    }
}