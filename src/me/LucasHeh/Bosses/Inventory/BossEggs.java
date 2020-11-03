package me.LucasHeh.Bosses.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.LucasHeh.Bosses.Config;
import me.LucasHeh.Bosses.Main;

public class BossEggs {
	
	private Main main = Main.getInstance();

	public BossEggs(Player p) {
		openInv(p);
	}
	
	public void openInv(Player p) {
		Inventory inv = Bukkit.createInventory(p, 36, Config.INVENTORY_BOSSEGGS_TITLE);
		for(int i = 0; i<inv.getSize(); i++) {
			 if(i == 0) {
				ItemStack item = new ItemStack(Config.BOSSES_PIGLIN_EGG_MATERIAL);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(Config.BOSSES_PIGLIN_EGG_NAME);
				meta.setLore(Config.BOSSES_PIGLIN_EGG_LORE);
				if(Config.BOSSES_PIGLIN_EGG_GLOWING) {
					meta.addEnchant(Enchantment.DURABILITY, 1, false);
					meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				}
				item.setItemMeta(meta);
				inv.setItem(i, item);
			 } else if(i == 31) {
				 main.itemToInventory(Material.BARRIER, "&cExit", null, i, inv);
			 } else {
				 main.itemToInventory(Config.INVENTORY_BOSSEGGS_BACKGROUNDITEM, " ", null, i, inv);
			 }
		}
		p.openInventory(inv);
	}
	
}
