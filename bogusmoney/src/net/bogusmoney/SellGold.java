package net.bogusmoney;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SellGold implements CommandExecutor{

	public BogusMoney plugin;
	
	public SellGold(BogusMoney plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		MoneyManager money_manager = new MoneyManager(plugin);
		if (sender instanceof Player) {
			Player player = (Player) sender;
			double gold = 0;
			if (player.getInventory().contains(Material.GOLD_INGOT)){
				for (ItemStack item : player.getInventory().getContents()) {
					try {
						if (item.getType().equals(Material.GOLD_INGOT)) {
							gold += item.getAmount();
						}
					} catch (NullPointerException error) {
						continue;
					}
				}
			}
			for (ItemStack item : player.getInventory().getContents()) {
				try {
					if (item.getType().equals(Material.GOLD_INGOT)) {
						item.setAmount(0);
					}
				} catch (NullPointerException error) {
					continue;
				}
			}
			money_manager.addCurrency(player, gold);
			
		}
		return false;
	}

}
