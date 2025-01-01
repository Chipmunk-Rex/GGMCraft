package org.chipmunk.gGMCraft;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.chipmunk.gGMCraft.Event.ClickMenu;
import org.chipmunk.gGMCraft.Event.OpenMenu;
import org.chipmunk.gGMCraft.Scoreboard.DeafaultScoreboard;

import java.io.Console;

public final class GGMCraft extends JavaPlugin {
    public static TextComponent severName = Component.text("G", TextColor.color(1))
            .append(Component.text("G", TextColor.color(1)))
                    .append(Component.text("M", TextColor.color(1)));

    @Override
    public void onEnable() {
        // Plugin startup logic

        getLogger().info("GGMCraft : Enable");
//        getServer().getPluginManager().registerEvents(new OpenMenu(), this);
        EventManager.RegisterEvent(getServer().getPluginManager(), this);
        DeafaultScoreboard.SetDefaultScoreboard();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("GGMCraft : Disable");
    }
}
