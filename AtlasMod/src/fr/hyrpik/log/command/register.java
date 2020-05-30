package fr.hyrpik.log.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.hyrpik.log.Main;

public class register implements CommandExecutor {

	private Main main;
	
	
	public register(Main main) {
		this.main = main;
	}


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Player, String[] args) {
		
		Player p = (Player) sender;
		
		if(args[0].equalsIgnoreCase("modify")) {
			if(!main.connect.contains(p)) {
				main.getConfig().set("Password." + p.getName(), args[1]);
				main.saveConfig();
				p.sendMessage("§7[§eAtlasAuth§7] Votre nouveau mot de passe est §c" + args[1]);
				return false;
			}
		}
		
		if(!main.connect.contains(p)) return false;
		if(!(main.getConfig().getString("Password." + p.getName()) == null)) {
			sender.sendMessage("§7[§eAtlasAuth§7] §cVous avez deja un mot de passe faite /login pour vous connecter !");
			return false;
		}
		
		main.getConfig().set("Password." + p.getName(), args[0]);
		main.saveConfig();
		p.sendMessage("§7[§eAtlasAuth§7] §2Vous vous etes bien enregistrer merci de faire: §e/login <mot de passe> §2pour se connecter !");
		
		return false;
	}

}
