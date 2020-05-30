package fr.hyrpik.log.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

import fr.hyrpik.log.Main;

public class EventListener implements Listener {
	
	private Main main;
	
	public EventListener(Main main) {
		this.main = main;
	}


	@EventHandler
	public void onClick(InventoryClickEvent e) {
		//Player p = (Player) e.getWhoClicked();
		Inventory inv = e.getInventory();
		//ItemStack it = e.getCurrentItem();
		
		if(inv.getName().equals("§eListe du staff")) {
			e.setCancelled(true);
		}
	}
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.sendMessage("§e/login pour ce connecter ou /register pour creer un mot de passe !");
		p.setGameMode(GameMode.ADVENTURE);
		p.setFoodLevel(20);
        p.setSaturation(20);
        p.setHealth(20);
        p.setInvulnerable(true);
		
		main.connect.add(p);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		main.connect.remove(p);
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(main.connect.contains(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(main.connect.contains(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if(main.connect.contains(p)) {
			e.setCancelled(true);
		}
	}

}
