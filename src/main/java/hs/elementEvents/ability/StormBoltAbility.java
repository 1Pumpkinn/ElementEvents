package hs.elementEvents.ability;

import hs.elementSMPRefined.API.ability.BaseAbility;
import hs.elementSMPRefined.API.element.ElementContext;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class StormBoltAbility extends BaseAbility {
    public StormBoltAbility(JavaPlugin plugin) {
        super("elementevents_storm_bolt", 35, 8, 1);
    }

    @Override
    public boolean execute(ElementContext context) {
        Player player = context.getPlayer();
        Entity targetEntity = player.getTargetEntity(24);
        if (!(targetEntity instanceof LivingEntity target) || target.equals(player)) {
            player.sendMessage(ChatColor.RED + "You must be looking at a nearby target.");
            return false;
        }
        if (target instanceof Player other
                && context.getTrustManager().isTrusted(player.getUniqueId(), other.getUniqueId())) {
            player.sendMessage(ChatColor.RED + "You cannot strike a trusted player.");
            return false;
        }

        Location targetLocation = target.getLocation();
        target.getWorld().strikeLightningEffect(targetLocation);
        target.damage(8.0, player);
        target.setFireTicks(40);
        return true;
    }

    @Override
    public String getName() {
        return ChatColor.AQUA + "Storm Bolt";
    }

    @Override
    public String getDescription() {
        return ChatColor.GRAY + "Call lightning on the nearby entity you are looking at.";
    }
}
