package com.concertPlanner.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PlayersManager extends Observable {
    private List<Player> players;
    private static PlayersManager instance= null;

    //Item 3
    private PlayersManager() {
        this.players = new ArrayList<>();
        players.add(new Player("Manuel","Cecere Palazzo",Instruments.PRIMO_CLARINETTO,true));
        players.add(new Player("Mario","Rossi",Instruments.PRIMO_SAX,true));
        players.add(new Player("Buddy","Rich",Instruments.BATTERIA,false));


    }

    public static PlayersManager getInstance(){
            if(instance==null){
                instance = new PlayersManager();
            }
            return instance;
    }

    public void addPlayer(Player player){
        players.add(player);
        setChanged();
        notifyObservers();
    }

    public void modifyPlayer(String name, String surname, Instruments instrument, boolean available, int playerIndex){
        Player player=players.get(playerIndex);
        player.setName(name);
        player.setSurname(surname);
        player.setInstrument(instrument);
        player.setAvailable(available);
        setChanged();
        notifyObservers();
        }

    public void removePlayer(int playerIndex){
        players.remove(players.get(playerIndex));
        setChanged();
        notifyObservers();
    }

    public List<String> getInfoList(){
        List<String> strings = new ArrayList<>();
        for (Player player:players
             ) {
            String available=player.isAvailable()?"presente":"assente";
            strings.add(player.getName()+" "+player.getSurname()+", "+player.getInstrument().toString().toLowerCase()+", "+available);

        }
        return strings;
    }

    public String getPlayerName (int playerIndex){
        return players.get(playerIndex).getName();
    }

    public String getPlayerSurname (int playerIndex){
        return players.get(playerIndex).getSurname();
    }

    public Instruments getPlayerInstrument (int playerIndex){
        return players.get(playerIndex).getInstrument();
    }

    public boolean isPlayerAvailable ( int playerIndex){
        return players.get(playerIndex).isAvailable();
    }

    public int getPlayersLenght(){
        return players.size();
    }

    public void clearAll(){
        players.clear();
        setChanged();
        notifyObservers();
    }
    }



