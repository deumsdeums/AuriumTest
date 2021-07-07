package fr.deums.aurium.test.config;

import fr.deums.aurium.test.Managers.HomeManager;
import fr.execaution.config.ConfigBase;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.MemorySection;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class HomeConfig extends ConfigBase {
    static HomeConfig Instance;
    public HomeConfig(JavaPlugin pl) {
        super(pl, "home_config.yml");
        Instance = this;
        loadHomes();
    }

    @Override
    public void defaultConfig() {
        config.createSection("Options");
        config.set("Options.timer",5);
        config.createSection("Database");
    }
    public static void loadHomes(){
        ConfigurationSection section = Instance.config.getConfigurationSection("Database");
        for(String key : section.getKeys(false)){ // Itération sur chaque joueur
            

        }

    }
    public static void saveHomes(){
        ConfigurationSection section = Instance.config.getConfigurationSection("Database");
        HomeManager.getDatabase().forEach((k, v)->{
            v.forEach((name,loc)->{
                section.set(k.toString()+"."+name+".world",loc.getWorld().getName());
                section.set(k.toString()+"."+name+".x",loc.getX());
                section.set(k.toString()+"."+name+".y",loc.getY());
                section.set(k.toString()+"."+name+".z",loc.getZ());

            });
        });
        Instance.saveConfig();
    }

    public static int getConfigTimer(){
        return Instance.config.getConfigurationSection("Options").getInt("timer");
    }



    public static void SaveConfig(){
        Instance.saveConfig();
    }

}
