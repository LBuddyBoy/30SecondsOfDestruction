package me.lbuddyboy.destruction.listener;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ProjectileListener implements Listener {

	@EventHandler
	public void onProjectileHit(ProjectileHitEvent event) {
		if (event.getEntity() instanceof WitherSkull) {
			event.getEntity().getWorld().playEffect(event.getEntity().getLocation(), Effect.EXPLOSION_HUGE, 0);
		}
		if (event.getEntity() instanceof Fireball) {
			event.getEntity().getWorld().playEffect(event.getEntity().getLocation(), Effect.EXPLOSION_HUGE, 0);
		}

		if (event.getEntity() instanceof Fireball) {
			if (event.getEntity().getShooter() instanceof Blaze) {
				event.getEntity().getWorld().playEffect(event.getEntity().getLocation(), Effect.EXPLOSION_HUGE, 0);
				TNTPrimed tntPrimed = event.getEntity().getWorld().spawn(event.getEntity().getLocation(), TNTPrimed.class);
				tntPrimed.setFuseTicks(1);
			}
		}
		if (event.getEntity() instanceof Snowball) {
			if (event.getEntity().getShooter() instanceof Spider) {
				event.getEntity().getWorld().playEffect(event.getEntity().getLocation(), Effect.EXPLOSION, 0);
				event.getEntity().getWorld().spawnFallingBlock(event.getEntity().getLocation(), Material.WEB, (byte) 0);
				event.getEntity().getWorld().spawn(event.getEntity().getLocation().add(0, 35, 0), TNTPrimed.class);
			}
		}
	}


}
