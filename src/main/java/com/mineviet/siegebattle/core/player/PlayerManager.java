package com.mineviet.siegebattle.core.player;

import com.mineviet.siegebattle.core.arena.Arena;
import com.mineviet.siegebattle.core.arena.ArenaManager;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;

public class PlayerManager {
    
    private ArenaManager am;
    
    public PlayerManager() {
    
    }
    
    public PlayerManager(ArenaManager am) {
        this.am = am;
    };

    public Map<Player, PlayerState> states = new HashMap<>();
    
    public void setPlayerState(Player p, PlayerState state) {
        if (states.get(p) == state) {
            return;
        }
        states.put(p, state);
    }
    
    public PlayerState getPlayerState(Player p) {
        return states.get(p);
    }
    
    public Arena getArenaWherePlayerAt(Player p) {
        for (Arena a:am.getArenas()) {
            for (Player player:a.getPlayers()) {
                if (player == p) {
                    return a;
                }
            }
        }
        return null;
    }
}
