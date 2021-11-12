package com.mineviet.siegebattle.core.player;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;

public class PlayerManager {
    public static Map<Player, PlayerState> states = new HashMap<>();
    
    public static void setPlayerState(Player p, PlayerState state) {
        if (states.get(p) == state) {
            return;
        }
        states.put(p, state);
    }
    
    public static PlayerState getPlayerState(Player p) {
        return states.get(p);
    }
}
