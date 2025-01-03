package org.chipmunk.gGMCraft.Event;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.chipmunk.gGMCraft.GGMCraft;
import org.chipmunk.gGMCraft.PLayerManager;


public class OnPlayerJoin extends GGMCraftLister {
    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        Component titleText = GGMCraft.severName.append(Component.text("에 오신걸 환영합니다"));
        Title title = Title.title(titleText, Component.text(""));
        player.showTitle(title);

        TextComponent component = Component.text(String.format("%s님이 ", player.getName()))
                .color(TextColor.color(0.5f, 0.5f, 0.5f))
                .append(GGMCraft.severName)
                .append(Component.text("에 입장하였습니다"));
        event.joinMessage(component);

        GGMCraft.Debug("wdadawdaw");
        PLayerManager.Instance.tryLoadPlayerData(player);
    }
}
