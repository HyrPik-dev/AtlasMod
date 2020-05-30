package fr.hyrpik.log.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EventClickInventoryStaff {
	
    @EventHandler
    public void OnClick(InventoryClickEvent event) {
	 
   	 Inventory inv = event.getInventory();
   //Player player = (Player) event.getWhoClicked();
   	 ItemStack current = event.getCurrentItem();
   	 if(current == null) return;
   	 
   	 if(inv.getName().equalsIgnoreCase("§eListe du staff")) {
   		 event.setCancelled(true);
   		 
   		if(current.getType() == Material.SKULL_ITEM);
   	 }
   }
}
