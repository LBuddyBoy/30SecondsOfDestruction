package me.lbuddyboy.destruction.listener;

import me.lbuddyboy.destruction.Destruction;
import me.lbuddyboy.destruction.commands.InvincibleCommand;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class DamageListener implements Listener {

	public Map<Player, Location> locationMap = new HashMap<>();

	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player) {
			Player damaged = (Player) event.getEntity();
			if (InvincibleCommand.invicible.contains(damaged)) {
				if (damaged.getHealth() < 5) {
					damaged.setHealth(damaged.getHealth() + 3.5);
				}
			}
		}
	}

	@EventHandler
	public void onPlayerDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player damaged = (Player) event.getEntity();
			if (InvincibleCommand.invicible.contains(damaged)) {
				if (damaged.getHealth() < 3) {
					damaged.setHealth(damaged.getHealth() + 1.5);
				}
			}
		}
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		locationMap.put(event.getEntity(), event.getEntity().getLocation());
	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent event) {
		if (!locationMap.containsKey(event.getPlayer())) {
			System.out.println("Location could not be saved due to dying while the server was down.");
			return;
		}
		Location location = locationMap.get(event.getPlayer());
		new BukkitRunnable() {
			@Override
			public void run() {
				event.getPlayer().teleport(location);
				locationMap.remove(event.getPlayer());
			}
		}.runTaskLater(Destruction.getInstance(), 2L);
	}

	@EventHandler
	public void onSilverFishDamaged(EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof TNTPrimed) {
			if (event.getEntity() instanceof Giant) {
				Giant giant = (Giant) event.getEntity();
				if (Destruction.getInstance().getFrameManager().giantList.contains(giant)) {
					event.setCancelled(true);
				}
			}
			if (event.getEntity() instanceof Guardian) {
				Guardian guardian = (Guardian) event.getEntity();
				if (Destruction.getInstance().getFrameManager().guardianList.contains(guardian)) {
					event.setCancelled(true);
				}
			}
			if (event.getEntity() instanceof Zombie) {
				Zombie zombie = (Zombie) event.getEntity();
				if (Destruction.getInstance().getFrameManager().zombieList.contains(zombie)) {
					event.setCancelled(true);
				}
			}
			if (event.getEntity() instanceof Spider) {
				Spider spider = (Spider) event.getEntity();
				if (Destruction.getInstance().getFrameManager().spiderList.contains(spider)) {
					event.setCancelled(true);
				}
			}
			if (event.getEntity() instanceof Bat) {
				Bat bat = (Bat) event.getEntity();
				if (Destruction.getInstance().getFrameManager().batList.contains(bat)) {
					event.setCancelled(true);
				}
			}
			if (event.getEntity() instanceof Bat) {
				Bat bat = (Bat) event.getEntity();
				if (Destruction.getInstance().getFrameManager().batList2.contains(bat)) {
					event.setCancelled(true);
				}
			}
			if (event.getEntity() instanceof Horse) {
				Horse horse = (Horse) event.getEntity();
				if (Destruction.getInstance().getFrameManager().horseList.contains(horse)) {
					event.setCancelled(true);
				}
			}
			if (event.getEntity() instanceof Chicken) {
				Chicken chicken = (Chicken) event.getEntity();
				if (Destruction.getInstance().getFrameManager().chickenList.contains(chicken)) {
					event.setCancelled(true);
				}
			}
			if (event.getEntity() instanceof Silverfish) {
				Silverfish silverfish = (Silverfish) event.getEntity();
				if (Destruction.getInstance().getFrameManager().silverList.contains(silverfish)) {
					event.setCancelled(true);
				}
			}
			if (event.getEntity() instanceof Ghast) {
				Ghast ghast = (Ghast) event.getEntity();
				if (Destruction.getInstance().getFrameManager().ghastList.contains(ghast)) {
					event.setCancelled(true);
				}
			}
		}
		if (event.getDamager() instanceof Fireball) {
			if (event.getEntity() instanceof Silverfish) {
				Silverfish silverfish = (Silverfish) event.getEntity();
				if (Destruction.getInstance().getFrameManager().silverList.contains(silverfish)) {
					event.setCancelled(true);
				}
			}
		}

		if (event.getDamager() instanceof Fireball) {
			if (event.getEntity() instanceof Guardian) {
				Guardian guardian = (Guardian) event.getEntity();
				if (Destruction.getInstance().getFrameManager().guardianList.contains(guardian)) {
					event.setCancelled(true);
				}
			}
			if (event.getEntity() instanceof Horse) {
				Horse horse = (Horse) event.getEntity();
				if (Destruction.getInstance().getFrameManager().horseList.contains(horse)) {
					event.setCancelled(true);
				}
			}
			if (event.getEntity() instanceof Bat) {
				Bat bat = (Bat) event.getEntity();
				if (Destruction.getInstance().getFrameManager().batList.contains(bat)) {
					event.setCancelled(true);
				}
			}
			if (event.getEntity() instanceof Bat) {
				Bat bat = (Bat) event.getEntity();
				if (Destruction.getInstance().getFrameManager().batList2.contains(bat)) {
					event.setCancelled(true);
				}
			}
			if (event.getEntity() instanceof Zombie) {
				Zombie zombie = (Zombie) event.getEntity();
				if (Destruction.getInstance().getFrameManager().zombieList.contains(zombie)) {
					event.setCancelled(true);
				}
			}
			if (((Fireball) event.getDamager()).getShooter() instanceof Blaze) {
				if (event.getEntity() instanceof Blaze) {
					Blaze blaze = (Blaze) event.getEntity();
					if (Destruction.getInstance().getFrameManager().blazeList.contains(blaze)) {
						event.setCancelled(true);
					}
				}
			}
			if (event.getEntity() instanceof Giant) {
				Giant giant = (Giant) event.getEntity();
				if (Destruction.getInstance().getFrameManager().giantList.contains(giant)) {
					event.setCancelled(true);
				}
			}
		}

		if (event.getDamager() instanceof TNTPrimed) {
			if (event.getEntity() instanceof Blaze) {
				Blaze blaze = (Blaze) event.getEntity();
				if (Destruction.getInstance().getFrameManager().blazeList.contains(blaze)) {
					event.setCancelled(true);
				}
			}
			if (event.getEntity() instanceof EnderDragon) {
				EnderDragon enderDragon = (EnderDragon) event.getEntity();
				if (Destruction.getInstance().getFrameManager().enderDragonList.contains(enderDragon)) {
					event.setCancelled(true);
				}
			}
			if (event.getEntity() instanceof Wither) {
				Wither wither = (Wither) event.getEntity();
				if (Destruction.getInstance().getFrameManager().witherList.contains(wither)) {
					event.setCancelled(true);
				}
			}
		}
	}

	@EventHandler
	public void onSilverFishDamageByFire(EntityDamageEvent event) {
		if (event.getEntity() instanceof Silverfish) {
			if (event.getCause() == EntityDamageEvent.DamageCause.FIRE
					|| event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
				event.setCancelled(true);
			}
		}
		if (event.getEntity() instanceof Spider) {
			if (event.getCause() == EntityDamageEvent.DamageCause.FIRE
					|| event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
				event.setCancelled(true);
			}
		}
		if (event.getEntity() instanceof Zombie) {
			if (event.getCause() == EntityDamageEvent.DamageCause.FIRE
					|| event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
				event.setCancelled(true);
			}
		}
		if (event.getEntity() instanceof Chicken) {
			if (event.getCause() == EntityDamageEvent.DamageCause.FIRE
					|| event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
				event.setCancelled(true);
			}
		}
		if (event.getEntity() instanceof Horse) {
			if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
				Horse horse = (Horse) event.getEntity();
				if (Destruction.getInstance().getFrameManager().horseList.contains(horse)) {
					event.setCancelled(true);
				}
			}
		}
	}

	@EventHandler
	public void onSilverFishHit(EntityDamageByEntityEvent event) {

		if (event.getDamager() instanceof Spider) {
			if (event.getEntity() instanceof Player) {
				Spider spider = (Spider) event.getDamager();
				Player damaged = (Player) event.getEntity();

				if (Destruction.getInstance().getFrameManager().spiderList.contains(spider)) {
					damaged.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20 * 5, 1, true));
					damaged.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 5, 1, true));

				}
			}
		}

		if (event.getDamager() instanceof Silverfish) {
			if (event.getEntity() instanceof Player) {
				Silverfish silverfish = (Silverfish) event.getDamager();
				Player damaged = (Player) event.getEntity();

				if (Destruction.getInstance().getFrameManager().silverList.contains(silverfish)) {
					damaged.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20 * 5, 1, true));
					damaged.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 5, 1, true));
					damaged.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 5, 1, true));
					damaged.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 20 * 5, 1, true));
				}

			}
		}

	}

}
