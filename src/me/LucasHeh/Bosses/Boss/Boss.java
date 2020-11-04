package me.LucasHeh.Bosses.Boss;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public interface Boss {
	
	@EventHandler
	public abstract void onSpawn(PlayerInteractEvent e);

	@EventHandler
	public abstract void onHit(EntityDamageByEntityEvent  e);

	@EventHandler
	public abstract void onDeath(EntityDeathEvent e);
	
}
