package com.mineviet.siegebattle.core.arena;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.List;

public class Arena {
    
    private String name;
    private Location lobbyLocation;
    private Location teamALocation;
    private Player teamACaptain;
    private Location teamBLocation;
    private Location deathLocation;
    private int teamSize;
    private List<Player> players;
    private Location bauVatLocation;
    private ArenaState arenaState;
    private Location corner1;
    private Location corner2;
    private World world;

    /**
     * @param name
     * @param teamSize
     */
    public Arena(String name, int teamSize) {
        this.name = name;
        this.teamSize = teamSize;
    }

    public Arena() {
    }

    public Arena(String name, Location lobbyLocation, Location teamALocation, Location teamBLocation, Location deathLocation, int size, Location bauVatSpawn, Location corner1, Location corner2, World world) {
        this.name = name;
        this.lobbyLocation = lobbyLocation;
        this.teamALocation = teamALocation;
        this.teamBLocation = teamBLocation;
        this.deathLocation = deathLocation;
        this.teamSize = size;
        this.bauVatLocation = bauVatSpawn;
        this.arenaState = ArenaState.WAITING;
        this.corner1 = corner1;
        this.corner2 = corner2;
        this.world = world;
    }

    // check thử coi người chơi đó đã tạo thành công arena với các thông số đã đưa
    public boolean isComplete() {
        return name != null && lobbyLocation != null && teamALocation != null
                && teamBLocation != null && deathLocation != null && bauVatLocation != null;
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

    public Location getDeathLocation() {
        return deathLocation;
    }

    public void setDeathLocation(Location deathLocation) {
        this.deathLocation = deathLocation;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }


    public List<Player> getPlayers() {
        return players;
    }


    public Location getBauVatLocation() {
        return bauVatLocation;
    }

    public void setBauVatLocation(Location bauVatLocation) {
        this.bauVatLocation = bauVatLocation;
    }

    public void setArenaState(ArenaState state) {
        if (arenaState == state) return;
        this.arenaState = state;
    }

    public ArenaState getArenaState() {
        return this.arenaState;
    }

    public Location getCorner1() {
        return corner1;
    }

    public void setCorner1(Location corner1) {
        this.corner1 = corner1;
    }

    public Location getCorner2() {
        return corner2;
    }

    public void setCorner2(Location corner2) {
        this.corner2 = corner2;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void sendMessage(String s) {
        for (Player p : getPlayers()) {
            p.sendMessage(s);
        }
    }

}
