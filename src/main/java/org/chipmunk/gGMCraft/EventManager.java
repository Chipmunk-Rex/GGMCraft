package org.chipmunk.gGMCraft;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.chipmunk.gGMCraft.Event.*;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    public static void registerEvent(PluginManager pluginManager, Plugin plugin) {
        List<Listener> listeners = new ArrayList<>();
        listeners.add(new ClickMenu());
        listeners.add(new OnFarmingExp());
        listeners.add(new OnPlayerJoin());
        listeners.add(new OpenMenu());

        for (Listener listener : listeners) {
            pluginManager.registerEvents(listener, plugin);
        }
    }
}
