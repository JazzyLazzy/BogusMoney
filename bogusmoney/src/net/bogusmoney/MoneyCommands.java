package net.bogusmoney;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MoneyCommands implements CommandExecutor {
	
	public BogusMoney plugin;
	
	public MoneyCommands(BogusMoney plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		MoneyManager money_manager = new MoneyManager(plugin);
		System.out.println(args[0]);
		if (args[0].equals("add")){
			@SuppressWarnings("deprecation")
			OfflinePlayer player = Bukkit.getOfflinePlayer(args[1]);
			money_manager.addCurrency(player, Double.parseDouble(args[2]));	
		}else if (args[0].equals("remove")){
			@SuppressWarnings("deprecation")
			OfflinePlayer player = Bukkit.getOfflinePlayer(args[1]);
			money_manager.removeCurrency(player, Double.parseDouble(args[2]));	
		}
		return false;
	}
}
