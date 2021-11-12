package com.mineviet.siegebattle.core.listeners;

import com.mineviet.siegebattle.Main;
import com.mineviet.siegebattle.core.arena.Arena;
import com.mineviet.siegebattle.core.player.PlayerState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {
    
    private Main pl;
    
    public PlayerChatListener() {
    }    
    
    public PlayerChatListener(Main plugin) {
        this.pl = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (pl.am.getPlayerManager().getPlayerState(e.getPlayer()) != PlayerState.WAITING) {
            Arena a = pl.am.getPlayerManager().getArenaWherePlayerAt(e.getPlayer());
            a.sendMessage(pl.utils.color("&3[&2%1&3]&a %2 &7> %3"
                .replace("%1", a.getName())
                .replace("%2", e.getPlayer().getName())
                .replace("%3", e.getMessage())));
            e.setCancelled(true);
        }
    }
    
}
