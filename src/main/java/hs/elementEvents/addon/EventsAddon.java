package hs.elementEvents.addon;

import hs.elementEvents.ElementEvents;
import hs.elementEvents.element.StormElement;
import hs.elementSMPRefined.API.ElementApi;
import hs.elementSMPRefined.API.addon.ElementAddon;
import hs.elementSMPRefined.ElementSMPRefined;

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
    public void register(ElementSMPRefined plugin) {
        ElementApi api = plugin.getElementApi();
        api.registerElement(new StormElement(plugin));

        // One-time / event elements go here, e.g.:
        // api.registerElement(new StormElement(plugin));

        // Altar listeners (structure detection, collection interactions), e.g.:
        // api.registerListener("altar-listener", new AltarListener(this.plugin, plugin));

        // Custom event dimension, once you've generated/loaded the world, e.g.:
        // addonManager.registerDimension(
        //         NamespacedKey.fromString("elementevents:event_realm"),
        //         Bukkit.getWorld("event_realm"));
    }
}