package net.saturn.elementEvents;

import hs.elementSMPRefined.ElementSMPRefined;
import net.pumpkinn.elementevents.addon.EventsAddon;
import org.bukkit.plugin.java.JavaPlugin;

public final class ElementEventsPlugin extends JavaPlugin {

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
        core.getAddonManager().register(new EventsAddon(this, core));

        getLogger().info("ElementEvents enabled, hooked into ElementSMPRefined.");
    }

    public ElementSMPRefined getCore() {
        return core;
    }
}