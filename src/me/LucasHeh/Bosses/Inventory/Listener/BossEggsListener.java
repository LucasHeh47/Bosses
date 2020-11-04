package me.LucasHeh.Bosses.Inventory.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

import me.LucasHeh.Bosses.Config;
import me.LucasHeh.Bosses.Main;

public class BossEggsListener implements Listener{
	
	private Main main = Main.getInstance();
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		InventoryView inv = (InventoryView) e.getInventory();
		if(e.getCurrentItem() == null) return;
		if(!inv.getTitle().equals(Config.INVENTORY_BOSSEGGS_TITLE)) return;
		
		if(e.getCurrentItem().getType() == Config.BOSSES_PIGLIN_EGG_MATERIAL && e.getCurrentItem().getItemMeta().getDisplayName().equals(Config.BOSSES_PIGLIN_EGG_NAME)) {
			p.getInventory().addItem(main.piglinEgg());
		} else if(e.getCurrentItem().getType() == Material.BARRIER) {
			p.closeInventory();
		}
	}

}
