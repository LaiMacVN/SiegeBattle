package com.mineviet.siegebattle.core.player;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;

public class PlayerManager {
    
    public PlayerManager() {};

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
}
