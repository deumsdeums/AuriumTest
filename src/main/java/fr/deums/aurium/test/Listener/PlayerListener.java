package fr.deums.aurium.test.Listener;

import fr.deums.aurium.test.Managers.HomeManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        if(!HomeManager.containsPlayer(event.getPlayer())){
            HomeManager.initPlayer(event.getPlayer());

        }
    }
}
