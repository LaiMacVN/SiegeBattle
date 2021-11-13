package com.mineviet.siegebattle;

import com.mineviet.siegebattle.Item.CreateItemEvent;
import com.mineviet.siegebattle.Item.ItemCreate;
import com.mineviet.siegebattle.MapManagers.MapUtils;
import com.mineviet.siegebattle.command.CommandsManagers;
import com.mineviet.siegebattle.core.arena.Arena;
import com.mineviet.siegebattle.core.arena.ArenaManager;
import com.mineviet.siegebattle.util.Storage;
import com.mineviet.siegebattle.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class Main extends JavaPlugin {

    public Map<UUID, Arena> playerEditMode = new HashMap<>();
    public Map<UUID, ItemStack[]> playerInventoryEditModeSave = new HashMap<>();

    public Storage message;
    public Storage arenaData;
    public Utils utils;
    public ArenaManager am;
    public ItemCreate itemCreate;
    public CommandsManagers commandsManagers;
    public MapUtils mapUtils;


    private static Main inst;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.setInst(this);
        saveDefaultConfig();
        this.message = new Storage(this, "String.yml");
        this.arenaData = new Storage(this, "ArenaData.yml");
        this.utils = new Utils(this);
        this.am = new ArenaManager(this);
        this.itemCreate = new ItemCreate();
        this.commandsManagers = new CommandsManagers(this);
        this.mapUtils = new MapUtils(this);
        this.itemCreate.init();

        this.mapUtils.read();

        getCommand("sb").setExecutor(this.commandsManagers);

        PluginManager manager = Bukkit.getServer().getPluginManager();
        manager.registerEvents(new CreateItemEvent(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    
    private void setInst(Main pl) {
        Main.inst = pl;
    }
    
    public static Main getInst() {
        return inst;
    }
}
