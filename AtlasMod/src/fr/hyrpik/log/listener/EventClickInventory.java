package fr.hyrpik.log.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class EventClickInventory implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getCurrentItem() == null) return;
		
		Player p = (Player) e.getWhoClicked();
		
		switch (e.getCurrentItem().getType()) {
		case IRON_SWORD:
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cForceField")) {
				e.setCancelled(true);
				p.closeInventory();
				sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(12));
				p.sendMessage("§eVous avez bien signalé ce joueur !");
			}
			
			break;
			
		case BOW:
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cSpamBow")) {
				e.setCancelled(true);
				p.closeInventory();
				sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(12));
				p.sendMessage("§eVous avez bien signalé ce joueur !");
			}
			
			break;
			
		case FEATHER:
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cFly / SpeedHack")) {
				e.setCancelled(true);
				p.closeInventory();
				sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(12));
				p.sendMessage("§eVous avez bien signalé ce joueur !");
			}
			
			break;
			
		case SLIME_BALL:
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cAntiJeu / Camp")) {
				e.setCancelled(true);
				p.closeInventory();
				sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(12));
				p.sendMessage("§eVous avez bien signalé ce joueur !");
			}
			
			break;
			
		case PAPER:
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cInsulte / Provocation")) {
				e.setCancelled(true);
				p.closeInventory();
				sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(12));
				p.sendMessage("§eVous avez bien signalé ce joueur !");
			}
			
			break;
			
		case ANVIL:
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cKB Reducer")) {
				e.setCancelled(true);
				p.closeInventory();
				sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(12));
				p.sendMessage("§eVous avez bien signalé ce joueur !");
			}
			
			break;
			
		case APPLE:
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cUseBug")) {
				e.setCancelled(true);
				p.closeInventory();
				sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(12));
				p.sendMessage("§eVous avez bien signalé ce joueur !");
			}
			
			break;
		
		case REDSTONE:
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cAutoClicks")) {
				e.setCancelled(true);
				p.closeInventory();
				sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(12));
				p.sendMessage("§eVous avez bien signalé ce joueur !");
			}
			
			break;
			
		case QUARTZ_BLOCK:
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cFastBlock")) {
				e.setCancelled(true);
				p.closeInventory();
				sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(12));
				p.sendMessage("§eVous avez bien signalé ce joueur !");
			}
			
			break;
			
		case STRING:
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cSpider")) {
				e.setCancelled(true);
				p.closeInventory();
				sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(12));
				p.sendMessage("§eVous avez bien signalé ce joueur !");
			}
			
			break;
			
		case BEETROOT_SOUP:
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cAutoSoup / AutoPot")) {
				e.setCancelled(true);
				p.closeInventory();
				sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(12));
				p.sendMessage("§eVous avez bien signalé ce joueur !");
			}
			
			break;
		
		case REDSTONE_BLOCK:
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cAimBot / AimAssist")) {
				e.setCancelled(true);
				p.closeInventory();
				sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(12));
				p.sendMessage("§eVous avez bien signalé ce joueur !");
			}
			
			break;
			
		case SKULL_ITEM:
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cPseudo / Skin Incorrect")) {
				e.setCancelled(true);
				p.closeInventory();
				sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(12));
				p.sendMessage("§eVous avez bien signalé ce joueur !");
			}
			
			break;
			

		default: break;
		}
	}

	private void sendToMods(String reason, String Name) {
		
		for(Player players : Bukkit.getOnlinePlayers()) {
			if(players.hasPermission("mod.receive")) {
				players.sendMessage("§7[§eReport§7] §c" + Name + " §rà était sgnalé pour: §c" + reason);
			}
		}
		
	}

}
