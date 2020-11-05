package com.concertPlanner.controller;

import com.concertPlanner.model.*;
import com.concertPlanner.view.MainFrame;

import java.util.List;

public class Controller {
    private PlayersManager playersManager;
    private TracksCatalogue tracksCatalogue;
    private MainFrame mainFrame;



    public Controller(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        playersManager=PlayersManager.getInstance();
        tracksCatalogue=TracksCatalogue.getInstance(playersManager);
    }

    public boolean istrackDoable(int index) {
        return tracksCatalogue.isTrackDoable(index);
    }

    public Object[] getPlayerInfos(){
        List<String> lists= playersManager.getInfoList();
        return lists.toArray();
        }

    public Object[] getTrackNames(){
        List<String> lists=tracksCatalogue.getNamesList();
        return lists.toArray();
    }

    public void addPlayer(String name, String surname, Instruments instrument, boolean available){
        Player player=new Player(name,surname,instrument,available);
        playersManager.addPlayer(player);
        mainFrame.refresh();
    }

    public void modifyPlayer(String name, String surname, Instruments instrument, boolean available,int playerIndex){
        playersManager.modifyPlayer(name,surname,instrument,available,playerIndex);
        mainFrame.refresh();
    }

    public void removePlayer(int playerIndex){
        playersManager.removePlayer(playerIndex);
        mainFrame.refresh();
    }

    public String getPlayerName(int playerIndex) {
        return playersManager.getPlayerName(playerIndex);
    }

    public String getPlayerSurname(int playerIndex) {

        return playersManager.getPlayerSurname(playerIndex);
    }

    public Instruments getPlayerInstrument(int playerIndex) {
        return playersManager.getPlayerInstrument(playerIndex);
    }

    public boolean isPlayerAvailable(int playerIndex){
        return playersManager.isPlayerAvailable(playerIndex);
    }

    public List<Condition> getConditionList(int trackIndex){
        return tracksCatalogue.getConditionList(trackIndex);
    }

    public void addTrack(Track track){
        tracksCatalogue.addTrack(track);
        mainFrame.refresh();
    }

    public String getTrackName(int trackIndex){
        return tracksCatalogue.getTrackName(trackIndex);
    }

    public void modifyTrack(Track track, int trackIndex){
        tracksCatalogue.modifyTrack(track, trackIndex);
        mainFrame.refresh();
    }

    public void removeTrack(int trackIndex){
        tracksCatalogue.removeTrack(trackIndex);
        mainFrame.refresh();
    }

    public void modelInit(){
        tracksCatalogue.update(playersManager,null);
    }
    }

