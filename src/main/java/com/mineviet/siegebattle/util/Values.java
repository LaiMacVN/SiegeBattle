package com.mineviet.siegebattle.util;

import com.mineviet.siegebattle.Main;

public class Values {

    //Dùng static để tiết kiệm bộ nhớ + code ngắn
    public static String JOIN_FROM_ANOTHER = Main.getInst().message.getConfig().getString("joinFromAnother");
    public static String ARENA_STARTED = Main.getInst().message.getConfig().getString("arenaStarted");
    public static String ARENA_FULL = Main.getInst().message.getConfig().getString("arenaFull");
    public static String ARENA_JOINED = Main.getInst().message.getConfig().getString("arenaJoined");
    public static String ARENA_JOIN_NOTIFY = Main.getInst().message.getConfig().getString("arenaJoinNotify");
    public static String COUNTDOWN_INTERVAL = Main.getInst().message.getConfig().getString("countdownInterval");
    public static String RELOAD_CONFIG = Main.getInst().message.getConfig().getString("ReloadedConfig");

    public static int CONFIG_COUNTDOWN_TIME = Main.getInst().getConfig().getInt("countdownTime");
}
