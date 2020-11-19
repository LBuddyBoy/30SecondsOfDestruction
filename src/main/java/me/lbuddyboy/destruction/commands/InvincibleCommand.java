package me.lbuddyboy.destruction.commands;

import me.lbuddyboy.destruction.util.chatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class InvincibleCommand implements CommandExecutor {

	public static List<Player> invicible = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(chatUtil.chat("&cPlayers only"));
			return true;
		}

		Player player = (Player) sender;

		if (args.length == 0) {
			if (invicible.contains(player)) {
				invicible.remove(player);
				System.out.println("" + sender.getName() + " has just disabled their invicible timer.");
				return true;
			} else {
				invicible.add(player);
				System.out.println("" + sender.getName() + " has just enabled their invicible timer.");
				return true;
			}
		}


		return false;
	}
}
