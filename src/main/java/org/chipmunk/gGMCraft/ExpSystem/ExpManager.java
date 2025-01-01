package org.chipmunk.gGMCraft.ExpSystem;

import org.bukkit.entity.Player;

import java.util.Dictionary;
import java.util.HashMap;

public class ExpManager {
    public static HashMap<Player, PlayerExpData> playerExpDatas = new HashMap<Player, PlayerExpData>();

    public static void AddExp(Player player, ExpType expType, int amount) {
        GetOrCreateData(player).AddValue(expType, amount);
        player.sendMessage(String.valueOf(playerExpDatas.get(player).expMap.get(expType)));
    }

    public static PlayerExpData GetOrCreateData(Player player) {
        if(playerExpDatas.containsKey(player))
            return playerExpDatas.get(player);
        PlayerExpData expData = new PlayerExpData(player);
            playerExpDatas.put(player, expData);
        return expData;
    }
}
