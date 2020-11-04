package me.LucasHeh.Bosses;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import me.LucasHeh.Bosses.Boss.PiglinBoss;
import me.LucasHeh.Bosses.Commands.Boss;
import me.LucasHeh.Bosses.Inventory.Listener.BossEggsListener;

public class Main extends JavaPlugin{
	
	private static Main instance;
	private Utils utils;
	
	@Override
	public void onEnable() {
		instance = this;
		utils = new Utils();
		saveDefaultConfig();
		Bukkit.getServer().getPluginManager().registerEvents(new BossEggsListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PiglinBoss(), this);
		new Boss(this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	public Utils getUtils() {
		return utils;
	}
	
	private List<String> listTranslate(List<String> list){
		List<String> converted = new ArrayList<String>();
		for(String str : list) {
			converted.add(ChatColor.translateAlternateColorCodes('&', str));
		}
		return converted;
	}
	
	public void itemToInventory(Material mat, String displayName, List<String> lore, int slot, Inventory inv) {
		ItemStack item = new ItemStack(mat);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));
		if(lore != null) meta.setLore(listTranslate(lore));
		item.setItemMeta(meta);
		inv.setItem(slot, item);
	}
	
	// Boss Eggs
	
	public ItemStack piglinEgg() {
		ItemStack item = new ItemStack(Config.BOSSES_PIGLIN_EGG_MATERIAL);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Config.BOSSES_PIGLIN_EGG_NAME);
		meta.setLore(Config.BOSSES_PIGLIN_EGG_LORE);
		if(Config.BOSSES_PIGLIN_EGG_GLOWING) {
			meta.addEnchant(Enchantment.DURABILITY, 1, false);
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		item.setItemMeta(meta);
		return item;
	}

}
