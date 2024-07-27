package me.streakstudios.flyCraft.commands;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.entity.Player;
import java.util.HashSet;
import java.util.UUID;

public class FlyListener implements Listener {

    public static HashSet<UUID> noFallDamagePlayers = new HashSet<>();

    @EventHandler
    public void onFallDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                if (noFallDamagePlayers.contains(player.getUniqueId())) {
                    event.setCancelled(true);
                    noFallDamagePlayers.remove(player.getUniqueId());
                }
            }
        }
    }
}
