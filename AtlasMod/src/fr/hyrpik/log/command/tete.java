package fr.hyrpik.log.command;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class tete implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Player, String[] args) {
		
		if(args.length == 1) {
			String name = args[0];
			Player p = (Player) sender;
			
			ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
			SkullMeta SkullMeta = (SkullMeta) skull.getItemMeta();
			SkullMeta.setDisplayName("Tête de "+ name);
			SkullMeta.setOwner(args[0]);
			skull.setItemMeta(SkullMeta);
			p.getInventory().addItem(skull);
			p.sendMessage("Vous avez reçus la tête de "+ name);
		}
		
		if(args.length == 0) {
			Player p = (Player) sender;
			p.sendMessage("Merci de préciser une personne.");
		}
		
		return false;
	}

}
