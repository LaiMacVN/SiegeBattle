package com.mineviet.siegebattle.util;

import com.mineviet.siegebattle.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Utils {


    Main plugin;

    public Utils(Main plugin) {
        this.plugin = plugin;
    }

    public String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public String deColor(String s) {
        return ChatColor.stripColor(s);
    }

    public String deTranslateAlternateColorCodes(String s) {
        return s.replace("§", "&");
    }

    public void msgPlayer(Player player, String... msg) {
        for (String s : msg) {
            player.sendMessage(color(s));
        }
    }

    public void titlePlayer(Player player, String bigTitle, String smallTile, int fadeInt, int fadeOut, int stay) {
        player.sendTitle(color(bigTitle), color(smallTile), fadeInt, stay, fadeOut);
    }

    public void soundPlayer(Player player, Sound sound) {
        player.playSound(player.getLocation(), sound, 5, 5);
    }

    public void soundPlayer(Player player, Sound sound, int volume, int pitch) {
        player.playSound(player.getLocation(), sound, volume, pitch);
    }
}
