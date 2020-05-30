package fr.hyrpik.log.command;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.hyrpik.log.Main;
import fr.hyrpik.log.manager.PlayerManager;

public class mod implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("Seul un joueur peut utiliser cette commande !");
			return false;
		}
		
		Player p = (Player) sender;
			if(!p.hasPermission("mod.use")) {
				p.sendMessage("Vous n'avez pas la permission d'utiliser cette commande !");
				return false;
			}
			
			if(PlayerManager.IsInModerationMod(p)) {
				PlayerManager pm = PlayerManager.getFromPlayer(p);
			   
			    

				Main.getInstance().getModerateur().remove(p.getUniqueId());
				p.getInventory().clear();
				p.sendMessage("Vous êtes plus dans le mode modération");
				pm.giveInventory();
				pm.destroy();
				p.setAllowFlight(false);
				p.setFlying(false);
				return false;
				 
			}
			
			PlayerManager pm = new PlayerManager(p);
			 pm.init();
			Main.getInstance().getModerateur().add(p.getUniqueId());
			p.sendMessage("Vous êtes a présent dans le mode Modération");
			pm.saveInventory();
			p.setAllowFlight(true);
			p.setFlying(true);
			
	        ItemStack fc = new ItemStack(Material.PAPER, 1);
	        ItemMeta fcMeta = fc.getItemMeta();
	        fcMeta.setDisplayName("§eOuvrir l'inventaire d'un joueur !");
	        fcMeta.setLore(Arrays.asList("§cClique droit sur un joueur", "§cpour ouvrir l'inventaire !"));
	        fc.setItemMeta(fcMeta);
	        
	        ItemStack fc2 = new ItemStack(Material.PACKED_ICE, 1);
	        ItemMeta fc2Meta = fc2.getItemMeta();
	        fc2Meta.setDisplayName("§eFreeze");
	        fc2Meta.setLore(Arrays.asList("§cClique droit sur un joueur", "§cpour freeze !"));
	        fc2.setItemMeta(fc2Meta);
	        
	        ItemStack fc3 = new ItemStack(Material.STICK, 1);
	        fc3.addUnsafeEnchantment(Enchantment.KNOCKBACK, 5);
	        ItemMeta fc3Meta = fc3.getItemMeta();
	        fc3Meta.setDisplayName("§eKBtester");
	        fc3Meta.setLore(Arrays.asList("§cClique gauche sur un joueur" , "§cpour vois ses KB !"));
	        fc3.setItemMeta(fc3Meta);
	        
	        ItemStack fc5 = new ItemStack(Material.ARROW, 1);
	        ItemMeta fc5Meta = fc5.getItemMeta();
	        fc5Meta.setDisplayName("§eTéléportation aléatoire");
	        fc5Meta.setLore(Arrays.asList("§cClique droit pour ce téléporté", "§caléatoirement !"));
	        fc5.setItemMeta(fc5Meta);
	        
	        ItemStack fc6 = new ItemStack(Material.BLAZE_POWDER, 1);
	        ItemMeta fc6Meta = fc6.getItemMeta();
	        fc6Meta.setDisplayName("§eCe mettre en vanish");
	        fc6Meta.setLore(Arrays.asList("§cClique droit pour activer/desactiver", "§cle vanish !"));
	        fc6.setItemMeta(fc6Meta);
	        
	        p.getInventory().setItem(0, fc);
	        p.getInventory().setItem(1, fc2);
	        p.getInventory().setItem(2, fc3);
	        p.getInventory().setItem(3, fc5);
	        p.getInventory().setItem(4, fc6);
		
		
		return false;
	}

}
