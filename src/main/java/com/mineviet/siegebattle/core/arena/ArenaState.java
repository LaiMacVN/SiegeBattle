package com.mineviet.siegebattle.core.arena;

public enum ArenaState {
    WAITING("&aĐang trống!"),
    COUNTDOWN("&6Đang đếm ngược"),
    FULL("&cĐã đầy!"),
    IN_GAME("&cTrong trận"),
    ENDING("&3Đã kết thúc"),
    RESTARTING("&9Đang khởi động lại");

    private String name;

    ArenaState(String name) {
        this.name = name;
    }

    public String getStates() {
        return name;
    }
}
