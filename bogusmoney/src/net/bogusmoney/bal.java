package net.bogusmoney;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class bal implements CommandExecutor{

	public BogusMoney plugin;
	
	public bal(BogusMoney plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		MoneyManager money_manager = new MoneyManager(plugin);
		@SuppressWarnings("deprecation")
		OfflinePlayer player = Bukkit.getOfflinePlayer(args[0]);
		sender.sendMessage(String.valueOf(money_manager.bal(player)));
		return false;
	}
	
	

}
