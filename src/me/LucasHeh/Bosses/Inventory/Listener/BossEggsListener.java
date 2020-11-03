package me.LucasHeh.Bosses.Inventory.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

import me.LucasHeh.Bosses.Config;

public class BossEggsListener implements Listener{
	
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		InventoryView inv = (InventoryView) e.getInventory();
		if(e.getCurrentItem() == null) return;
		if(!inv.getTitle().equals(Config.INVENTORY_BOSSEGGS_TITLE)) return;
		
		
		
	}

}
