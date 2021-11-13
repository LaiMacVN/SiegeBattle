package com.mineviet.siegebattle.MapManagers;

import com.mineviet.siegebattle.Main;
import com.mineviet.siegebattle.core.arena.Arena;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.IOException;

public class MapUtils {


    Main plugin;

    public MapUtils(Main plugin) {
        this.plugin = plugin;
    }

    public void read() {
        ConfigurationSection section = plugin.arenaData.getConfig().getConfigurationSection("");
        if (section == null) return;
        section.getKeys(false).forEach(key -> {
            World world = Bukkit.getServer().getWorld(String.valueOf(section.getString(key + ".World")));
            if (world == null) return;
            Location teamOneLocation = new Location(
                    world,
                    section.getDouble(key + ".TeamOneLocation" + ".X"),
                    section.getDouble(key + ".TeamOneLocation" + ".Y"),
                    section.getDouble(key + ".TeamOneLocation" + ".Z"),
                    (float) section.getDouble(key + ".TeamOneLocation" + ".Yaw"),
                    (float) section.getDouble(key + ".TeamOneLocation" + ".Pitch")
            );

            Location teamTwoLocation = new Location(
                    world,
                    section.getDouble(key + ".TeamTwoLocation" + ".X"),
                    section.getDouble(key + ".TeamTwoLocation" + ".Y"),
                    section.getDouble(key + ".TeamTwoLocation" + ".Z"),
                    (float) section.getDouble(key + ".TeamTwoLocation" + ".Yaw"),
                    (float) section.getDouble(key + ".TeamTwoLocation" + ".Pitch")
            );

            Location lobbyLocation = new Location(
                    world,
                    section.getDouble(key + ".LobbyLocation" + ".X"),
                    section.getDouble(key + ".LobbyLocation" + ".Y"),
                    section.getDouble(key + ".LobbyLocation" + ".Z"),
                    (float) section.getDouble(key + ".LobbyLocation" + ".Yaw"),
                    (float) section.getDouble(key + ".LobbyLocation" + ".Pitch")
            );

            Location deathLocation = new Location(
                    world,
                    section.getDouble(key + ".DeathLocation" + ".X"),
                    section.getDouble(key + ".DeathLocation" + ".Y"),
                    section.getDouble(key + ".DeathLocation" + ".Z"),
                    (float) section.getDouble(key + ".DeathLocation" + ".Yaw"),
                    (float) section.getDouble(key + ".DeathLocation" + ".Pitch")
            );

            Location bauVatLocation = new Location(
                    world,
                    section.getDouble(key + ".BauVauLocation" + ".X"),
                    section.getDouble(key + ".BauVauLocation" + ".Y"),
                    section.getDouble(key + ".BauVauLocation" + ".Z")
            );

            Location corner1 = new Location(
                    world,
                    section.getDouble(key + ".Corner1" + ".X"),
                    section.getDouble(key + ".Corner1" + ".Y"),
                    section.getDouble(key + ".Corner1" + ".Z")
            );

            Location corner2 = new Location(
                    world,
                    section.getDouble(key + ".Corner2" + ".X"),
                    section.getDouble(key + ".Corner2" + ".Y"),
                    section.getDouble(key + ".Corner2" + ".Z")
            );

            int perTeamSize = section.getInt(key + ".PerTeamSize");

            plugin.am.loadArena(key, lobbyLocation, teamOneLocation, teamTwoLocation, deathLocation, perTeamSize, bauVatLocation, corner1, corner2, world);
            try {
                plugin.arenaData.saveConfig();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

    public void write(Arena arena, FileConfiguration fileConfiguration) {
        fileConfiguration.set(arena.getName() + ".World", arena.getWorld().getName());
        fileConfiguration.set(arena.getName() + ".PerTeamSize", arena.getTeamSize());
        fileConfiguration.set(arena.getName() + ".TeamOneLocation" + ".X", arena.getTeamALocation().getX());
        fileConfiguration.set(arena.getName() + ".TeamOneLocation" + ".Y", arena.getTeamALocation().getY());
        fileConfiguration.set(arena.getName() + ".TeamOneLocation" + ".Z", arena.getTeamALocation().getZ());
        fileConfiguration.set(arena.getName() + ".TeamOneLocation" + ".Yaw", arena.getTeamALocation().getYaw());
        fileConfiguration.set(arena.getName() + ".TeamOneLocation" + ".Pitch", arena.getTeamALocation().getPitch());

        fileConfiguration.set(arena.getName() + ".TeamTwoLocation" + ".X", arena.getTeamBLocation().getX());
        fileConfiguration.set(arena.getName() + ".TeamTwoLocation" + ".Y", arena.getTeamBLocation().getY());
        fileConfiguration.set(arena.getName() + ".TeamTwoLocation" + ".Z", arena.getTeamBLocation().getZ());
        fileConfiguration.set(arena.getName() + ".TeamTwoLocation" + ".Yaw", arena.getTeamBLocation().getYaw());
        fileConfiguration.set(arena.getName() + ".TeamTwoLocation" + ".Pitch", arena.getTeamBLocation().getPitch());


        fileConfiguration.set(arena.getName() + ".LobbyLocation" + ".X", arena.getLobbyLocation().getX());
        fileConfiguration.set(arena.getName() + ".LobbyLocation" + ".Y", arena.getLobbyLocation().getY());
        fileConfiguration.set(arena.getName() + ".LobbyLocation" + ".Z", arena.getLobbyLocation().getZ());
        fileConfiguration.set(arena.getName() + ".LobbyLocation" + ".Yaw", arena.getLobbyLocation().getYaw());
        fileConfiguration.set(arena.getName() + ".LobbyLocation" + ".Pitch", arena.getLobbyLocation().getPitch());


        fileConfiguration.set(arena.getName() + ".DeathLocation" + ".X", arena.getDeathLocation().getX());
        fileConfiguration.set(arena.getName() + ".DeathLocation" + ".Y", arena.getDeathLocation().getY());
        fileConfiguration.set(arena.getName() + ".DeathLocation" + ".Z", arena.getDeathLocation().getZ());
        fileConfiguration.set(arena.getName() + ".DeathLocation" + ".Yaw", arena.getDeathLocation().getYaw());
        fileConfiguration.set(arena.getName() + ".DeathLocation" + ".Pitch", arena.getDeathLocation().getPitch());

        fileConfiguration.set(arena.getName() + ".BauVauLocation" + ".X", arena.getBauVatLocation().getX());
        fileConfiguration.set(arena.getName() + ".BauVauLocation" + ".Y", arena.getBauVatLocation().getY());
        fileConfiguration.set(arena.getName() + ".BauVauLocation" + ".Z", arena.getBauVatLocation().getZ());


        fileConfiguration.set(arena.getName() + ".Corner1" + ".X", arena.getCorner1().getX());
        fileConfiguration.set(arena.getName() + ".Corner1" + ".Y", arena.getCorner1().getY());
        fileConfiguration.set(arena.getName() + ".Corner1" + ".Z", arena.getCorner1().getZ());

        fileConfiguration.set(arena.getName() + ".Corner2" + ".X", arena.getCorner2().getX());
        fileConfiguration.set(arena.getName() + ".Corner2" + ".Y", arena.getCorner2().getY());
        fileConfiguration.set(arena.getName() + ".Corner2" + ".Z", arena.getCorner2().getZ());

        try {
            plugin.arenaData.saveConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
