package net.bogusmoney;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;


public class MoneyManager {

	public static HashMap<UUID, Double> money = new HashMap<UUID, Double>();
	
	public BogusMoney plugin;
	
	public MoneyManager(BogusMoney plugin) {
		this.plugin = plugin;
	}
	
	public void save_money() throws FileNotFoundException, IOException {
		System.out.println("goodbye");
		for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
			File file = new File("./money.dat");
			ObjectOutputStream output = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(file)));
			UUID uuid = player.getUniqueId();
			if (money.get(uuid) != null) {
				money.put(uuid, money.get(uuid));
			}
			try {
				output.writeObject(money);
				output.flush();
				output.close();
			}catch(IOException error) {
				error.printStackTrace();				
			}
		
		}
		
		
		
	}
	
	@SuppressWarnings("unchecked")
	public void load_money() throws FileNotFoundException, IOException, ClassNotFoundException {
		try {
		File file = new File("./money.dat");
		file.createNewFile();
			if (file != null) {
				ObjectInputStream input = new ObjectInputStream(new GZIPInputStream(new FileInputStream(file)));
				Object readObject = input.readObject();
				input.close();
				
				if (!(readObject instanceof HashMap)) {
					throw new IOException("Not HashMap");
				}
				money = (HashMap<UUID, Double>) readObject;
				System.out.println("hmoney" + money);
				for (UUID key : money.keySet()) {
					money.put(key, money.get(key));
				}
			}
		}catch (IOException error) {
			error.printStackTrace();
		}
	}
	
	public void addCurrency(OfflinePlayer player, Double amount) {
		UUID uuid = player.getUniqueId();
		if(money.get(uuid) != null) {
			System.out.println("hi");
			money.put(uuid, money.get(uuid) + amount);
		}else {
			System.out.println("gei");
			money.put(uuid, amount);
		}
		System.out.println("total" + money.get(player.getUniqueId()));
	}
	
	public void removeCurrency(OfflinePlayer player, double amount) {
		UUID uuid = player.getUniqueId();
		if(money.get(uuid) != null) {
			System.out.println("hi");
			money.put(uuid, money.get(uuid) - amount);
		}else {
			System.out.println("gei");
			money.put(uuid, amount);
		}
		System.out.println("total" + money.get(player.getUniqueId()));
	}
	
	public double bal(OfflinePlayer player) {
		return money.get(player.getUniqueId()).doubleValue();
	}
}
