package com.mineviet.siegebattle;

import com.mineviet.siegebattle.util.Storage;
import com.mineviet.siegebattle.util.Utils;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public Storage message;
    public Utils utils;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.message = new Storage(this, "String.yml");
        this.utils = new Utils(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
