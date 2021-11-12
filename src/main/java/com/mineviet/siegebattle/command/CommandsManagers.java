package com.mineviet.siegebattle.command;

import com.mineviet.siegebattle.Main;
import com.mineviet.siegebattle.command.commands.CreateArenasCommands;
import com.mineviet.siegebattle.command.commands.ReloadCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommandsManagers implements TabExecutor {


    // lấy list commands
    private final ArrayList<ICommands> commands = new ArrayList<>();
    Main plugin;

    public CommandsManagers(Main plugin) {
        this.plugin = plugin;

        // khởi tạo command
        commands.add(new ReloadCommands(plugin));
        commands.add(new CreateArenasCommands(plugin));

    }

    // lấy commands list
    public ArrayList<ICommands> getCommands() {
        return commands;
    }


    // command perform
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 0) {
                p.sendMessage(plugin.utils.color("&a[✔]&m&l---------------------------------------&a[✔]"));
                for (int i = 0; i < getCommands().size(); i++) {
                    if (p.hasPermission(getCommands().get(i).getPermission()) || getCommands().get(i).getPermission() == null || Objects.equals(getCommands().get(i).getPermission(), "default")) {
                        p.sendMessage(plugin.utils.color("&b" + getCommands().get(i).getSyntax() + "&7: " + getCommands().get(i).getDesc()));
                    }
                }
                p.sendMessage(plugin.utils.color("&a[✔]&m&l---------------------------------------&a[✔]"));
            }

            if (args.length > 0) {
                for (int i = 0; i < getCommands().size(); i++) {
                    if (args[0].equalsIgnoreCase(getCommands().get(i).getName())) {
                        if (p.hasPermission(getCommands().get(i).getPermission()) || Objects.equals(getCommands().get(i).getPermission(), "default")) {
                            getCommands().get(i).perform(p, args);
                        } else {
                            p.sendMessage(plugin.utils.color("&cBạn không có quyền để dùng lệnh này!"));
                            return true;
                        }
                        break;
                    }
                }
            }
        }
        return true;
    }

    // tab completion perform
    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> commandsList = new ArrayList<>();
        for (ICommands subCommands : commands) {
            if (sender.hasPermission(subCommands.getPermission()) || subCommands.getPermission().equalsIgnoreCase("default")) {
                commandsList.add(subCommands.getName());
            }
        }
        List<String> result = new ArrayList<>();
        if (args.length == 1) {
            for (String a : commandsList) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase()))
                    result.add(a);
            }
            return result;
        }

        return null;
    }
}
