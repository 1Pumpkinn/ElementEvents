package net.rose.elementEvents.addon;

import net.rose.elementEvents.ElementEvents;
import rose.elementSMPRefined.API.ElementApi;
import rose.elementSMPRefined.API.addon.ElementAddon;

/**
 * Entry point registered with ElementSMPRefined's AddonManager. Everything
 * ElementEvents adds - custom elements, altar listeners, custom dimensions -
 * gets wired up from {@link #register}.
 */
public final class EventsAddon implements ElementAddon {
    private final ElementEvents plugin;

    public EventsAddon(ElementEvents plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getName() {
        return "ElementEvents";
    }

    @Override
    public void register(ElementApi api) {
        // One-time / event elements go here, e.g.:
        // api.registerElement(new StormElement(plugin));

        // Altar listeners (structure detection, collection interactions), e.g.:
        // api.registerListener("altar-listener", new AltarListener(plugin, api));

        // Custom event dimension, once you've generated/loaded the world, e.g.:
        // api.registerDimension(
        //         NamespacedKey.fromString("elementevents:event_realm"),
        //         Bukkit.getWorld("event_realm"));
    }
}