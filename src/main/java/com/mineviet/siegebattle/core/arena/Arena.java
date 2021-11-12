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
    private int minPlayers;
    private int maxPlayers;
    private List<Player> players;
    private Location bauVatSpawn;
    private ArenaState arenaState;
    private Location corner1;
    private Location corner2;
    private World world;

    /**
     * @param name generate an arenas when create only for the name
     */
    public Arena(String name) {
        this.name = name;
    }

    public Arena() {
    }

    public Arena(String name, Location lobbyLocation, Location teamALocation, Location teamBLocation, Location deathLocation, int minPlayers, int maxPlayers, Location bauVatSpawn, Location corner1, Location corner2, World world) {
        this.name = name;
        this.lobbyLocation = lobbyLocation;
        this.teamALocation = teamALocation;
        this.teamBLocation = teamBLocation;
        this.deathLocation = deathLocation;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.bauVatSpawn = bauVatSpawn;
        this.arenaState = ArenaState.WAITING;
        this.corner1 = corner1;
        this.corner2 = corner2;
        this.world = world;
    }

    // check thử coi người chơi đó đã tạo thành công arena với các thông số đã đưa
    public boolean isComplete() {
        return name != null && lobbyLocation != null && teamALocation != null
                && teamBLocation != null && deathLocation != null && bauVatSpawn != null;
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

    public List<Player> getPlayers() {
        return players;
    }


    public Location getBauVatSpawn() {
        return bauVatSpawn;
    }

    public void setBauVatSpawn(Location bauVatSpawn) {
        this.bauVatSpawn = bauVatSpawn;
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
