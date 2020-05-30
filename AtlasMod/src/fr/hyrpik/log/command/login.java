package fr.hyrpik.log.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.hyrpik.log.Main;

public class login implements CommandExecutor {
	
	private Main main;

	public login(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Player, String[] args) {
		Player p = (Player) sender;
		if(!main.connect.contains(p)) return false;
		if(main.getConfig().getString("Password." + p.getName()) == null) {
			sender.sendMessage("§7[§eAtlasAuth§7] §4Vous avez pas de mot de passe §e/register pour en creer un !");
			return false;
		}
		
		if(main.getConfig().getString("Password." + p.getName()).equals(args[0])) {
			main.connect.remove(p);
			p.sendMessage("§7[§eAtlasAuth§7] §2Mot de passe correct. Bienvenue " + p.getName());
		}
		else {
			p.sendMessage("§7[§eAtlasAuth§7] §4Mauvais mot de passe !");
		}
		
		
		return false;
	}

}
