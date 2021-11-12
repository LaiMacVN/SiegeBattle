package com.mineviet.siegebattle.util;

import com.mineviet.siegebattle.Main;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Storage {
    
    private Main plugin;
    private FileConfiguration file = null;
    private File configFile = null;
    private final String fileName;

    /**
     *
     * @param plugin The main class of plugin
     * @param name The name of configuration file
     */
    public Storage(Main plugin, String name) {
        this.plugin = plugin;
        this.fileName = name;
        saveDefaultConfig();
    }
    
    public void reloadConfig() {
        if (this.configFile == null) 
            this.configFile = new File(this.plugin.getDataFolder(), fileName);
        
        this.file = YamlConfiguration.loadConfiguration(this.configFile);
        
        InputStream defStream = this.plugin.getResource(fileName);
        
        if (defStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defStream));
            this.file.setDefaults(defaultConfig);
        }
    }
    
    public FileConfiguration getConfig() {
        if (this.file == null) {
            reloadConfig();
        }
        return this.file;
    };
    
    public void saveConfig() throws IOException {
        if (this.file == null || this.configFile == null) 
            return;
        
        try {
         this.getConfig().save(this.configFile);
        } catch (IOException e) {
            plugin.getLogger().log(Level.WARNING, "Khong the luu config!" + this.configFile, e);
        }
        
    }
    
    public void saveDefaultConfig() {
        if (this.configFile == null)
            this.configFile = new File(this.plugin.getDataFolder(), fileName);
        
        if (!this.configFile.exists()) {
            this.plugin.saveResource(fileName, false);
        }
    }
}
