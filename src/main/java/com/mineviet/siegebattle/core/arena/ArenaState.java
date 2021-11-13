package com.mineviet.siegebattle.core.arena;

import org.bukkit.ChatColor;

public enum ArenaState {
    WAITING(ChatColor.translateAlternateColorCodes('&', "&aĐang trống!")),
    COUNTDOWN(ChatColor.translateAlternateColorCodes('&', "&6Đang đếm ngược")),
    FULL(ChatColor.translateAlternateColorCodes('&', "&cĐã đầy!")),
    IN_GAME(ChatColor.translateAlternateColorCodes('&', "&cTrong trận")),
    ENDING(ChatColor.translateAlternateColorCodes('&', "&3Đã kết thúc")),
    RESTARTING(ChatColor.translateAlternateColorCodes('&', "&9Đang khởi động lại"));

    private String name;

    ArenaState(String name) {
        this.name = name;
    }

    public String getStates() {
        return name;
    }
}
