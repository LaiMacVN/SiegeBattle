package com.mineviet.siegebattle.util;

import com.mineviet.siegebattle.Main;
import com.mineviet.siegebattle.core.arena.ArenaMode;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Utils {


    Main plugin;

    public ArenaMode getMode(String name) {
        switch (name) {
            case "3v3":
                return ArenaMode.THREE_VS_THREE;
            case "5v5":
                return ArenaMode.FIVE_VS_FIVE;
            case "7v7":
                return ArenaMode.SEVEN_VS_SEVEN;
            case "9v9":
                return ArenaMode.NIGHT_VS_NIGHT;
            default:
                return null;
        }
    }

    public Utils(Main plugin) {
        this.plugin = plugin;
    }

    public String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public String chatPrefix(String s) {
        return color(Main.getInst().message.getConfig().getString("prefix")+" "+s);
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
