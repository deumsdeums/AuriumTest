package fr.deums.aurium.test;

import fr.deums.aurium.test.Commands.HomeCommand;
import fr.deums.aurium.test.Commands.SethomeCommand;
import fr.deums.aurium.test.Listener.PlayerListener;
import fr.deums.aurium.test.Managers.HomeManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("sethome").setExecutor(new SethomeCommand());
        this.getCommand("home").setExecutor(new HomeCommand());
        getServer().getPluginManager().registerEvents(new PlayerListener(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
