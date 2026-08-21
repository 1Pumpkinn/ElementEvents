package net.pumpkinn.elementevents.addon;

import hs.elementSMPRefined.API.addon.ElementAddon;
import hs.elementSMPRefined.ElementSMPRefined;
import net.pumpkinn.elementevents.ElementEventsPlugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Entry point registered with ElementSMPRefined's AddonManager. Everything
 * ElementEvents adds - custom elements, altar listeners, custom dimensions -
 * gets wired up from {@link #register}.
 */
public final class EventsAddon implements ElementAddon {
    private final ElementEventsPlugin plugin;
    private final ElementSMPRefined core;

    public EventsAddon(ElementEventsPlugin plugin, ElementSMPRefined core) {
        this.plugin = plugin;
        this.core = core;
    }

    @Override
    public String getName() {
        return "ElementEvents";
    }

    @Override
    public void register(ElementSMPRefined plugin) {
        var addonManager = plugin.getAddonManager();

        // One-time / event elements go here, e.g.:
        // addonManager.registerElement(new StormElement(this.plugin));

        // Altar listeners (structure detection, collection interactions), e.g.:
        // addonManager.registerListener("altar-listener", new AltarListener(this.plugin, core));

        // Custom event dimension, once you've generated/loaded the world, e.g.:
        // addonManager.registerDimension(
        //         NamespacedKey.fromString("elementevents:event_realm"),
        //         Bukkit.getWorld("event_realm"));
    }
}