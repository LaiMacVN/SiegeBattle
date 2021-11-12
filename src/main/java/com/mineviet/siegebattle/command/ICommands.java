package com.mineviet.siegebattle.command;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public abstract class ICommands {

    // quản lý command nè nha

    public abstract String getName();


    // này là description của command
    @Nullable
    public abstract String getDesc();


    // này là lấy syntax command
    @Nullable
    public abstract String getSyntax();

    // này là lấy permission
    public abstract String getPermission();


    // này để thực hiện command
    public abstract void perform(Player player, String[] args);
}
