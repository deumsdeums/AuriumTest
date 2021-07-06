package fr.deums.aurium.test;

import fr.deums.aurium.test.Commands.DelhomeCommand;
import fr.deums.aurium.test.Commands.HomeCommand;
import fr.deums.aurium.test.Commands.SethomeCommand;
import fr.deums.aurium.test.Listener.PlayerListener;
import fr.deums.aurium.test.config.HomeConfig;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        new HomeConfig(this);
        this.getCommand("sethome").setExecutor(new SethomeCommand());
        this.getCommand("home").setExecutor(new HomeCommand(this));
        this.getCommand("delhome").setExecutor(new DelhomeCommand());
        getServer().getPluginManager().registerEvents(new PlayerListener(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
