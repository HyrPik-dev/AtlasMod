package fr.hyrpik.log;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.hyrpik.log.command.login;
import fr.hyrpik.log.command.mod;
import fr.hyrpik.log.command.register;
import fr.hyrpik.log.command.report;
import fr.hyrpik.log.command.staff;
import fr.hyrpik.log.command.tete;
import fr.hyrpik.log.listener.EventClickInventory;
import fr.hyrpik.log.listener.EventListener;
import fr.hyrpik.log.listener.ModEvent;
import fr.hyrpik.log.listener.ModItemInteract;
import fr.hyrpik.log.listener.PlayerQuit;
import fr.hyrpik.log.listener.Playerchatstaff;
import fr.hyrpik.log.manager.FreezeRunnable;
import fr.hyrpik.log.manager.PlayerManager;
import fr.hyrpik.log.runnabemes.AutoMessage;

public class Main extends JavaPlugin {
	
	private static Main instance;
	public List<Player> connect = new ArrayList<>();
    private List<UUID> moderateur;
    private Map<UUID, PlayerManager> players;
    private Map<UUID, Location> FreezedPlayers;
	
	
	@Override
	public void onEnable() {
		instance = this;
		System.out.println("Plugin est en cours de chargement...");
		getLogger().info("..");
		getLogger().info("....");
		getLogger().info("........... OK !");
		
		//command
		getCommand("tete").setExecutor(new tete());
		getCommand("staff").setExecutor(new staff());
		getCommand("register").setExecutor(new register(this));
		getCommand("login").setExecutor(new login(this));
		getCommand("mod").setExecutor(new mod());
		getCommand("report").setExecutor(new report());
		
		//event
		getServer().getPluginManager().registerEvents(new EventListener(this), this);
		getServer().getPluginManager().registerEvents(new EventClickInventory(), this);
		getServer().getPluginManager().registerEvents(new ModEvent(), this);
		getServer().getPluginManager().registerEvents(new ModItemInteract(), this);
		getServer().getPluginManager().registerEvents(new Playerchatstaff(), this);
		getServer().getPluginManager().registerEvents(new PlayerQuit(), this);

		//saveConfig
		saveDefaultConfig();
		
		setup();
		
		//creation d'un fichier
		createFile("messages");
		
		
		
		
	}
	
	private void setup() {
		instance = this;
		moderateur = new ArrayList<>();
		players = new HashMap<>();
		FreezedPlayers = new HashMap<>();
		new FreezeRunnable().runTaskTimer(this, 0, 20);
		new AutoMessage().runTaskTimer(this, 10 * 20L, 10 * 20L);
	}
	
    public void onDisable() {
        System.out.println("Le plugin est en cour de déchargement ...");
        getLogger().info("..");
        getLogger().info(".... ");
        getLogger().info("........... OK");
       }
    
	public static Main getInstance() {
		return instance;
	}
	
	public List<UUID> getModerateur() {
		return moderateur;
	}
	
	public Map<UUID, PlayerManager> getPlayers() {
		return players;
	}
	
	public Map<UUID, Location> getFreezedPlayers() {
		return FreezedPlayers;
	}
	
	private void createFile(String fileName) {
		if(!getDataFolder().exists()) {
			getDataFolder().mkdir();
		}
		
		File file = new File(getDataFolder(), fileName + ".yml");
		
		if(!file.exists()) {
			try {
				file.createNewFile();
				
				if(fileName.equalsIgnoreCase("messages")) {
					FileConfiguration config = getConfig("messages");
					config.set("messages", Arrays.asList("§6Ceci est un message d'exemple !"));
					save(file, config);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private File getFile(String fileName) {
		return new File(getDataFolder(), fileName + ".yml");
	}
	
	public FileConfiguration getConfig(String fileName) {
		return YamlConfiguration.loadConfiguration(getFile(fileName));
	}
	
	public void save(File file, FileConfiguration config) {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
