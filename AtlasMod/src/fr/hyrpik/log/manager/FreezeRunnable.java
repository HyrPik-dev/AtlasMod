package fr.hyrpik.log.manager;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.hyrpik.log.Main;

public class FreezeRunnable extends BukkitRunnable {
    private int t = 0;
 
    @Override
    public void run() {
        for(UUID uuid : Main.getInstance().getFreezedPlayers().keySet()){
            Player player = Bukkit.getPlayer(uuid);
            if(player != null){
                player.teleport(Main.getInstance().getFreezedPlayers().get(uuid));
                if(t == 5){
                    player.sendMessage("§aMerci de venir §bDiscord !");
                }
            }
        }
 
        if(t == 5){
            t = 0;
        }
 
        t++;
    }
}
