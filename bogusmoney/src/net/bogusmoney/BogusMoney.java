package net.bogusmoney;

import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

public class BogusMoney extends JavaPlugin {

	@Override
	public void onEnable() {
		MoneyManager money_manager = new MoneyManager(this);
		try {
			money_manager.load_money();
		}catch(ClassNotFoundException | IOException error) {
			error.printStackTrace();
		}
		this.getCommand("money").setExecutor(new MoneyCommands(this));
		this.getCommand("bal").setExecutor(new bal(this));
		this.getCommand("sellgold").setExecutor(new SellGold(this));
	}
	
	@Override
	public void onDisable() {
		MoneyManager money_manager = new MoneyManager(this);
		try {
			money_manager.save_money();
		}catch(IOException error) {
			error.printStackTrace();
		}
	}
}
