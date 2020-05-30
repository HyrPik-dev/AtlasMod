package fr.hyrpik.log.runnabemes;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import fr.hyrpik.log.Main;
import net.md_5.bungee.api.ChatColor;

public class AutoMessage extends BukkitRunnable {
		
	private List<String> messages = Main.getInstance().getConfig("messages").getStringList("messages");
	private int i = 0;
	
	
	@Override
	public void run() {
		if(messages.isEmpty()) {
			cancel();
			return;
		}
		
		if(i >= messages.size()) {
			i = 0;
		}
		
		Bukkit.broadcastMessage("§7[§6Annonce Atlas§7]§r " + ChatColor.translateAlternateColorCodes('&', messages.get(i)));
		
		i++;
	}

}
