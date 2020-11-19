package me.lbuddyboy.destruction.listener;

import me.lbuddyboy.destruction.Destruction;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Random;

public class PlayerMoveListener implements Listener {

	@EventHandler
	public void onMovePlayerSpiders(PlayerMoveEvent event) {
		if (Destruction.getInstance().getFrameManager().playerListSpider.contains(event.getPlayer())) {
			for (Entity entity : event.getPlayer().getNearbyEntities(13, 8, 13)) {
				int random = new Random().nextInt(50);
				int random2 = new Random().nextInt(50);
				if (entity instanceof Spider) {
					if (random < 20) {
						Spider spider = (Spider) entity;
						Location location = spider.getLocation();
						location.setYaw(spider.getLocation().getYaw() + event.getPlayer().getLocation().getYaw());
						location.setPitch(spider.getLocation().getPitch() + event.getPlayer().getLocation().getPitch());
						spider.teleport(location);
						if (random2 < 25) {
							spider.launchProjectile(Snowball.class);
						}
					} else {
						return;
					}
				}
			}
		}
	}

	@EventHandler
	public void onMovePlayerZombies(PlayerMoveEvent event) {

		if (Destruction.getInstance().getFrameManager().playerListGiants.contains(event.getPlayer())) {
			for (Entity entity : event.getPlayer().getNearbyEntities(10, 10, 10)) {
				if (entity instanceof Zombie) {
					Zombie zombie = (Zombie) entity;
					zombie.getWorld().playEffect(zombie.getLocation(), Effect.STEP_SOUND, Material.DIRT);
					zombie.getWorld().playEffect(zombie.getLocation().add(1, 0, 0), Effect.STEP_SOUND, Material.DIRT);
//					zombie.getWorld().playEffect(zombie.getLocation().add(0, 0, 1), Effect.STEP_SOUND, Material.DIRT);
//					zombie.getWorld().playEffect(zombie.getLocation().add(-1, 0, 0), Effect.STEP_SOUND, Material.DIRT);
//					zombie.getWorld().playEffect(zombie.getLocation().add(1, 0, 1), Effect.STEP_SOUND, Material.DIRT);
//					zombie.getWorld().playEffect(zombie.getLocation().add(1, 0, -1), Effect.STEP_SOUND, Material.DIRT);
//					zombie.getWorld().playEffect(zombie.getLocation().add(-1, 0, -1), Effect.STEP_SOUND, Material.DIRT);
//					zombie.getWorld().playEffect(zombie.getLocation().add(-1, 0, 1), Effect.STEP_SOUND, Material.DIRT);
					//tntPrimed.setFuseTicks(3);
				}
				if (entity instanceof Giant) {
					Giant giant = (Giant) entity;
					giant.setTarget(event.getPlayer());
					giant.getWorld().playEffect(giant.getLocation(), Effect.STEP_SOUND, Material.DIRT);
					giant.getWorld().playEffect(giant.getLocation().add(1, 0, 0), Effect.STEP_SOUND, Material.DIRT);
//					giant.getWorld().playEffect(giant.getLocation().add(0, 0, 1), Effect.STEP_SOUND, Material.DIRT);
//					giant.getWorld().playEffect(giant.getLocation().add(-1, 0, 0), Effect.STEP_SOUND, Material.DIRT);
//					giant.getWorld().playEffect(giant.getLocation().add(1, 0, 1), Effect.STEP_SOUND, Material.DIRT);
//					giant.getWorld().playEffect(giant.getLocation().add(1, 0, -1), Effect.STEP_SOUND, Material.DIRT);
//					giant.getWorld().playEffect(giant.getLocation().add(-1, 0, -1), Effect.STEP_SOUND, Material.DIRT);
//					giant.getWorld().playEffect(giant.getLocation().add(-1, 0, 1), Effect.STEP_SOUND, Material.DIRT);
				}
			}

			for (Entity entity : event.getPlayer().getNearbyEntities(5, 5, 5)) {
				int random2 = new Random().nextInt(50);
				if (entity instanceof Zombie) {
					if (random2 < 8) {
						Zombie zombie = (Zombie) entity;
						zombie.launchProjectile(Fireball.class);
						//tntPrimed.setFuseTicks(3);
					}
				}
			}
		}
	}

//	@EventHandler
//	public void onMoveZombieJocky(PlayerMoveEvent event) {
//		if (Destruction.getInstance().getFrameManager().playerListBabys.contains(event.getPlayer())) {
//			int random = new Random().nextInt(31);
//			for (Entity entity : event.getPlayer().getNearbyEntities(20, 50, 20)) {
//				if (entity instanceof Chicken) {
//					Chicken chicken = (Chicken) entity;
//					chicken.getWorld().playEffect(chicken.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
//					if (random < 3) {
//						TNTPrimed tntPrimed = chicken.getWorld().spawn(chicken.getLocation(), TNTPrimed.class);
//						tntPrimed.setFuseTicks(2);
//						if (tntPrimed.isOnGround()) {
//							tntPrimed.setFuseTicks(0);
//						}
//					}
//				}
//			}
//		}
//	}

	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		if (Destruction.getInstance().getFrameManager().playerListPlague.contains(event.getPlayer())) {
			int random = new Random().nextInt(31);
			int randomwalk = new Random().nextInt(100);
			int randomwalklava = new Random().nextInt(100);
			for (Entity entity : event.getPlayer().getNearbyEntities(20, 20, 20)) {
				if (entity instanceof Silverfish) {
					Silverfish silverfish = (Silverfish) entity;
					silverfish.getWorld().playEffect(silverfish.getLocation(), Effect.HAPPY_VILLAGER, 0);
				}
			}
			for (Entity entitySilverFish : event.getPlayer().getNearbyEntities(2, 5, 2)) {
				if (entitySilverFish instanceof Silverfish) {
					if (randomwalklava < 8) {
						Destruction.getInstance().getFrameManager().silverList.get(random).getWorld().spawnFallingBlock(Destruction.getInstance().getFrameManager().silverList.get(random).getLocation(), Material.FIRE, (byte) 0);
					} else {
						return;
					}
					if (randomwalk < 8) {
						Destruction.getInstance().getFrameManager().silverList.get(random).getWorld().spawn(Destruction.getInstance().getFrameManager().silverList.get(random).getLocation(), TNTPrimed.class);
					} else {
						return;
					}
				}
			}
		}
	}
}
