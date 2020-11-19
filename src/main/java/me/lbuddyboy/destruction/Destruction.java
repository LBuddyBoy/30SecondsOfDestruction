package me.lbuddyboy.destruction;

import lombok.Getter;
import me.lbuddyboy.destruction.commands.DestructionCommand;
import me.lbuddyboy.destruction.commands.InvincibleCommand;
import me.lbuddyboy.destruction.frames.FrameManager;
import me.lbuddyboy.destruction.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Destruction extends JavaPlugin {

	@Getter private static Destruction instance;
	@Getter private FrameManager frameManager;

	@Override
	public void onEnable() {
		instance = this;
		registerCommand();
		registerListeners();
		registerManagers();

	}

	public void registerManagers() {
		frameManager = new FrameManager(this);
	}

	public void registerCommand() {
		getCommand("destruction").setExecutor(new DestructionCommand());
		getCommand("invincible").setExecutor(new InvincibleCommand());
	}

	public void registerListeners() {
		Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(), this);
		Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
		Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
		Bukkit.getPluginManager().registerEvents(new ProjectileListener(), this);
		Bukkit.getPluginManager().registerEvents(new TNTExplosionListener(), this);
	}

}
