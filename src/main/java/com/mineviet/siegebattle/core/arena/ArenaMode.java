package com.mineviet.siegebattle.core.arena;

public enum ArenaMode {
    THREE_VS_THREE(3, "3v3"),
    FIVE_VS_FIVE(5, "5v5"),
    SEVEN_VS_SEVEN(7, "7v7"),
    NIGHT_VS_NIGHT(9, "10v10");


    private int size;
    private String name;

    ArenaMode(int size, String name) {
        this.size = size;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}
