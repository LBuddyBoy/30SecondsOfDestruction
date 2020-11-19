package me.lbuddyboy.destruction.listener;

import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class TNTExplosionListener implements Listener {

	@EventHandler
	public void onExplode(ExplosionPrimeEvent event) {

		if (event.getEntity() instanceof TNTPrimed) {

			event.setFire(true);
			event.setRadius(6);

		}

	}

}
