package me.LucasHeh.Bosses;

import org.bukkit.Material;

import me.LucasHeh.Bosses.Enums.ArmorType;
import me.LucasHeh.Bosses.Enums.BossType;

public class Utils {

	private Main main = Main.getInstance();
	
	public Utils() {
		
	}
	
	public Material getHelmet(BossType boss) {
		if(boss == BossType.Piglin) {
			if(Config.BOSSES_PIGLIN_ENTITY_ARMORTYPE() == ArmorType.IRON) return Material.IRON_HELMET;
			if(Config.BOSSES_PIGLIN_ENTITY_ARMORTYPE() == ArmorType.GOLD) return Material.GOLDEN_HELMET;
			if(Config.BOSSES_PIGLIN_ENTITY_ARMORTYPE() == ArmorType.DIAMOND) return Material.DIAMOND_HELMET;
			if(Config.BOSSES_PIGLIN_ENTITY_ARMORTYPE() == ArmorType.NETHERITE) return Material.NETHERITE_HELMET;
		}
		return null;
	}
	public Material getChestplate(BossType boss) {
		if(boss == BossType.Piglin) {
			if(Config.BOSSES_PIGLIN_ENTITY_ARMORTYPE() == ArmorType.IRON) return Material.IRON_CHESTPLATE;
			if(Config.BOSSES_PIGLIN_ENTITY_ARMORTYPE() == ArmorType.GOLD) return Material.GOLDEN_CHESTPLATE;
			if(Config.BOSSES_PIGLIN_ENTITY_ARMORTYPE() == ArmorType.DIAMOND) return Material.DIAMOND_CHESTPLATE;
			if(Config.BOSSES_PIGLIN_ENTITY_ARMORTYPE() == ArmorType.NETHERITE) return Material.NETHERITE_CHESTPLATE;
		}
		return null;
	}
	public Material getLeggings(BossType boss) {
		if(boss == BossType.Piglin) {
			if(Config.BOSSES_PIGLIN_ENTITY_ARMORTYPE() == ArmorType.IRON) return Material.IRON_LEGGINGS;
			if(Config.BOSSES_PIGLIN_ENTITY_ARMORTYPE() == ArmorType.GOLD) return Material.GOLDEN_LEGGINGS;
			if(Config.BOSSES_PIGLIN_ENTITY_ARMORTYPE() == ArmorType.DIAMOND) return Material.DIAMOND_LEGGINGS;
			if(Config.BOSSES_PIGLIN_ENTITY_ARMORTYPE() == ArmorType.NETHERITE) return Material.NETHERITE_LEGGINGS;
		}
		return null;
	}
	public Material getBoots(BossType boss) {
		if(boss == BossType.Piglin) {
			if(Config.BOSSES_PIGLIN_ENTITY_ARMORTYPE() == ArmorType.IRON) return Material.IRON_BOOTS;
			if(Config.BOSSES_PIGLIN_ENTITY_ARMORTYPE() == ArmorType.GOLD) return Material.GOLDEN_BOOTS;
			if(Config.BOSSES_PIGLIN_ENTITY_ARMORTYPE() == ArmorType.DIAMOND) return Material.DIAMOND_BOOTS;
			if(Config.BOSSES_PIGLIN_ENTITY_ARMORTYPE() == ArmorType.NETHERITE) return Material.NETHERITE_BOOTS;
		}
		return null;
	}

	public Main getMain() {
		return main;
	}
	
}
