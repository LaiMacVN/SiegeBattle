package com.mineviet.siegebattle.core.arena.tasks;

import com.mineviet.siegebattle.Main;
import com.mineviet.siegebattle.core.arena.Arena;
import com.mineviet.siegebattle.core.arena.ArenaState;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CountdownTask extends BukkitRunnable {

    private Arena arena;
    private Main plugin;
    private int i;
    private String message;

    public CountdownTask(Arena arena, Main plugin, int i, String message) {
        this.arena = arena;
        this.plugin = plugin;
        this.i = i;
        this.message = message;
    }

    @Override
    public void run() {
        if (arena.getArenaState() == ArenaState.COUNTDOWN) {
            if (i == 0) {

                // arena start here
                // create a method like startGame(arenas);

            } else if (i == 15 || i == 10 || i >= 5) {
                for (Player player : arena.getPlayers()) {
                    player.sendMessage(plugin.utils.color(message.replace("%1", String.valueOf(i))));
                }
            }
            i--;
        } else {
            stop();
        }
    }

    public void stop() {
        if (!isCancelled()) {
            cancel();
        }
    }
}
