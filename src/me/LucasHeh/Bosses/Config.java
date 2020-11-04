package me.LucasHeh.Bosses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import me.LucasHeh.Bosses.Enums.ArmorType;

public class Config {

	private static FileConfiguration config = Main.getInstance().getConfig();
	
	public static final String COMMANDS_NOPERMISSION = ChatColor.translateAlternateColorCodes('&', config.getString("Commands.NoPermission"));
	
	public static final String INVENTORY_BOSSEGGS_TITLE = ChatColor.translateAlternateColorCodes('&', config.getString("Inventory.BossEggs.Title"));
	public static final Material INVENTORY_BOSSEGGS_BACKGROUNDITEM = Material.getMaterial(config.getString("Inventory.BossEggs.Title"));
	
	public static final String BOSSES_PIGLIN_ENTITY_NAME = ChatColor.translateAlternateColorCodes('&', config.getString("Bosses.Piglin.Entity.Name"));
	public static final ArmorType BOSSES_PIGLIN_ENTITY_ARMORTYPE() {
		if(config.getString("Bosses.Piglin.Entity.ArmorType").equals("IRON")) return ArmorType.IRON;
		if(config.getString("Bosses.Piglin.Entity.ArmorType").equals("GOLD")) return ArmorType.GOLD;
		if(config.getString("Bosses.Piglin.Entity.ArmorType").equals("DIAMOND")) return ArmorType.DIAMOND;
		if(config.getString("Bosses.Piglin.Entity.ArmorType").equals("NETHERITE")) return ArmorType.NETHERITE;
		if(config.getString("Bosses.Piglin.Entity.ArmorType").equals("NONE")) return ArmorType.NONE;
		return ArmorType.NONE;
	}
	public static final int BOSSES_PIGLIN_ENTITY_PROTECTIONLEVEL = config.getInt("Bosses.Piglin.Entity.ProtectionLevel");
	public static final boolean BOSSES_PIGLIN_ENTITY_ARMORUNBREAKABLE = config.getBoolean("Bosses.Piglin.Entity.ArmorUnbreakble");
	public static final double BOSSES_PIGLIN_ENTITY_HEALTH = config.getDouble("Bosses.Piglin.Entity.Health");
	private static final Material BOSSES_PIGLIN_ENTITY_ITEMTYPE = Material.getMaterial(config.getString("Bosses.Piglin.Entity.ItemType"));
	public static final ItemStack BOSSES_PIGLIN_ENTITY_ITEM = getItemInHand(BOSSES_PIGLIN_ENTITY_ITEMTYPE, config.getStringList("Bosses.Piglin.Entity.ItemEnchants"));
	
	public static final Material BOSSES_PIGLIN_EGG_MATERIAL = Material.valueOf(config.getString("Bosses.Piglin.Egg.Material"));
	public static final String BOSSES_PIGLIN_EGG_NAME = ChatColor.translateAlternateColorCodes('&', config.getString("Bosses.Piglin.Egg.Name"));
	public static final boolean BOSSES_PIGLIN_EGG_GLOWING = config.getBoolean("Bosses.Piglin.Egg.Glowing");
	public static final List<String> BOSSES_PIGLIN_EGG_LORE = listTranslate(config.getStringList("Bosses.Piglin.Egg.Lore"));
	public static final String BOSSES_PIGLIN_PVP_HITMESSAGE = ChatColor.translateAlternateColorCodes('&', config.getString("Bosses.Piglin.Pvp.HitMessage"));
	public static final List<ItemStack> BOSSES_PIGLIN_PVP_DROPS(){
		return convertStringListToItemStackList(config.getStringList("Bosses.Piglim.Pvp.Drops"));
	}
	public static final List<String> BOSSES_PIGLIN_PVP_COMMANDS = config.getStringList("Bosses.Piglin.Pvp.Commands");
	public static final int BOSSES_PIGLIN_PVP_EXPERIENCEDROP = config.getInt("Bosses.Piglin.Pvp.ExperienceDrop");
	public static final List<String> BOSSES_PIGLIN_PVP_FINALHITCOMMANDS = config.getStringList("Bosses.Piglin.Pvp.FinalHitCommands");
	
	@SuppressWarnings("deprecation")
	private static ItemStack getItemInHand(Material itemType, List<String> enchants) {
		ItemStack item = new ItemStack(itemType);
		Map<Enchantment, Integer> enchantList = new HashMap<Enchantment, Integer>();
		for(String string : enchants) {
			String[] stringSplit = string.split("\\s+");
			enchantList.put(Enchantment.getByName(stringSplit[0]), Integer.valueOf(stringSplit[1]));
		}
		item.addUnsafeEnchantments(enchantList);
		return item;
	}
	
	private static List<ItemStack> convertStringListToItemStackList(List<String> list){
		List<ItemStack> items = new ArrayList<ItemStack>();
		for(String string : list) {
			String[] itemInfo = string.split("\\s+");
			ItemStack item = new ItemStack(Material.getMaterial(itemInfo[0]), Integer.valueOf(itemInfo[1]));
			items.add(item);
		}
		return items;
	}
			
	private static List<String> listTranslate(List<String> list){
		List<String> converted = new ArrayList<String>();
		for(String str : list) {
			converted.add(ChatColor.translateAlternateColorCodes('&', str));
		}
		return converted;
	}
}
