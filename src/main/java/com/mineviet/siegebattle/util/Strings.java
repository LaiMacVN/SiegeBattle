package com.mineviet.siegebattle.util;

import com.mineviet.siegebattle.Main;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;

public class Strings {
    public static String chatColor(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
    
    public static TextComponent chatTextComponent(String s) {
        return new TextComponent(Strings.chatColor(s));
    }
    
    public static String chatPrefix(String s) {
        return Strings.chatColor(Main.getInst().getStringFile().getConfig().getString("prefix")+" "+s);
    }
}
