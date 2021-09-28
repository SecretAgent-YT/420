package me.secretagent.twenty.listeners;

import me.secretagent.twenty.FourTwentyPlugin;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class BlazeKilledListener implements Listener {

    private final FourTwentyPlugin plugin;

    public BlazeKilledListener(FourTwentyPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlazeKilled(EntityDeathEvent event) {
        if (event.getEntity().getType() == EntityType.BLAZE) {
            LivingEntity entity = event.getEntity();
            if (entity.getKiller() != null) { //Check if entity was killed by player
                Player player = entity.getKiller();
                plugin.addKill(player);
            }
        }
    }
}
