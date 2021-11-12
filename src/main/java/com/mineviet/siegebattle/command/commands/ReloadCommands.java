package com.mineviet.siegebattle.command.commands;

import com.mineviet.siegebattle.Main;
import com.mineviet.siegebattle.command.ICommands;
import com.mineviet.siegebattle.util.Values;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class ReloadCommands extends ICommands {

    Main plugin;

    public ReloadCommands(Main plugin) {
        this.plugin = plugin;
    }


    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public @Nullable String getDesc() {
        return "Tải lại plugin";
    }

    @Override
    public @Nullable String getSyntax() {
        return "/sb reload";
    }

    @Override
    public String getPermission() {
        return "siegebattle.reload";
    }

    @Override
    public void perform(Player player, String[] args) {
        plugin.reloadConfig();
        plugin.message.reloadConfig();
        player.sendMessage(plugin.utils.color(Values.RELOAD_CONFIG));
    }
}
