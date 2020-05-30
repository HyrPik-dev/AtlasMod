package fr.hyrpik.log.command;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class report implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(args.length == 0) {
			p.sendMessage("§eVeuillez saisir le pseudo d'un joueur !");
			return false;
		}
		String targetName = args[0];
		
		if(Bukkit.getPlayer(targetName) == null) {
			p.sendMessage("§cCe joueur n'est pas connecté ou n'existe pas !");
			return false;
		}
		
	    Player target = Bukkit.getPlayer(targetName);
	    
	    Inventory inv = Bukkit.createInventory(null, 18, "§7[§eReport§7]§r: §c" + target.getName());
	    
        ItemStack fc = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta fcMeta = fc.getItemMeta();
        fcMeta.setDisplayName("§cForceField / KillAura");
        fcMeta.setLore(Arrays.asList(" "));
        fc.setItemMeta(fcMeta);
        inv.setItem(0, fc);
        
        ItemStack sb = new ItemStack(Material.BOW, 1);
        ItemMeta sbMeta = sb.getItemMeta();
        sbMeta.setDisplayName("§cFastBow");
        sbMeta.setLore(Arrays.asList(" "));
        sb.setItemMeta(sbMeta);
        inv.setItem(1, sb);
        
        ItemStack r = new ItemStack(Material.FEATHER, 1);
        ItemMeta rMeta = sb.getItemMeta();
        rMeta.setDisplayName("§cFly / SpeedHack");
        rMeta.setLore(Arrays.asList(" "));
        r.setItemMeta(rMeta);
        inv.setItem(2, r);
        
        ItemStack ka = new ItemStack(Material.SLIME_BALL, 1);
        ItemMeta kaMeta = ka.getItemMeta();
        kaMeta.setDisplayName("§cAntiJeu / Camp");
        kaMeta.setLore(Arrays.asList(" "));
        ka.setItemMeta(kaMeta);
        inv.setItem(3, ka);
        
        ItemStack i1 = new ItemStack(Material.PAPER, 1);
        ItemMeta iMeta = i1.getItemMeta();
        iMeta.setDisplayName("§cInsulte / Provocation");
        iMeta.setLore(Arrays.asList(" "));
        i1.setItemMeta(iMeta);
        inv.setItem(4, i1);
        
        ItemStack i = new ItemStack(Material.ANVIL, 1);
        ItemMeta i1Meta = i.getItemMeta();
        i1Meta.setDisplayName("§cKB Reducer");
        i1Meta.setLore(Arrays.asList(" "));
        i.setItemMeta(i1Meta);
        inv.setItem(5, i);
        
        ItemStack UB = new ItemStack(Material.APPLE, 1);
        ItemMeta UBMeta = UB.getItemMeta();
        UBMeta.setDisplayName("§cUseBug");
        UBMeta.setLore(Arrays.asList(" "));
        UB.setItemMeta(UBMeta);
        inv.setItem(6, UB);
        
        ItemStack AC = new ItemStack(Material.REDSTONE, 1);
        ItemMeta ACMeta = UB.getItemMeta();
        ACMeta.setDisplayName("§cAutoClicks");
        ACMeta.setLore(Arrays.asList(" "));
        AC.setItemMeta(ACMeta);
        inv.setItem(7, AC);
        
        ItemStack FB = new ItemStack(Material.QUARTZ_BLOCK, 1);
        ItemMeta FBMeta = FB.getItemMeta();
        FBMeta.setDisplayName("§cFastBlock");
        FBMeta.setLore(Arrays.asList(" "));
        FB.setItemMeta(FBMeta);
        inv.setItem(8, FB);
        
        ItemStack Sp = new ItemStack(Material.STRING, 1);
        ItemMeta SpMeta = Sp.getItemMeta();
        SpMeta.setDisplayName("§cSpider");
        SpMeta.setLore(Arrays.asList(" "));
        Sp.setItemMeta(SpMeta);
        inv.setItem(9, Sp);
        
        ItemStack ASp = new ItemStack(Material.BEETROOT_SOUP, 1);
        ItemMeta ASpMeta = ASp.getItemMeta();
        ASpMeta.setDisplayName("§cAutoSoup / AutoPot");
        ASpMeta.setLore(Arrays.asList(" "));
        ASp.setItemMeta(ASpMeta);
        inv.setItem(10, ASp);
        
        ItemStack Aim = new ItemStack(Material.REDSTONE_BLOCK, 1);
        ItemMeta AimMeta = Aim.getItemMeta();
        AimMeta.setDisplayName("§cAimBot / AimAssist");
        AimMeta.setLore(Arrays.asList(" "));
        Aim.setItemMeta(AimMeta);
        inv.setItem(11, Aim);
        
		ItemStack ps = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta psMeta = (SkullMeta) ps.getItemMeta();
        psMeta.setDisplayName("§cPseudo / Skin Incorrect");
        psMeta.setLore(Arrays.asList(" "));
        ps.setItemMeta(psMeta);
        inv.setItem(12, ps);
        
        p.openInventory(inv);
		
		return false;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		e.setCancelled(true);
	}

}
