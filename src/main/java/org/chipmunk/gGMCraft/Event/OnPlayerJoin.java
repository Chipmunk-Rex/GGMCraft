package org.chipmunk.gGMCraft.Event;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.chipmunk.gGMCraft.GGMCraft;


public class OnPlayerJoin extends GGMCraftLister {
    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        TextComponent component = Component.text(String.format("%s님이 ", player.getName()))
                .color(TextColor.color(1f,0.5f,0.5f))
                        .append(GGMCraft.severName)
                .append(Component.text(" 에 입장하였습니다"));
        event.joinMessage(component);
    }
}
