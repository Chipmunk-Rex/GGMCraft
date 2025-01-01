package org.chipmunk.gGMCraft.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.chipmunk.gGMCraft.Inventory.MenuInventory;

public class OpenMenu extends GGMCraftLister {
    @EventHandler
    public void SwapHand(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        if (player.isSneaking()) {
            player.openInventory(MenuInventory.GetMenuInventory());
            player.sendMessage("메뉴를 열었습니다");

            event.setCancelled(true);
        }
    }
}
