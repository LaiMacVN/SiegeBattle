package com.mineviet.siegebattle.core.arena;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public class Arena {
    
    private String name;
    private Location lobbyLocation;
    private Location teamALocation;
    private Player teamACaptain;
    private Location teamBLocation;
    private int minPlayers;
    private int maxPlayers;
    private List<String> players;
    private Location bauVatSpawn;

    public Arena() {
    }

    public Arena(String name, Location lobbyLocation, Location teamALocation, Player teamACaptain, Location teamBLocation, int minPlayers, int maxPlayers, List<String> players, Location bauVatSpawn) {
        this.name = name;
        this.lobbyLocation = lobbyLocation;
        this.teamALocation = teamALocation;
        this.teamACaptain = teamACaptain;
        this.teamBLocation = teamBLocation;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.players = players;
        this.bauVatSpawn = bauVatSpawn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLobbyLocation() {
        return lobbyLocation;
    }

    public void setLobbyLocation(Location lobbyLocation) {
        this.lobbyLocation = lobbyLocation;
    }

    public Location getTeamALocation() {
        return teamALocation;
    }

    public void setTeamALocation(Location teamALocation) {
        this.teamALocation = teamALocation;
    }

    public Player getTeamACaptain() {
        return teamACaptain;
    }

    public void setTeamACaptain(Player teamACaptain) {
        this.teamACaptain = teamACaptain;
    }

    public Location getTeamBLocation() {
        return teamBLocation;
    }

    public void setTeamBLocation(Location teamBLocation) {
        this.teamBLocation = teamBLocation;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public Location getBauVatSpawn() {
        return bauVatSpawn;
    }

    public void setBauVatSpawn(Location bauVatSpawn) {
        this.bauVatSpawn = bauVatSpawn;
    }

}
