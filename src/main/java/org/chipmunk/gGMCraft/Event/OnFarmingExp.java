package org.chipmunk.gGMCraft.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.chipmunk.gGMCraft.ExpSystem.ExpManager;
import org.chipmunk.gGMCraft.ExpSystem.ExpType;

public class OnFarmingExp extends GGMCraftLister {
    @EventHandler
    public void OnHarvest(PlayerHarvestBlockEvent event) {
        Player player = event.getPlayer();
        ExpManager.AddExp(player, ExpType.Farming, 10);
    }
}
