package com.mineviet.siegebattle.core.arena;

import com.mineviet.siegebattle.Main;
import com.mineviet.siegebattle.core.player.PlayerManager;
import com.mineviet.siegebattle.core.player.PlayerState;
import com.mineviet.siegebattle.util.Values;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ArenaManager {

    private Main inst;
    private PlayerManager pm;
    private List<Arena> arenas = new ArrayList<>();

    public ArenaManager() {
    }

    ;


    // check if player is create arena with the same name
    public boolean checkArenas(String name) {
        for (Arena arena : arenas) {
            if (arena.getName().equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }

    public ArenaManager(Main pl) {
        this.inst = pl;
        pm = new PlayerManager();
    }

    public void addPlayer(Player p, Arena a) {
        if (!(pm.getPlayerState(p) == PlayerState.WAITING)) {
            p.sendMessage(inst.utils.chatPrefix(Values.JOIN_FROM_ANOTHER));
            return;
        }
        if (a.getArenaState() != ArenaState.WAITING||a.getArenaState() != ArenaState.COUNTDOWN) {
            p.sendMessage(inst.utils.chatPrefix(Values.ARENA_STARTED));
            return;
        }
        if (a.getArenaState() == ArenaState.FULL) {
            p.sendMessage(inst.utils.chatPrefix(Values.ARENA_FULL));
            return;
        }
        a.getPlayers().add(p);
        p.sendMessage(inst.utils.chatPrefix(Values.ARENA_JOINED.replace("%1", a.getName())));
        a.sendMessage(inst.utils.chatPrefix(Values.ARENA_JOIN_NOTIFY
            .replace("%1", p.getName())
            .replace("%2", String.valueOf(a.getPlayers().size()))
            .replace("%3", String.valueOf(a.getMaxPlayers()))));
    }

    //Arena things
    public void loadArena(String name, Location lobbyLocation, Location teamALocation, Location teamBLocation, Location deathLocation, int minPlayers, int maxPlayers, Location bauVatSpawn, Location corner1, Location corner2, World world) {
        arenas.add(new Arena(name, lobbyLocation, teamALocation, teamBLocation, deathLocation, minPlayers, maxPlayers, bauVatSpawn, corner1, corner2, world));
        inst.getLogger().info("Successfully loaded arena %".replace("%", name));
    }
    
    public List<Arena> getArenas() {
        return this.arenas;
    }
    
    public Arena getArena(String name) {
        for (Arena a: getArenas()) {
            if (a.getName().equalsIgnoreCase(name)) {
                return a;
            }
        }
        return null;
    }
    
    public PlayerManager getPlayerManager() {
        return pm;
    }
    

}
