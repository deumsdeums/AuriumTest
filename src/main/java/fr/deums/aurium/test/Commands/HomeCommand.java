package fr.deums.aurium.test.Commands;

import fr.deums.aurium.test.Managers.HomeManager;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args.length==1){
                String name = args[0];
                Location loc = player.getLocation();
                Location homeLoc = HomeManager.getHomeList(player).get(name);
                player.teleport(homeLoc);
            }
            else{
                String msg = "Home disponible : ";
                for(String home : HomeManager.getHomeList(player).keySet()){
                    msg += (home+" ");
                }
            }
        }
        return true;
    }
}
