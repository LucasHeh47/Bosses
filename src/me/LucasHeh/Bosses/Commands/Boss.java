package me.LucasHeh.Bosses.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.LucasHeh.Bosses.Config;
import me.LucasHeh.Bosses.Main;
import me.LucasHeh.Bosses.Inventory.BossEggs;

public class Boss implements CommandExecutor {

	public Boss(Main main) {
		main.getCommand("boss").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(!(sender instanceof Player)) {
			return true;
		}
		if(!sender.hasPermission("bosses.give")) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.COMMANDS_NOPERMISSION));
			return true;
		}
		Player p = (Player) sender;
		new BossEggs(p);
		
		return true;
	}
	
}
