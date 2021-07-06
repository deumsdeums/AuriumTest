package fr.deums.aurium.test.config;

import fr.execaution.config.ConfigBase;
import org.bukkit.plugin.java.JavaPlugin;

public class HomeConfig extends ConfigBase {
    static HomeConfig Instance;
    public HomeConfig(JavaPlugin pl) {
        super(pl, "home_config.yml");
        Instance = this;
    }

    @Override
    public void defaultConfig() {
        config.set("timer",5);
    }

    public static int getConfigTimer(){
        return Instance.config.getInt("timer");
    }

    public static void SaveConfig(){
        Instance.saveConfig();
    }

}
