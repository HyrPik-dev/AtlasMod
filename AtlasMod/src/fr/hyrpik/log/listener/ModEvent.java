package fr.hyrpik.log.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import fr.hyrpik.log.manager.PlayerManager;

public class ModEvent implements Listener {
	
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e) {
		e.setCancelled(PlayerManager.IsInModerationMod(e.getPlayer()));
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		e.setCancelled(PlayerManager.IsInModerationMod(e.getPlayer()));
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		e.setCancelled(PlayerManager.IsInModerationMod(e.getPlayer()));
	}
	
	@EventHandler
	public void onItemPickup(PlayerPickupItemEvent e) {
		e.setCancelled(PlayerManager.IsInModerationMod(e.getPlayer()));
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if(!(e.getEntity() instanceof Player)) return;
		e.setCancelled(PlayerManager.IsInModerationMod((Player) e.getEntity()));
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		if(!(e.getEntity() instanceof Player)) return;
		if(!(e.getDamager() instanceof Player)) return;
		Player damager = (Player) e.getDamager();
		
		if(PlayerManager.IsInModerationMod(damager)) {
			e.setCancelled(damager.getInventory().getItemInHand().getType() != Material.STICK);
		}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		e.setCancelled(PlayerManager.IsInModerationMod(e.getPlayer()));
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		e.setCancelled(PlayerManager.IsInModerationMod((Player) e.getWhoClicked()));
	}

}
