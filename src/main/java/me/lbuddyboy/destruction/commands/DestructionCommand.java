package me.lbuddyboy.destruction.commands;

import me.lbuddyboy.destruction.Destruction;
import me.lbuddyboy.destruction.util.chatUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DestructionCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Player use only!");
			return true;
		}

		if (args.length < 1) {
			sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-1 &7(Spawns 15 invis withers and spawns nukes throughout the 30 second time frame.)"));
			sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-2 &7(Spawns 150 silverfish & 15 ghast that will keep infecting and causing havoc amongst you.)"));
			sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-3 &7(Spawns Giants & Zombies & Baby zombies that shoot fire balls and occasional tnt.)"));
			sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-4 &7(Spawns Blazes that shoot tnt.)"));
			sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-5 &7(Spawns spiders that shoot cobwebs that spawn tnt 35 blocks above the cobwebs location.)"));
			sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-6 &7(Spawns a bunch of angry birds that drop tnt from the skies.)"));
			sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-7 &7(Spawns a bunch of flying horses that drop tnt from the sky.)"));
			sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-8 &7(Spawns a bunch of flying guardians firing fire balls and also confusing you!)"));
			sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-9 &7(Spawns a tnt pooping enderdragon!)"));
			sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-10 &7(Spawns frames 9-4 all at once!)"));
			return true;
		}

		Player player = (Player) sender;
		Player target = Bukkit.getPlayer(args[0]);

		if (target == null) {
			player.sendMessage(chatUtil.chat("&cCould not find the specified player."));
			return true;
		}

		switch (args[1]) {
			case "frame-10":
				Destruction.getInstance().getFrameManager().activateFinalFrame(target);
				break;
			case "frame-9":
				Destruction.getInstance().getFrameManager().activateFrame("9", target, true);
				break;
			case "frame-8":
				Destruction.getInstance().getFrameManager().activateFrame("8", target, true);
				break;
			case "frame-7":
				Destruction.getInstance().getFrameManager().activateFrame("7", target, true);
				break;
			case "frame-6":
				Destruction.getInstance().getFrameManager().activateFrame("6", target, true);
				break;
			case "frame-5":
				Destruction.getInstance().getFrameManager().activateFrame("5", target, true);
				break;
			case "frame-4":
				Destruction.getInstance().getFrameManager().activateFrame("4", target, true);
				break;
			case "frame-3":
				Destruction.getInstance().getFrameManager().activateFrame("3", target, true);
				break;
			case "frame-2":
				Destruction.getInstance().getFrameManager().activateFrame("2", target, true);
				break;
			case "frame-1":
				Destruction.getInstance().getFrameManager().activateFrame("1", target, true);
				break;
			default:
				sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-1 &7(Spawns 15 invis withers and spawns nukes throughout the 30 second time frame.)"));
				sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-2 &7(Spawns 150 silverfish & 15 ghast that will keep infecting and causing havoc amongst you.)"));
				sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-3 &7(Spawns Giants & Zombies & Baby zombies that shoot fire balls and occasional tnt.)"));
				sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-4 &7(Spawns Blazes that shoot tnt.)"));
				sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-5 &7(Spawns spiders that shoot cobwebs that spawn tnt 35 blocks above the cobwebs location.)"));
				sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-6 &7(Spawns a bunch of angry birds that drop tnt from the skies.)"));
				sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-7 &7(Spawns a bunch of flying horses that drop tnt from the sky.)"));
				sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-8 &7(Spawns a bunch of flying guardians firing fire balls and also confusing you!)"));
				sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-9 &7(Spawns a tnt pooping enderdragon!)"));
				sender.sendMessage(chatUtil.chat("&c/destruction <player> frame-10 &7(Spawns frames 9-4 all at once!)"));
				break;
		}
		return false;
	}


}
