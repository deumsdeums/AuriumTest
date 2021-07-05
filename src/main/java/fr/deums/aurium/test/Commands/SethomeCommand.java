package fr.deums.aurium.test.Commands;

import fr.deums.aurium.test.Managers.HomeManager;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SethomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                String name = args[0];
                Location loc = player.getLocation();
                HomeManager.addHome(player, name, loc);
                player.sendMessage("Home défini");
            }
            else
                player.sendMessage("Veuillez définir un nom");
        }
        return true;

    }
}
