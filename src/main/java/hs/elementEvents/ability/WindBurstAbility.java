package hs.elementEvents.ability;

import hs.elementSMPRefined.API.ability.BaseAbility;
import hs.elementSMPRefined.API.element.ElementContext;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public final class WindBurstAbility extends BaseAbility {
    public WindBurstAbility(JavaPlugin plugin) {
        super("elementevents_wind_burst", 45, 12, 2);
    }

    @Override
    public boolean execute(ElementContext context) {
        Player player = context.getPlayer();
        Vector origin = player.getLocation().toVector();

        for (LivingEntity entity : player.getLocation().getNearbyLivingEntities(6.0)) {
            if (entity.equals(player)) continue;
            if (entity instanceof Player other
                    && context.getTrustManager().isTrusted(player.getUniqueId(), other.getUniqueId())) continue;

            Vector direction = entity.getLocation().toVector().subtract(origin);
            if (direction.lengthSquared() < 0.001) {
                direction = new Vector(0, 1, 0);
            } else {
                direction.normalize();
            }
            entity.setVelocity(entity.getVelocity().add(direction.multiply(1.4).setY(0.8)));
        }

        player.getWorld().playSound(player.getLocation(), "entity.wind_charge.wind_burst", 1.0f, 1.0f);
        return true;
    }

    @Override
    public String getName() {
        return ChatColor.WHITE + "Wind Burst";
    }

    @Override
    public String getDescription() {
        return ChatColor.GRAY + "Blast nearby enemies away in a rush of wind.";
    }
}
