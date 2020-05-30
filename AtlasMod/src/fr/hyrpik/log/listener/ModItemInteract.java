package fr.hyrpik.log.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;

import fr.hyrpik.log.Main;
import fr.hyrpik.log.manager.PlayerManager;

public class ModItemInteract implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		if(!PlayerManager.IsInModerationMod(p)) return;
		if(!e.getHand().equals(EquipmentSlot.HAND))return;
		if(!(e.getRightClicked() instanceof Player)) return;
		Player target = (Player) e.getRightClicked();
		
		e.setCancelled(true);
		
		switch (p.getInventory().getItemInHand().getType()) {
		
		//Voir l'inventaire
		
		case PAPER:
			Inventory inv = Bukkit.createInventory(null, 5 * 9, target.getName() + " > Inventaire");
			
			for(int i = 0; i < 36; i++) {
				if(target.getInventory().getItem(i) != null) {
					inv.setItem(i, target.getInventory().getItem(i));
				}
			}
			
			inv.setItem(36, target.getInventory().getHelmet());
			inv.setItem(37, target.getInventory().getChestplate());
			inv.setItem(38, target.getInventory().getLeggings());
			inv.setItem(39, target.getInventory().getBoots());
			
			p.openInventory(inv);
			break;
			
        case PACKED_ICE:
        	e.setCancelled(true);
            if(Main.getInstance().getFreezedPlayers().containsKey(target.getUniqueId())){
                Main.getInstance().getFreezedPlayers().remove(target.getUniqueId());
                target.sendMessage("§aVous avez été unfreeze par §e" + p.getName());
                p.sendMessage("§aVous avez unfreeze §e" + target.getName());
            } else {
                Main.getInstance().getFreezedPlayers().put(target.getUniqueId(), target.getLocation());
                target.sendMessage("§bVous avez été freeze par §e" + p.getName());
                p.sendMessage("§bVous avez freeze §e" + target.getName());
            }
            break;

		default: break;
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(!PlayerManager.IsInModerationMod(p)) return;
		if(e.getAction() != Action.RIGHT_CLICK_BLOCK && e.getAction() != Action.RIGHT_CLICK_AIR) return;
		
		switch (p.getInventory().getItemInHand().getType()){
		//téléportation random.
		
		case ARROW:
			List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());
			list.remove(p);
			
			if(list.size() == 0) {
				p.sendMessage("§cIl n'y à pas de joueur sur lequel vous téléportez.");
				return;
			}
			
			Player target = list .get(new Random().nextInt(list.size()));
			p.teleport(target.getLocation());
			p.sendMessage("§aVous avez était téléporté à §e" + target.getName());
			
			break;
			
			//vanish
			
		case BLAZE_POWDER:
			PlayerManager mod = PlayerManager.getFromPlayer(p);
			mod.setVanished(!mod.isVanished());
			p.sendMessage(mod.isVanished() ? "§aVous êtes à présent invisible !" : "§bVous êtes maintenant visible !");
			
			break;

		default:
			break;
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		for(Player players : Bukkit.getOnlinePlayers()) {
			if(PlayerManager.IsInModerationMod(players)){
				PlayerManager pm = PlayerManager.getFromPlayer(players);
				if(pm.isVanished()) {
					p.hidePlayer(players);
				}
			}
		}
	}

}
