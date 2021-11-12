package com.mineviet.siegebattle;

import com.mineviet.siegebattle.core.arena.ArenaManager;
import com.mineviet.siegebattle.util.Storage;
import com.mineviet.siegebattle.util.Utils;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public Storage message;
    public Utils utils;
    public ArenaManager am;
    private static Main inst;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.setInst(this);
        saveDefaultConfig();
        this.message = new Storage(this, "String.yml");
        this.utils = new Utils(this);
        this.am = new ArenaManager(this);
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
