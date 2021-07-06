package fr.deums.aurium.test.Commands;

import fr.deums.aurium.test.Main;
import fr.deums.aurium.test.Managers.HomeManager;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class HomeCommand implements CommandExecutor {
    private Main pluginInstance;
    public HomeCommand(Main plugin){
        this.pluginInstance = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args.length==1){
                String name = args[0];
                if(HomeManager.homeExist(player,name)) {
                    Location loc = player.getLocation();
                    Location homeLoc = HomeManager.getHomeList(player).get(name);
                    if(player.hasPermission("fr.deums.aurium.test.home.bypass"))
                        player.teleport(homeLoc);
                    else
                        new BukkitRunnable(){
                            @Override
                            public void run() {
                                player.teleport(homeLoc);
                            }
                        }.runTaskLater(pluginInstance,100);
                        player.sendMessage("Téléportation dans 5 secondes");

                }
            }
            else{
                String msg = "Home disponible : ";
                for(String home : HomeManager.getHomeList(player).keySet()){
                    msg += (home+" ");
                }
                player.sendMessage(msg);
            }
        }
        return true;
    }
}
