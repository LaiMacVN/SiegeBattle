package com.mineviet.siegebattle.command.commands;

import com.mineviet.siegebattle.Item.ItemID;
import com.mineviet.siegebattle.Main;
import com.mineviet.siegebattle.command.ICommands;
import com.mineviet.siegebattle.core.arena.Arena;
import org.bukkit.entity.Player;


public class CreateArenasCommands extends ICommands {

    Main plugin;

    public CreateArenasCommands(Main plugin) {
        this.plugin = plugin;
    }


    @Override
    public String getName() {
        return "create";
    }

    @Override
    public String getDesc() {
        return "Tạo một đấu trường mời";
    }

    @Override
    public String getSyntax() {
        return "/sb create";
    }

    @Override
    public String getPermission() {
        return "siegebattle.create";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (args.length == 1) {
            if (plugin.playerEditMode.containsKey(player.getUniqueId())) {
                // they want to get out edit mode
                plugin.playerEditMode.remove(player.getUniqueId());
                if (plugin.playerInventoryEditModeSave.containsKey(player.getUniqueId())) {
                    player.getInventory().clear();
                    player.getInventory().setContents(plugin.playerInventoryEditModeSave.get(player.getUniqueId()));
                } else {
                    player.getInventory().clear();
                }
                return;
            }
            if (!plugin.playerEditMode.containsKey(player.getUniqueId())) {
                player.sendMessage(plugin.utils.color("&CDùng như: /sb create <arenaName>"));
                return;
            }
        }
        if (args.length > 1) {
            if (plugin.playerEditMode.containsKey(player.getUniqueId())) {
                // they want to get out edit mode
                plugin.playerEditMode.remove(player.getUniqueId());
                if (plugin.playerInventoryEditModeSave.containsKey(player.getUniqueId())) {
                    player.getInventory().clear();
                    player.getInventory().setContents(plugin.playerInventoryEditModeSave.get(player.getUniqueId()));
                } else {
                    player.getInventory().clear();
                }
                return;
            }
            if (!plugin.playerEditMode.containsKey(player.getUniqueId())) {
                String arenaName = args[1];
                if (plugin.am.checkArenas(arenaName)) {
                    // generate an edit mode for player

                    plugin.playerEditMode.put(player.getUniqueId(), new Arena(arenaName));

                    //save player temp inventory

                    plugin.playerInventoryEditModeSave.put(player.getUniqueId(), player.getInventory().getContents());

                    player.getInventory().clear();

                    player.getInventory().setItem(0, plugin.itemCreate.giveItem(ItemID.LOBBY_LOCATION));
                    player.getInventory().setItem(2, plugin.itemCreate.giveItem(ItemID.SET_CORNER));
                    player.getInventory().setItem(3, plugin.itemCreate.giveItem(ItemID.SPAWN_LOCATION));
                    player.getInventory().setItem(4, plugin.itemCreate.giveItem(ItemID.DEATH_LOCATION));
                    player.getInventory().setItem(6, plugin.itemCreate.giveItem(ItemID.SET_WORLD));
                    player.getInventory().setItem(7, plugin.itemCreate.giveItem(ItemID.BAUVAT_LOCATION));
                    player.getInventory().setItem(8, plugin.itemCreate.giveItem(ItemID.DONE_ITEM));
                    player.sendMessage(plugin.utils.color("&aĐưa tới chế độ tạo đấu trường! Hãy tạo đấu trường bằng những item đó!"));
                    player.sendMessage(plugin.utils.color("&cThoát chế độ đấu trường bằng cách dùng lại lệnh tạo!"));


                } else {
                    player.sendMessage(plugin.utils.color("&cHãy dùng tên khác! Đấu trường với tên đó đã tồn tại!"));
                }
            }
        }
    }
}
