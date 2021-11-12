package com.mineviet.siegebattle.Item;

import net.md_5.bungee.api.ChatColor;

public enum ItemID {

    SET_WORLD(ChatColor.translateAlternateColorCodes('&', "&aChỉnh đấu trường!")),
    SET_CORNER(ChatColor.translateAlternateColorCodes('&', "&bChỉnh gốc 1 và 2!")),
    LOBBY_LOCATION(ChatColor.translateAlternateColorCodes('&', "&eChỉnh vị trí lobby")),
    SPAWN_LOCATION(ChatColor.translateAlternateColorCodes('&', "&3Chỉnh vị trí đội A và đội B")),
    BAUVAT_LOCATION(ChatColor.translateAlternateColorCodes('&', "&9Chỉnh vị trí bấu vật!")),
    DEATH_LOCATION(ChatColor.translateAlternateColorCodes('&', "&cChỉnh vị trí xuất hiện của người chơi đã thua cuộc!")),
    DONE_ITEM(ChatColor.translateAlternateColorCodes('&', "&aLưu trữ đấu trường"));


    private String name;

    ItemID(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
