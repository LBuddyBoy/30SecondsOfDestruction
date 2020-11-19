package me.lbuddyboy.destruction.listener;

import me.lbuddyboy.destruction.Destruction;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class DeathListener implements Listener {

	@EventHandler
	public void onDeath(EntityDeathEvent event) {
		if (event.getEntity() instanceof Silverfish) {
			Silverfish silverfish = (Silverfish) event.getEntity();
			if (Destruction.getInstance().getFrameManager().silverList.contains(silverfish)) {

				event.getDrops().clear();
				event.setDroppedExp(0);

			}
		}
		if (event.getEntity() instanceof Ghast) {
			Ghast ghast = (Ghast) event.getEntity();
			if (Destruction.getInstance().getFrameManager().ghastList.contains(ghast)) {

				event.getDrops().clear();
				event.setDroppedExp(0);

			}
		}

		if (event.getEntity() instanceof Spider) {
			Spider spider = (Spider) event.getEntity();
			if (Destruction.getInstance().getFrameManager().spiderList.contains(spider)) {
				event.getDrops().clear();
				event.setDroppedExp(0);
			}
		}

		if (event.getEntity() instanceof Guardian) {
			Guardian guardian = (Guardian) event.getEntity();
			if (Destruction.getInstance().getFrameManager().guardianList.contains(guardian)) {

				event.getDrops().clear();
				event.setDroppedExp(0);

			}
		}

		if (event.getEntity() instanceof Bat) {
			Bat bat = (Bat) event.getEntity();
			if (Destruction.getInstance().getFrameManager().batList.contains(bat)) {

				event.getDrops().clear();
				event.setDroppedExp(0);

			}
		}

		if (event.getEntity() instanceof Chicken) {
			Chicken chicken = (Chicken) event.getEntity();
			if (Destruction.getInstance().getFrameManager().chickenList.contains(chicken)) {

				event.getDrops().clear();
				event.setDroppedExp(0);

			}
		}

		if (event.getEntity() instanceof Blaze) {
			Blaze blaze = (Blaze) event.getEntity();
			if (Destruction.getInstance().getFrameManager().blazeList.contains(blaze)) {

				event.getDrops().clear();
				event.setDroppedExp(0);

			}
		}

		if (event.getEntity() instanceof Zombie) {
			Zombie zombie = (Zombie) event.getEntity();
			if (Destruction.getInstance().getFrameManager().zombieList.contains(zombie)) {

				event.getDrops().clear();
				event.setDroppedExp(0);

			}
		}

		if (event.getEntity() instanceof Giant) {
			Giant giant = (Giant) event.getEntity();
			if (Destruction.getInstance().getFrameManager().giantList.contains(giant)) {

				event.getDrops().clear();
				event.setDroppedExp(0);

			}
		}
		if (event.getEntity() instanceof Wither) {
			Wither wither = (Wither) event.getEntity();
			if (Destruction.getInstance().getFrameManager().witherList.contains(wither)) {

				event.getDrops().clear();
				event.setDroppedExp(0);

			}
		}
	}
}
