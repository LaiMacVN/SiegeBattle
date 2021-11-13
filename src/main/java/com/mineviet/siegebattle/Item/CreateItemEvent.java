package com.mineviet.siegebattle.Item;

import com.mineviet.siegebattle.Main;
import com.mineviet.siegebattle.core.arena.Arena;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class CreateItemEvent implements Listener {

    Main plugin;

    public CreateItemEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        Arena arena = plugin.playerEditMode.get(player.getUniqueId());
        if (e.getHand() == null) return;
        if (e.getItem() == null) return;
        if (itemStack.getItemMeta() == null) return;
        String displayName = itemStack.getItemMeta().getDisplayName();
        if (plugin.playerEditMode.containsKey(player.getUniqueId())) {
            if (displayName.equals(ItemID.SPAWN_LOCATION.getName())) {
                if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
                    e.setCancelled(true);
                    Location teamALocation = player.getLocation();
                    arena.setTeamALocation(teamALocation);
                    player.sendMessage(plugin.utils.color("&a&l&m---------------------"));
                    player.sendMessage(plugin.utils.color("&bChỉnh vị trí của Team A tại:"));
                    player.sendMessage(plugin.utils.color("&aX: &b" + teamALocation.getX()));
                    player.sendMessage(plugin.utils.color("&aY: &b" + teamALocation.getY()));
                    player.sendMessage(plugin.utils.color("&aZ: &b" + teamALocation.getZ()));
                    player.sendMessage(plugin.utils.color("&aYaw: &b" + teamALocation.getYaw()));
                    player.sendMessage(plugin.utils.color("&aPitch: &b" + teamALocation.getPitch()));
                    player.sendMessage(plugin.utils.color("&a&l&m---------------------"));
                } else if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    e.setCancelled(true);
                    Location teamBLocation = player.getLocation();
                    arena.setTeamBLocation(teamBLocation);
                    player.sendMessage(plugin.utils.color("&a&l&m---------------------"));
                    player.sendMessage(plugin.utils.color("&bChỉnh vị trí của Team B tại:"));
                    player.sendMessage(plugin.utils.color("&aX: &b" + teamBLocation.getX()));
                    player.sendMessage(plugin.utils.color("&aY: &b" + teamBLocation.getY()));
                    player.sendMessage(plugin.utils.color("&aZ: &b" + teamBLocation.getZ()));
                    player.sendMessage(plugin.utils.color("&aYaw: &b" + teamBLocation.getYaw()));
                    player.sendMessage(plugin.utils.color("&aPitch: &b" + teamBLocation.getPitch()));
                    player.sendMessage(plugin.utils.color("&a&l&m---------------------"));
                }
                return;
            }
            if (displayName.equals(ItemID.LOBBY_LOCATION.getName())) {
                if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    e.setCancelled(true);
                    Location lobbyLocation = player.getLocation();
                    arena.setLobbyLocation(lobbyLocation);
                    player.sendMessage(plugin.utils.color("&a&l&m---------------------"));
                    player.sendMessage(plugin.utils.color("&bChỉnh vị trí của Lobby tại:"));
                    player.sendMessage(plugin.utils.color("&aX: &b" + lobbyLocation.getX()));
                    player.sendMessage(plugin.utils.color("&aY: &b" + lobbyLocation.getY()));
                    player.sendMessage(plugin.utils.color("&aZ: &b" + lobbyLocation.getZ()));
                    player.sendMessage(plugin.utils.color("&aYaw: &b" + lobbyLocation.getYaw()));
                    player.sendMessage(plugin.utils.color("&aPitch: &b" + lobbyLocation.getPitch()));
                    player.sendMessage(plugin.utils.color("&a&l&m---------------------"));
                }
                return;
            }
            if (displayName.equals(ItemID.DEATH_LOCATION.getName())) {
                if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    e.setCancelled(true);
                    Location deathLocation = player.getLocation();
                    arena.setDeathLocation(deathLocation);
                    player.sendMessage(plugin.utils.color("&a&l&m---------------------"));
                    player.sendMessage(plugin.utils.color("&bChỉnh vị trí của Khán giả tại:"));
                    player.sendMessage(plugin.utils.color("&aX: &b" + deathLocation.getX()));
                    player.sendMessage(plugin.utils.color("&aY: &b" + deathLocation.getY()));
                    player.sendMessage(plugin.utils.color("&aZ: &b" + deathLocation.getZ()));
                    player.sendMessage(plugin.utils.color("&aYaw: &b" + deathLocation.getYaw()));
                    player.sendMessage(plugin.utils.color("&aPitch: &b" + deathLocation.getPitch()));
                    player.sendMessage(plugin.utils.color("&a&l&m---------------------"));
                }
                return;
            }
            if (displayName.equals(ItemID.BAUVAT_LOCATION.getName())) {
                if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    e.setCancelled(true);
                    Location bauVatLocation = player.getLocation();
                    arena.setBauVatLocation(bauVatLocation);
                    player.sendMessage(plugin.utils.color("&a&l&m---------------------"));
                    player.sendMessage(plugin.utils.color("&bChỉnh vị trí của báu vật tại:"));
                    player.sendMessage(plugin.utils.color("&aX: &b" + bauVatLocation.getX()));
                    player.sendMessage(plugin.utils.color("&aY: &b" + bauVatLocation.getY()));
                    player.sendMessage(plugin.utils.color("&aZ: &b" + bauVatLocation.getZ()));
                    player.sendMessage(plugin.utils.color("&a&l&m---------------------"));
                }
                return;
            }
            if (displayName.equals(ItemID.SET_CORNER.getName())) {
                if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
                    e.setCancelled(true);
                    if (e.getClickedBlock() == null) return;
                    Location corner1 = e.getClickedBlock().getLocation();
                    arena.setCorner1(corner1);
                    player.sendMessage(plugin.utils.color("&a&l&m---------------------"));
                    player.sendMessage(plugin.utils.color("&bChỉnh góc 1 của đấu trường tại:"));
                    player.sendMessage(plugin.utils.color("&aX: &b" + corner1.getX()));
                    player.sendMessage(plugin.utils.color("&aY: &b" + corner1.getY()));
                    player.sendMessage(plugin.utils.color("&aZ: &b" + corner1.getZ()));
                    player.sendMessage(plugin.utils.color("&a&l&m---------------------"));
                } else if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    e.setCancelled(true);
                    if (e.getClickedBlock() == null) return;
                    Location corner2 = e.getClickedBlock().getLocation();
                    arena.setCorner2(corner2);
                    player.sendMessage(plugin.utils.color("&a&l&m---------------------"));
                    player.sendMessage(plugin.utils.color("&bChỉnh góc 2 của đấu trường tại:"));
                    player.sendMessage(plugin.utils.color("&aX: &b" + corner2.getX()));
                    player.sendMessage(plugin.utils.color("&aY: &b" + corner2.getY()));
                    player.sendMessage(plugin.utils.color("&aZ: &b" + corner2.getZ()));
                    player.sendMessage(plugin.utils.color("&a&l&m---------------------"));
                }
                return;
            }
            if (displayName.equals(ItemID.SET_WORLD.getName())) {
                if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    e.setCancelled(true);
                    World world = player.getWorld();
                    arena.setWorld(world);
                    player.sendMessage(plugin.utils.color("&a&l&m---------------------"));
                    player.sendMessage(plugin.utils.color("&bChỉnh thế giới đấu trường tại:"));
                    player.sendMessage(plugin.utils.color("&aWorld: &b" + world.getName()));
                    player.sendMessage(plugin.utils.color("&a&l&m---------------------"));
                }
                return;
            }
            if (displayName.equals(ItemID.DONE_ITEM.getName())) {
                if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    e.setCancelled(true);
                    if (arena.isComplete()) {
                        player.sendMessage(plugin.utils.color("&a&l&m---------------------"));
                        player.sendMessage(plugin.utils.color("&bĐã hoàn thành tạo đấu trường: &a" + arena.getName()));
                        player.sendMessage(plugin.utils.color("&a&l&m---------------------"));
                        plugin.playerEditMode.remove(player.getUniqueId());
                        if (plugin.playerInventoryEditModeSave.containsKey(player.getUniqueId())) {
                            player.getInventory().clear();
                            player.getInventory().setContents(plugin.playerInventoryEditModeSave.get(player.getUniqueId()));
                        } else {
                            player.getInventory().clear();
                        }
                        plugin.mapUtils.write(arena, plugin.arenaData.getConfig());

                    } else {
                        player.sendMessage(plugin.utils.color("&cBạn cần phải hoàn thành xong đấu trường trước khi save"));
                    }
                }
            }

        }
    }

    @EventHandler
    public void onClickInv(InventoryClickEvent e) {

    }
}
