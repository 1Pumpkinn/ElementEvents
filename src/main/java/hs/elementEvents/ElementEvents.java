package hs.elementEvents;

import hs.elementEvents.addon.EventsAddon;
import hs.elementSMPRefined.ElementSMPRefined;
import org.bukkit.plugin.java.JavaPlugin;

public final class ElementEvents extends JavaPlugin {

    private ElementSMPRefined core;

    @Override
    public void onEnable() {
        var corePlugin = getServer().getPluginManager().getPlugin("ElementSMPRefined");
        if (!(corePlugin instanceof ElementSMPRefined refined)) {
            getLogger().severe("ElementSMPRefined not found or failed to load - disabling ElementEvents.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        this.core = refined;
        core.getAddonManager().register(new EventsAddon(this));

        getLogger().info("ElementEvents enabled, hooked into ElementSMPRefined.");
    }

    public ElementSMPRefined getCore() {
        return core;
    }
}