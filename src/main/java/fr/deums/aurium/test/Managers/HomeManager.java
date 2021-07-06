package fr.deums.aurium.test.Managers;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class HomeManager {
    private static HashMap<UUID,HashMap<String,Location>> database= new HashMap<UUID,HashMap<String,Location>>();
    private static HashMap<UUID,HashMap<String,Location>> getDatabase(){
        return database;
    }
    public static void addHome(Player p,String name ,Location loc){
        getDatabase().get(p.getUniqueId()).put(name,loc);
    }
    public static HashMap<String,Location> getHomeList(Player p){
        return getDatabase().get(p.getUniqueId());
    }
    public static boolean containsPlayer(Player p){
        return getDatabase().containsKey(p.getUniqueId());
    }
    public static void initPlayer(Player p){
        database.put(p.getUniqueId(),new HashMap<String,Location>());
    }
    public static boolean homeExist(Player p, String home){
        if (getHomeList(p).containsKey(home))
            return true;
        else
            p.sendMessage("Cet home n'existe pas");
        return false;

    }
    public static void deleteHome(Player p, String home){
        if(homeExist(p,home))
            getHomeList(p).remove(home);
    }
}
