package com.mineviet.siegebattle.core.arena;

import com.mineviet.siegebattle.core.player.PlayerManager;
import com.mineviet.siegebattle.core.player.PlayerState;
import com.mineviet.siegebattle.util.Strings;
import com.mineviet.siegebattle.util.Values;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Arena {
    
    private String name;
    private Location spawn;
    private Location spawnDef;
    private Location spawnEn;
    private int minPlayer;
    private List<String> players;
    private ArenaState as = ArenaState.WAITING;
    
    public Arena(String name, Location spawn, Location spawnDef, Location spawnEn, int minPlayer) {
        this.name = name;
        this.spawn = spawn;
        this.spawnDef = spawnDef;
        this.spawnEn = spawnEn;
        this.minPlayer = minPlayer;
        players = new ArrayList<>();
    }
    
    public void addPlayer(Player p) {
        if (PlayerManager.getPlayerState(p) != PlayerState.WAITING) {
            p.sendMessage(Strings.chatPrefix(Values.JOIN_FROM_ANOTHER));
            return;
        }
        if (as != ArenaState.WAITING && as != ArenaState.STARTING) {
            p.sendMessage(Strings.chatPrefix(Values.ARENA_STARTED));
            return;
        }
        
        if (getPlayers().size() == 16) {
            p.sendMessage(Strings.chatPrefix(Values.ARENA_FULL));
            return;
        }
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getMinPlayer() {
        return minPlayer;
    }
    
    public List<String> getPlayers() {
        return this.players;
    }
    
    public void setArenaState(ArenaState as) {
        if (this.as == as) return;
        this.as = as;
    }
}
