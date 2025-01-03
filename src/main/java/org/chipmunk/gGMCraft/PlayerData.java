package org.chipmunk.gGMCraft;

import org.bukkit.entity.Player;
import org.chipmunk.gGMCraft.ExpSystem.PlayerExpData;

import java.util.UUID;

public class PlayerData {
    UUID uuid;
    PlayerExpData expData;
    public PlayerData(Player player) {
        uuid = player.getUniqueId();
        expData = new PlayerExpData(player);
    }
}
