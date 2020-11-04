package me.LucasHeh.Bosses.Boss;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.LucasHeh.Bosses.Config;
import me.LucasHeh.Bosses.Main;
import me.LucasHeh.Bosses.Utils;
import me.LucasHeh.Bosses.Enums.BossType;

public class PiglinBoss implements Boss, Listener{
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSpawn(PlayerInteractEvent e) {
		if(e.getItem() == null)
			return;
		if(e.getItem().getType() == Config.BOSSES_PIGLIN_EGG_MATERIAL && e.getItem().getItemMeta().getDisplayName().equals(
				Config.BOSSES_PIGLIN_EGG_NAME) && e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			e.setCancelled(true);
			Location location = e.getClickedBlock().getLocation().add(0, 1, 0);
			Piglin zombie = location.getWorld().spawn(location, Piglin.class);
			e.getPlayer().getInventory().remove(main.piglinEgg());
			zombie.setImmuneToZombification(true);
			zombie.setCustomName(ChatColor.translateAlternateColorCodes('&', Config.BOSSES_PIGLIN_ENTITY_NAME));
			zombie.setMaxHealth(Config.BOSSES_PIGLIN_ENTITY_HEALTH);
			zombie.setHealth(Config.BOSSES_PIGLIN_ENTITY_HEALTH);
			
			zombie.setCustomNameVisible(true);
			zombie.setBaby(false);
			
			ItemStack helmet = new ItemStack(utils.getHelmet(BossType.Piglin));
			helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Config.BOSSES_PIGLIN_ENTITY_PROTECTIONLEVEL);
			zombie.getEquipment().setHelmet(helmet);

			ItemStack chestplate = new ItemStack(utils.getChestplate(BossType.Piglin));
			chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Config.BOSSES_PIGLIN_ENTITY_PROTECTIONLEVEL);
			zombie.getEquipment().setChestplate(chestplate);

			ItemStack leggings = new ItemStack(utils.getChestplate(BossType.Piglin));
			leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Config.BOSSES_PIGLIN_ENTITY_PROTECTIONLEVEL);
			zombie.getEquipment().setLeggings(leggings);

			ItemStack boots = new ItemStack(utils.getChestplate(BossType.Piglin));
			boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Config.BOSSES_PIGLIN_ENTITY_PROTECTIONLEVEL);
			zombie.getEquipment().setBoots(boots);
			
			zombie.getEquipment().setItemInMainHand(Config.BOSSES_PIGLIN_ENTITY_ITEM);
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onHit(EntityDamageByEntityEvent  e) {
		if(e.getEntity().getType() == EntityType.PIGLIN && e.getEntity().getCustomName().equals(Config.BOSSES_PIGLIN_ENTITY_NAME)) {
			if(((LivingEntity)e.getEntity()).getHealth() <= 5.0) {
				Zombie zombie = (Zombie) e.getEntity();
				zombie.getEquipment().setHelmet(null);
				zombie.getEquipment().setChestplate(null);
				zombie.getEquipment().setLeggings(null);
				zombie.getEquipment().setBoots(null);
			}
			if(e.getDamager() == null) 
				return;
			if(e.getDamager() instanceof Player) {
				((Player) e.getDamager()).sendMessage(ChatColor.translateAlternateColorCodes
						('&', Config.BOSSES_PIGLIN_PVP_HITMESSAGE
								.replace("{HEALTH}", String.valueOf(((LivingEntity)e.getEntity()).getHealth()))
								.replace("{MAXHEALTH}", String.valueOf(((LivingEntity)e.getEntity()).getMaxHealth()))));
			}	
		}
	}
	
	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		if(e.getEntity() == null) return;
		if(e.getEntity().getType() == EntityType.PIGLIN && e.getEntity().getCustomName().equals(Config.BOSSES_PIGLIN_ENTITY_NAME)) {
			e.setDroppedExp(Config.BOSSES_PIGLIN_PVP_EXPERIENCEDROP);
			e.getDrops().clear();
			for(ItemStack item : Config.BOSSES_PIGLIN_PVP_DROPS()) {
				e.getDrops().add(item);
			}
			for(String cmd : Config.BOSSES_PIGLIN_PVP_COMMANDS) {
				Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), cmd);
			}
			for(String cmd : Config.BOSSES_PIGLIN_PVP_FINALHITCOMMANDS) {
				Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), cmd.replace("{PLAYER}", e.getEntity().getKiller().getName()));
			}
		}
	}


}
