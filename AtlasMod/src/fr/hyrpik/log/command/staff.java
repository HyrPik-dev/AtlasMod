package fr.hyrpik.log.command;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class staff implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Player, String[] args) {
		
		Player pl = (Player) sender;
		Inventory inv = Bukkit.createInventory(null, 4*9, "§eListe du staff");
		
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(p.hasPermission("staff.gui")) {
				
				ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
				SkullMeta SkullMeta = (SkullMeta) skull.getItemMeta();
				SkullMeta.setDisplayName(p.getName());
				SkullMeta.setOwner(p.getName());
				skull.setItemMeta(SkullMeta);
				
				inv.addItem(skull);
			}
		}
		
		pl.openInventory(inv);
		
		return false;
	}

}
