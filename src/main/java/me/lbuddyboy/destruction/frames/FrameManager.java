package me.lbuddyboy.destruction.frames;

import lombok.Getter;
import me.lbuddyboy.destruction.Destruction;
import me.lbuddyboy.destruction.util.chatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FrameManager {

	@Getter
	public List<Wither> witherList;
	@Getter
	public List<TNTPrimed> tntPrimedList;
	@Getter
	public List<Silverfish> silverList;
	@Getter
	public List<Ghast> ghastList;
	@Getter
	public List<Giant> giantList;
	@Getter
	public List<Blaze> blazeList;
	@Getter
	public List<Spider> spiderList;
	@Getter
	public List<Zombie> zombieList;
	@Getter
	public List<Chicken> chickenList;
	@Getter
	public List<Zombie> babyzombieList;
	@Getter
	public List<Bat> batList;
	@Getter
	public List<Bat> batList2;
	@Getter
	public List<Guardian> guardianList;
	@Getter
	public List<Horse> horseList;
	@Getter
	public List<EnderDragon> enderDragonList;

	@Getter
	public List<Player> playerListGiants;
	@Getter
	public List<Player> playerListPlague;
	@Getter
	public List<Player> playerListBlaze;
	@Getter
	public List<Player> playerListSpider;
	@Getter
	public List<Player> playerListBabys;
	@Getter
	public List<Player> playerListGuardian;

	public ItemStack gianthelmet = new ItemStack(Material.DIAMOND_HELMET);
	public ItemStack giantchestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
	public ItemStack giantleggings = new ItemStack(Material.DIAMOND_LEGGINGS);
	public ItemStack giantboots = new ItemStack(Material.DIAMOND_BOOTS);

	public ItemStack zombiehelmet = new ItemStack(Material.CHAINMAIL_HELMET);
	public ItemStack zombiechestplate = new ItemStack(Material.IRON_CHESTPLATE);
	public ItemStack zombieleggings = new ItemStack(Material.GOLD_LEGGINGS);
	public ItemStack zombieboots = new ItemStack(Material.DIAMOND_BOOTS);

	private Destruction destruction;

	public FrameManager(Destruction destruction) {
		this.destruction = destruction;
		horseList = new ArrayList<>();
		batList = new ArrayList<>();
		batList2 = new ArrayList<>();
		silverList = new ArrayList<>();
		playerListGiants = new ArrayList<>();
		playerListPlague = new ArrayList<>();
		playerListBlaze = new ArrayList<>();
		witherList = new ArrayList<>();
		tntPrimedList = new ArrayList<>();
		ghastList = new ArrayList<>();
		giantList = new ArrayList<>();
		zombieList = new ArrayList<>();
		babyzombieList = new ArrayList<>();
		blazeList = new ArrayList<>();
		chickenList = new ArrayList<>();
		spiderList = new ArrayList<>();
		guardianList = new ArrayList<>();
		playerListSpider = new ArrayList<>();
		playerListBabys = new ArrayList<>();
		playerListGuardian = new ArrayList<>();
		enderDragonList = new ArrayList<>();
	}

	public void activateFinalFrame(Player player) {
		new BukkitRunnable(){
			@Override
			public void run() {
				Bukkit.broadcastMessage(chatUtil.chat("&cI am at a lost of words. What is even going on now?!?!"));
			}
		}.runTaskLater(destruction, 20 * 10);
		new BukkitRunnable(){
			@Override
			public void run() {
				Bukkit.broadcastMessage(chatUtil.chat("&cYou made it... How? What... I'm at a lost of words."));
			}
		}.runTaskLater(destruction, 20 * 40);
		activateFrame("9", player, false);
		activateFrame("8", player, false);
		activateFrame("7", player, false);
		activateFrame("6", player, false);
		activateFrame("5", player, false);
		activateFrame("4", player, false);

	}

	public void activateFrame(String frame, Player player, boolean broadcastMessage) {

		if (frame.equalsIgnoreCase("9")) {
			new BukkitRunnable() {
				@Override
				public void run() {
					if (broadcastMessage) {
						Bukkit.broadcastMessage(chatUtil.chat("&cNow, I know that does fly, but not tnt coming out from him?!?!"));
					}
					for (int i = 0; i < 4; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						EnderDragon dragon = (EnderDragon) player.getLocation().getWorld().spawnEntity(player.getLocation().add(-xrandom, yrandom + 3, -zrandom), EntityType.ENDER_DRAGON);
						enderDragonList.add(dragon);
					}

					BukkitScheduler scheduler = Destruction.getInstance().getServer().getScheduler();
					scheduler.scheduleSyncRepeatingTask(Destruction.getInstance(), () -> {
						if (enderDragonList.isEmpty())
							return;

						for (int i = 0; i < 4; i++) {
							int random = new Random().nextInt(50 + 1);
							enderDragonList.get(i).getWorld().playEffect(enderDragonList.get(i).getLocation(), Effect.VOID_FOG, 0);

							if (random < 24) {
								enderDragonList.get(i).getWorld().spawn(enderDragonList.get(i).getLocation(), TNTPrimed.class).setFuseTicks(30);
							}
						}
					}, 0L, 1L);
					new BukkitRunnable() {
						@Override
						public void run() {
							if (broadcastMessage) {
								Bukkit.broadcastMessage(chatUtil.chat("&cHow the heck did you just survive that?"));
							}
							for (int i = 0; i < 4; i++) {
								Location location = enderDragonList.get(i).getLocation();
								location.subtract(10000, 3000, 100000);
								enderDragonList.get(i).teleport(location);
							}
							enderDragonList.clear();

						}
					}.runTaskLater(Destruction.getInstance(), 20 * 40);

				}
			}.runTaskLater(Destruction.getInstance(), 20 * 10);
		}
		if (frame.equalsIgnoreCase("8")) {
			new BukkitRunnable() {
				@Override
				public void run() {
					if (broadcastMessage) {
						Bukkit.broadcastMessage(chatUtil.chat("&cI don't ever remember guardians knowing how to fly!"));
					}
					for (int i = 0; i < 35; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Guardian guardian = (Guardian) player.getLocation().getWorld().spawnEntity(player.getLocation().add(-xrandom, yrandom + 3, -zrandom), EntityType.GUARDIAN);
						Bat bat = (Bat) player.getLocation().getWorld().spawnEntity(player.getLocation().add(-xrandom, yrandom + 3, -zrandom), EntityType.BAT);
						guardianList.add(guardian);
						playerListGuardian.add(player);
						batList2.add(bat);
						batList2.get(i).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 3));
					}

					BukkitScheduler scheduler = Destruction.getInstance().getServer().getScheduler();
					scheduler.scheduleSyncRepeatingTask(Destruction.getInstance(), () -> {
						if (guardianList.isEmpty() || batList2.isEmpty())
							return;
						for (int i = 0; i < 35; i++) {
							guardianList.get(i).teleport(batList2.get(i).getLocation().add(0, 1, 0));
							int random = new Random().nextInt(50 + 1);
							guardianList.get(i).getWorld().playEffect(guardianList.get(i).getLocation(), Effect.WATERDRIP, 0);
							if (random < 2) {
								guardianList.get(i).setTarget(playerListGuardian.get(0));
								guardianList.get(i).launchProjectile(Fireball.class);
							}

						}
					}, 0L, 1L);

					new BukkitRunnable() {
						@Override
						public void run() {
							if (broadcastMessage) {
								Bukkit.broadcastMessage(chatUtil.chat("&cWell, I guess they got a little too scared of you."));
							}
							for (int i = 0; i < 35; i++) {
								guardianList.get(i).damage(100000);
								batList2.get(i).damage(100000);
							}
							guardianList.clear();
							playerListGuardian.clear();
							batList2.clear();

						}
					}.runTaskLater(Destruction.getInstance(), 20 * 40);

				}
			}.runTaskLater(Destruction.getInstance(), 20 * 10);
		}

		if (frame.equalsIgnoreCase("7")) {
			new BukkitRunnable() {
				@Override
				public void run() {
					if (broadcastMessage) {
						Bukkit.broadcastMessage(chatUtil.chat("&cWHAT IS THAT! Is that... a bunch of flying horses?!?!"));
					}
					for (int i = 0; i < 35; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Horse horse = (Horse) player.getLocation().getWorld().spawnEntity(player.getLocation().add(-xrandom, yrandom + 3, -zrandom), EntityType.HORSE);
						Bat bat = (Bat) player.getLocation().getWorld().spawnEntity(player.getLocation().add(-xrandom, yrandom + 3, -zrandom), EntityType.BAT);
						horseList.add(horse);
						batList.add(bat);
						batList.get(i).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 3));
					}

					BukkitScheduler scheduler = Destruction.getInstance().getServer().getScheduler();
					scheduler.scheduleSyncRepeatingTask(Destruction.getInstance(), () -> {
						if (horseList.isEmpty() || batList.isEmpty())
							return;
						for (int i = 0; i < 35; i++) {
							horseList.get(i).teleport(batList.get(i).getLocation());
							int random = new Random().nextInt(50 + 1);
							horseList.get(i).getWorld().playEffect(horseList.get(i).getLocation(), Effect.FIREWORKS_SPARK, 0);
							if (random < 2) {
								TNTPrimed tntPrimed = horseList.get(i).getWorld().spawn(horseList.get(i).getLocation(), TNTPrimed.class);
							}

						}
					}, 0L, 1L);

					new BukkitRunnable() {
						@Override
						public void run() {
							if (broadcastMessage) {
								Bukkit.broadcastMessage(chatUtil.chat("&cWoah... what the heck was that."));
							}
							for (int i = 0; i < 35; i++) {
								horseList.get(i).damage(100000);
								batList.get(i).damage(100000);
							}
							horseList.clear();
							batList.clear();

						}
					}.runTaskLater(Destruction.getInstance(), 20 * 40);

				}
			}.runTaskLater(Destruction.getInstance(), 20 * 10);
		}

		if (frame.equalsIgnoreCase("6")) {
			new BukkitRunnable() {
				@Override
				public void run() {
					if (broadcastMessage) {
						Bukkit.broadcastMessage(chatUtil.chat("&cSome little guys are heading for you they look dangerous!"));
					}
					for (int i = 0; i < 45; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Chicken chicken = (Chicken) player.getLocation().getWorld().spawnEntity(player.getLocation().add(-xrandom, yrandom + 15, -zrandom), EntityType.CHICKEN);
						chickenList.add(chicken);
					}
					BukkitScheduler scheduler = Destruction.getInstance().getServer().getScheduler();
					scheduler.scheduleSyncRepeatingTask(Destruction.getInstance(), () -> {
						if (chickenList.isEmpty())
							return;
						for (int i = 0; i < 45; i++) {
							int random = new Random().nextInt(50 + 1);
							int locrandom = new Random().nextInt(50 + 1);
							chickenList.get(i).getWorld().playEffect(chickenList.get(i).getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
							int xrandom = new Random().nextInt(3 + 1);
							int yrandom = new Random().nextInt(3 + 1);
							int zrandom = new Random().nextInt(3 + 1);
							Location location = chickenList.get(i).getLocation();
							if (locrandom == 2) {
								location.add(xrandom, 5, zrandom);
							}
							if (locrandom == 3) {
								location.subtract(xrandom, 2, zrandom);
							}
							chickenList.get(i).teleport(location);
							if (random < 2) {
								TNTPrimed tntPrimed = chickenList.get(i).getWorld().spawn(chickenList.get(i).getLocation(), TNTPrimed.class);
							}

						}
					}, 0L, 1L);
					new BukkitRunnable() {
						@Override
						public void run() {
							if (broadcastMessage) {
								Bukkit.broadcastMessage(chatUtil.chat("&cI guess they flew in to the gaze of the stars..."));
							}
							for (int i = 0; i < 45; i++) {
								chickenList.get(i).damage(100000);
							}
							chickenList.clear();
							playerListBabys.clear();

						}
					}.runTaskLater(Destruction.getInstance(), 20 * 40);
				}
			}.runTaskLater(Destruction.getInstance(), 20 * 10);
		}
		if (frame.equalsIgnoreCase("5")) {
			new BukkitRunnable() {
				@Override
				public void run() {
					if (broadcastMessage) {
						Bukkit.broadcastMessage(chatUtil.chat("&cA sticky situation is coming for your world get ready!"));
					}
					for (int i = 0; i < 20; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Spider spider = (Spider) player.getLocation().getWorld().spawnEntity(player.getLocation().add(xrandom, yrandom + 3, zrandom), EntityType.SPIDER);
						spiderList.add(spider);
						spiderList.get(i).setTarget(player);
					}
					for (int i = 0; i < 20; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Spider spider = (Spider) player.getLocation().getWorld().spawnEntity(player.getLocation().add(-xrandom, yrandom + 3, -zrandom), EntityType.SPIDER);
						spiderList.add(spider);
						spiderList.get(i).setTarget(player);
					}
					for (int i = 0; i < 20; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Spider spider = (Spider) player.getLocation().getWorld().spawnEntity(player.getLocation().add(-xrandom, yrandom + 3, zrandom), EntityType.SPIDER);
						spiderList.add(spider);
						spiderList.get(i).setTarget(player);
					}
					for (int i = 0; i < 20; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Spider spider = (Spider) player.getLocation().getWorld().spawnEntity(player.getLocation().add(xrandom, yrandom + 3, -zrandom), EntityType.SPIDER);
						spiderList.add(spider);
						spiderList.get(i).setTarget(player);
					}
					playerListSpider.add(player);
					new BukkitRunnable() {
						@Override
						public void run() {
							if (broadcastMessage) {
								Bukkit.broadcastMessage(chatUtil.chat("&cThey look as if they have peered off in to the sunset..."));
							}
							for (int i = 0; i < 80; i++) {
								spiderList.get(i).damage(100000);
							}
							playerListSpider.clear();
							spiderList.clear();
						}
					}.runTaskLater(Destruction.getInstance(), 20 * 40);
				}
			}.runTaskLater(Destruction.getInstance(), 20 * 10);
		}

		if (frame.equalsIgnoreCase("4")) {
			new BukkitRunnable() {
				@Override
				public void run() {
					if (broadcastMessage) {
						Bukkit.broadcastMessage(chatUtil.chat("&cIs it getting hot in here? Holy cow look!"));
					}
					for (int i = 0; i < 20; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Blaze blaze = (Blaze) player.getLocation().getWorld().spawnEntity(player.getLocation().add(xrandom, yrandom + 3, zrandom), EntityType.BLAZE);
						blazeList.add(blaze);
						blazeList.get(i).setTarget(player);
					}
					for (int i = 0; i < 20; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Blaze blaze = (Blaze) player.getLocation().getWorld().spawnEntity(player.getLocation().add(-xrandom, yrandom + 3, -zrandom), EntityType.BLAZE);
						blazeList.add(blaze);
						blazeList.get(i).setTarget(player);
					}
					for (int i = 0; i < 20; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Blaze blaze = (Blaze) player.getLocation().getWorld().spawnEntity(player.getLocation().add(-xrandom, yrandom + 3, zrandom), EntityType.BLAZE);
						blazeList.add(blaze);
						blazeList.get(i).setTarget(player);
					}
					for (int i = 0; i < 20; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Blaze blaze = (Blaze) player.getLocation().getWorld().spawnEntity(player.getLocation().add(xrandom, yrandom + 3, -zrandom), EntityType.BLAZE);
						blazeList.add(blaze);
						blazeList.get(i).setTarget(player);
					}
					playerListBlaze.add(player);
					new BukkitRunnable() {
						@Override
						public void run() {
							if (broadcastMessage) {
								Bukkit.broadcastMessage(chatUtil.chat("&cLooks like it's getting colder I think they're gone!"));
							}
							// 150 because of 150 silver fish
							for (int i = 0; i < 80; i++) {
								blazeList.get(i).damage(100000);
							}
							playerListBlaze.clear();
							blazeList.clear();
						}
					}.runTaskLater(Destruction.getInstance(), 20 * 40);
				}
			}.runTaskLater(Destruction.getInstance(), 20 * 10);
		}

		if (frame.equalsIgnoreCase("3")) {
			new BukkitRunnable() {
				@Override
				public void run() {
					if (broadcastMessage) {
						Bukkit.broadcastMessage(chatUtil.chat("&cIt seems the Giants & their minions have come from the heavens very angry!"));
					}
					for (int i = 0; i < 4; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Giant giant = (Giant) player.getLocation().getWorld().spawnEntity(player.getLocation().add(xrandom, yrandom + 9, zrandom), EntityType.GIANT);
						giantList.add(giant);
						giantList.get(i).getEquipment().setHelmet(gianthelmet);
						giantList.get(i).getEquipment().setChestplate(giantchestplate);
						giantList.get(i).getEquipment().setLeggings(giantleggings);
						giantList.get(i).getEquipment().setBoots(giantboots);
						giantList.get(i).setTarget(player);
					}
					for (int i = 0; i < 25; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Zombie zombie = (Zombie) player.getLocation().getWorld().spawnEntity(player.getLocation().add(xrandom, yrandom + 9, zrandom), EntityType.ZOMBIE);
						zombieList.add(zombie);
						zombieList.get(i).getEquipment().setHelmet(zombiehelmet);
						zombieList.get(i).getEquipment().setChestplate(zombiechestplate);
						zombieList.get(i).getEquipment().setLeggings(zombieleggings);
						zombieList.get(i).getEquipment().setBoots(zombieboots);
						zombieList.get(i).setCustomName(chatUtil.chat("&2Giant's Minions"));
						zombieList.get(i).setBaby(false);
						zombieList.get(i).setTarget(player);
					}
					for (int i = 0; i < 20; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Zombie zombie = (Zombie) player.getLocation().getWorld().spawnEntity(player.getLocation().add(-xrandom, yrandom + 9, zrandom), EntityType.ZOMBIE);
						zombieList.add(zombie);
						zombieList.get(i).getEquipment().setHelmet(zombiehelmet);
						zombieList.get(i).getEquipment().setChestplate(zombiechestplate);
						zombieList.get(i).getEquipment().setLeggings(zombieleggings);
						zombieList.get(i).getEquipment().setBoots(zombieboots);
						zombieList.get(i).setCustomName(chatUtil.chat("&2Giant's Minions"));
						zombieList.get(i).setBaby(false);
						zombieList.get(i).setTarget(player);
					}
					for (int i = 0; i < 15; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Zombie zombie = (Zombie) player.getLocation().getWorld().spawnEntity(player.getLocation().add(-xrandom, yrandom + 9, -zrandom), EntityType.ZOMBIE);
						zombieList.add(zombie);
						zombieList.get(i).getEquipment().setHelmet(zombiehelmet);
						zombieList.get(i).getEquipment().setChestplate(zombiechestplate);
						zombieList.get(i).getEquipment().setLeggings(zombieleggings);
						zombieList.get(i).getEquipment().setBoots(zombieboots);
						zombieList.get(i).setCustomName(chatUtil.chat("&2Giant's Minions"));
						zombieList.get(i).setBaby(false);
						zombieList.get(i).setTarget(player);
					}
					for (int i = 0; i < 15; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Zombie zombie = (Zombie) player.getLocation().getWorld().spawnEntity(player.getLocation().add(xrandom, yrandom + 9, -zrandom), EntityType.ZOMBIE);
						zombieList.add(zombie);
						zombieList.get(i).getEquipment().setHelmet(zombiehelmet);
						zombieList.get(i).getEquipment().setChestplate(zombiechestplate);
						zombieList.get(i).getEquipment().setLeggings(zombieleggings);
						zombieList.get(i).getEquipment().setBoots(zombieboots);
						zombieList.get(i).setCustomName(chatUtil.chat("&2Giant's Minions"));
						zombieList.get(i).setBaby(false);
						zombieList.get(i).setTarget(player);
					}

					playerListGiants.add(player);
					for (int i = 0; i < 5; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Zombie zombie = (Zombie) player.getLocation().getWorld().spawnEntity(player.getLocation().add(xrandom, yrandom + 9, zrandom), EntityType.ZOMBIE);
						babyzombieList.add(zombie);
						babyzombieList.get(i).getEquipment().setHelmet(zombiehelmet);
						babyzombieList.get(i).getEquipment().setChestplate(zombiechestplate);
						babyzombieList.get(i).getEquipment().setLeggings(zombieleggings);
						babyzombieList.get(i).getEquipment().setBoots(zombieboots);
						babyzombieList.get(i).setCustomName(chatUtil.chat("&aGiant's Baby Minions"));
						babyzombieList.get(i).setBaby(true);
						babyzombieList.get(i).setTarget(player);
					}
					for (int i = 0; i < 5; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Zombie zombie = (Zombie) player.getLocation().getWorld().spawnEntity(player.getLocation().add(-xrandom, yrandom + 9, -zrandom), EntityType.ZOMBIE);
						babyzombieList.add(zombie);
						babyzombieList.get(i).getEquipment().setHelmet(zombiehelmet);
						babyzombieList.get(i).getEquipment().setChestplate(zombiechestplate);
						babyzombieList.get(i).getEquipment().setLeggings(zombieleggings);
						babyzombieList.get(i).getEquipment().setBoots(zombieboots);
						babyzombieList.get(i).setCustomName(chatUtil.chat("&aGiant's Baby Minions"));
						babyzombieList.get(i).setBaby(true);
						babyzombieList.get(i).setTarget(player);
					}
					for (int i = 0; i < 5; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Zombie zombie = (Zombie) player.getLocation().getWorld().spawnEntity(player.getLocation().add(-xrandom, yrandom + 9, zrandom), EntityType.ZOMBIE);
						babyzombieList.add(zombie);
						babyzombieList.get(i).getEquipment().setHelmet(zombiehelmet);
						babyzombieList.get(i).getEquipment().setChestplate(zombiechestplate);
						babyzombieList.get(i).getEquipment().setLeggings(zombieleggings);
						babyzombieList.get(i).getEquipment().setBoots(zombieboots);
						babyzombieList.get(i).setCustomName(chatUtil.chat("&aGiant's Baby Minions"));
						babyzombieList.get(i).setBaby(true);
						babyzombieList.get(i).setTarget(player);
					}
					for (int i = 0; i < 10; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Zombie zombie = (Zombie) player.getLocation().getWorld().spawnEntity(player.getLocation().add(xrandom, yrandom + 9, -zrandom), EntityType.ZOMBIE);
						babyzombieList.add(zombie);
						babyzombieList.get(i).getEquipment().setHelmet(zombiehelmet);
						babyzombieList.get(i).getEquipment().setChestplate(zombiechestplate);
						babyzombieList.get(i).getEquipment().setLeggings(zombieleggings);
						babyzombieList.get(i).getEquipment().setBoots(zombieboots);
						babyzombieList.get(i).setCustomName(chatUtil.chat("&aGiant's Baby Minions"));
						babyzombieList.get(i).setBaby(true);
						babyzombieList.get(i).setTarget(player);
					}
					new BukkitRunnable() {
						@Override
						public void run() {
							if (broadcastMessage) {
								Bukkit.broadcastMessage(chatUtil.chat("&cThey seem to be calm for now..."));
							}
							// 150 because of 150 silver fish
							for (int i = 0; i < 4; i++) {
								giantList.get(i).damage(100000);
							}
							for (int i = 0; i < 75; i++) {
								zombieList.get(i).damage(100000);
							}
							for (int i = 0; i < 25; i++) {
								babyzombieList.get(i).damage(100000);
							}
							playerListGiants.clear();
							zombieList.clear();
							giantList.clear();
						}
					}.runTaskLater(Destruction.getInstance(), 20 * 40);
				}
			}.runTaskLater(Destruction.getInstance(), 20 * 10);
		}
		if (frame.equalsIgnoreCase("2")) {
			new BukkitRunnable() {
				@Override
				public void run() {
					if (broadcastMessage) {
						Bukkit.broadcastMessage(chatUtil.chat("&cA plague of hungry silverfish & furious ghasts has been summoned upon you!"));
					}
					for (int i = 0; i < 10; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Ghast ghast = (Ghast) player.getLocation().getWorld().spawnEntity(player.getLocation().add(xrandom, yrandom + 9, zrandom), EntityType.GHAST);
						ghastList.add(ghast);
					}
					for (int i = 0; i < 10; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Ghast ghast = (Ghast) player.getLocation().getWorld().spawnEntity(player.getLocation().add(-xrandom, yrandom + 9, zrandom), EntityType.GHAST);
						ghastList.add(ghast);
					}
					for (int i = 0; i < 10; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Ghast ghast = (Ghast) player.getLocation().getWorld().spawnEntity(player.getLocation().add(xrandom, yrandom + 9, -zrandom), EntityType.GHAST);
						ghastList.add(ghast);
					}
					for (int i = 0; i < 10; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Ghast ghast = (Ghast) player.getLocation().getWorld().spawnEntity(player.getLocation().add(-xrandom, yrandom + 9, -zrandom), EntityType.GHAST);
						ghastList.add(ghast);
					}
					for (int i = 0; i < 35; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Silverfish silverfish = (Silverfish) player.getLocation().getWorld().spawnEntity(player.getLocation().add(xrandom, yrandom, zrandom), EntityType.SILVERFISH);
						silverList.add(silverfish);
						silverList.get(i).setTarget(player);
					}
					for (int i = 0; i < 35; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Silverfish silverfish = (Silverfish) player.getLocation().getWorld().spawnEntity(player.getLocation().add(-xrandom, yrandom, zrandom), EntityType.SILVERFISH);
						silverList.add(silverfish);
						silverList.get(i).setTarget(player);
					}
					for (int i = 0; i < 35; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Silverfish silverfish = (Silverfish) player.getLocation().getWorld().spawnEntity(player.getLocation().add(xrandom, yrandom, -zrandom), EntityType.SILVERFISH);
						silverList.add(silverfish);
						silverList.get(i).setTarget(player);
					}
					for (int i = 0; i < 45; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Silverfish silverfish = (Silverfish) player.getLocation().getWorld().spawnEntity(player.getLocation().add(-xrandom, yrandom, -zrandom), EntityType.SILVERFISH);
						silverList.add(silverfish);
						silverList.get(i).setTarget(player);
					}
					playerListPlague.add(player);
					new BukkitRunnable() {
						@Override
						public void run() {
							if (broadcastMessage) {
								Bukkit.broadcastMessage(chatUtil.chat("&cThe plague seems to calm down..."));
							}
							// 150 because of 150 silver fish
							for (int i = 0; i < 150; i++) {
								silverList.get(i).damage(100000);
							}
							for (int i = 0; i < 40; i++) {
								ghastList.get(i).damage(100000);
							}
							ghastList.clear();
							silverList.clear();
							playerListPlague.clear();
						}
					}.runTaskLater(Destruction.getInstance(), 20 * 40);
				}
			}.runTaskLater(Destruction.getInstance(), 20 * 10);
			return;
		}

		if (frame.equalsIgnoreCase("1")) {
			new BukkitRunnable() {
				@Override
				public void run() {
					if (broadcastMessage) {
						Bukkit.broadcastMessage(chatUtil.chat("&cThe gods have became angry and your fate will be decided!"));
					}
					for (int i = 0; i < 2; i++) {
						int xrandom = new Random().nextInt(9 + 1);
						int yrandom = new Random().nextInt(9 + 1);
						int zrandom = new Random().nextInt(9 + 1);
						Wither wither = (Wither) player.getLocation().getWorld().spawnEntity(player.getLocation().add(xrandom, yrandom, zrandom), EntityType.WITHER);
						witherList.add(wither);
						witherList.get(i).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 3));
						witherList.get(i).setTarget(player);
					}

					for (int i = 0; i < 50; i++) {
						activateTntScatters(player);
						activateTntScatters(player);
						activateTntScatters(player);
						activateTntScatters(player);
					}

					new BukkitRunnable() {
						@Override
						public void run() {
							if (broadcastMessage) {
								Bukkit.broadcastMessage(chatUtil.chat("&c&oThe angry gods seem to become less and less angry..."));
							}
							// this is 4 because there is 4 withers
							for (int i = 0; i < 2; i++) {
								witherList.get(i).damage(100000);
							}
							// this is 55 because you add all of the other loop amounts using the activateTntScatters() Method.
							for (int i = 0; i < 70; i++) {
								tntPrimedList.get(i).remove();
							}
							tntPrimedList.clear();
							witherList.clear();
						}
					}.runTaskLater(Destruction.getInstance(), 20 * 40);
				}
			}.runTaskLater(Destruction.getInstance(), 20 * 10);
		}
	}

	private void activateTntScatters(Player player) {
		for (int i = 0; i < 1; i++) {
			int xrandom = new Random().nextInt(50 + 1);
			int zrandom = new Random().nextInt(50 + 1);
			TNTPrimed tntPrimed = player.getLocation().getWorld().spawn(player.getLocation().add(xrandom, 65, zrandom), TNTPrimed.class);
			tntPrimedList.add(tntPrimed);
			tntPrimedList.get(i).setMetadata("destructiveTNT", new FixedMetadataValue(Destruction.getInstance(), tntPrimedList.get(i)));
			tntPrimedList.get(i).setFuseTicks(80);
		}
		for (int i = 0; i < 1; i++) {
			int xrandom = new Random().nextInt(50 + 1);
			int zrandom = new Random().nextInt(50 + 1);
			TNTPrimed tntPrimed = player.getLocation().getWorld().spawn(player.getLocation().add(xrandom, 65, -zrandom), TNTPrimed.class);
			tntPrimedList.add(tntPrimed);
			tntPrimedList.get(i).setMetadata("destructiveTNT", new FixedMetadataValue(Destruction.getInstance(), tntPrimedList.get(i)));
			tntPrimedList.get(i).setFuseTicks(80);
		}
		for (int i = 0; i < 1; i++) {
			int xrandom = new Random().nextInt(50 + 1);
			int zrandom = new Random().nextInt(50 + 1);
			TNTPrimed tntPrimed = player.getLocation().getWorld().spawn(player.getLocation().add(-xrandom, 65, zrandom), TNTPrimed.class);
			tntPrimedList.add(tntPrimed);
			tntPrimedList.get(i).setMetadata("destructiveTNT", new FixedMetadataValue(Destruction.getInstance(), tntPrimedList.get(i)));
			tntPrimedList.get(i).setFuseTicks(80);
		}
		for (int i = 0; i < 1; i++) {
			int xrandom = new Random().nextInt(50 + 1);
			int zrandom = new Random().nextInt(50 + 1);
			TNTPrimed tntPrimed = player.getLocation().getWorld().spawn(player.getLocation().add(-xrandom, 65, -zrandom), TNTPrimed.class);
			tntPrimedList.add(tntPrimed);
			tntPrimedList.get(i).setMetadata("destructiveTNT", new FixedMetadataValue(Destruction.getInstance(), tntPrimedList.get(i)));
			tntPrimedList.get(i).setFuseTicks(80);
		}
	}

}
