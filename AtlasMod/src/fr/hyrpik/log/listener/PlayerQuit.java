package fr.hyrpik.log.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.hyrpik.log.manager.PlayerManager;

public class PlayerQuit implements Listener {
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if(PlayerManager.IsInModerationMod(p)) {
			PlayerManager pm = PlayerManager.getFromPlayer(p);
			p.getInventory().clear();
			pm.giveInventory();
			pm.destroy();
			p.setAllowFlight(false);
			p.setFlying(false);
		}
	}

}
