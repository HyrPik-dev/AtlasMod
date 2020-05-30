package fr.hyrpik.log.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Playerchatstaff implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(e.getMessage().startsWith("$") && p.hasPermission("chat.use")) {
			e.setCancelled(true);
			
			for(Player players : Bukkit.getOnlinePlayers()) {
				if(players.hasPermission("chat.use")) {
					players.sendMessage("§8(§2§lSTAFF CHAT§8) §6" + p.getName() + "§f: §e" + e.getMessage().substring(1));
				}
			}
			
			//Bukkit.getOnlinePlayers().stream().filter(players -> players.hasPermission("chat.use")).forEach(players -> players.sendMessage("§8(§2§lSTAFF CHAT§8) §6" + p.getName() + "§f: §e" + e.getMessage().substring(1)));
		}
	}

}
