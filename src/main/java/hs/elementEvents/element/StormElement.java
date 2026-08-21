package hs.elementEvents.element;

import hs.elementEvents.ability.StormBoltAbility;
import hs.elementEvents.ability.WindBurstAbility;
import hs.elementSMPRefined.ElementSMPRefined;
import hs.elementSMPRefined.API.element.BaseElement;
import hs.elementSMPRefined.API.element.ElementId;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public final class StormElement extends BaseElement {
    public StormElement(ElementSMPRefined plugin) {
        super(plugin, new StormBoltAbility(plugin), new WindBurstAbility(plugin));
    }

    @Override
    public ElementId getId() {
        return new ElementId("elementevents", "storm");
    }

    @Override
    public void applyUpsides(Player player, int upgradeLevel) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, PotionEffect.INFINITE_DURATION, 0, true, false));
    }

    @Override
    public void clearEffects(Player player) {
        super.clearEffects(player);
        player.removePotionEffect(PotionEffectType.SPEED);
    }

    @Override
    public String getDisplayName() {
        return ChatColor.AQUA + "Storm";
    }

    @Override
    public String getDescription() {
        return ChatColor.GRAY + "A fast-moving element that commands lightning and bursts of wind.";
    }

    @Override
    public List<String> getPassiveBenefits() {
        return List.of("Permanent Speed I");
    }
}
