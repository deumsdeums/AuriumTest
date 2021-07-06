package fr.deums.aurium.test.Commands;

import fr.deums.aurium.test.Managers.HomeManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DelhomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;
            if(args.length==1){
                HomeManager.deleteHome(player,args[0]);
            }
            else
                return false;
        }
        return true;
    }
}
