package com.mineviet.siegebattle.command;

import org.bukkit.entity.Player;


public abstract class ICommands {

    // quản lý command nè nha

    public abstract String getName();


    // này là description của command
    public abstract String getDesc();


    // này là lấy syntax command
    public abstract String getSyntax();

    // này là lấy permission
    public abstract String getPermission();


    // này để thực hiện command
    public abstract void perform(Player player, String[] args);
}
