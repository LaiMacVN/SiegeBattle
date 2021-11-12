/* Source code by CreeperboyMCVN, DO NOT RECODE OR RE-UP*/
/*Author CreeperboyMCVN, LightMaxVN*/

package com.mineviet.siegebattle;

import com.mineviet.siegebattle.util.Storage;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    
    private Storage string;
    private static Main pl;
    
    @Override
    public void onEnable() {
        setInst(this);
        saveDefaultConfig();
        string = new Storage(this, "String.yml");
    }
    
    private void setInst(Main pl) {
        Main.pl = pl;
    }
    
    public static Main getInst() {
        return Main.pl;
    }
    
    public Storage getStringFile() {
        return string;
    }

}
