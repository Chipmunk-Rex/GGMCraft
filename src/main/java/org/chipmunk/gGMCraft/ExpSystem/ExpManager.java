package org.chipmunk.gGMCraft.ExpSystem;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.chipmunk.gGMCraft.GGMCraft;

import java.io.File;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class ExpManager {
    public static HashMap<Player, PlayerExpData> playerExpDatas = new HashMap<Player, PlayerExpData>();
    public static int defaultNeedExp = 16;

    public static void AddExp(Player player, ExpType expType, int amount) {
        PlayerExpData expData = GetOrCreateData(player);
        expData.AddValue(expType, amount);

        BossBar bossbar = BossBar.bossBar(Component.text(expType.toString()), 0.5f, BossBar.Color.BLUE, BossBar.Overlay.NOTCHED_6);
        player.showBossBar(bossbar);
        player.sendMessage(String.valueOf(playerExpDatas.get(player).expMap.get(expType)));
    }

    public Map<Integer, Integer> levelTable = new HashMap<Integer, Integer>();

    public static void InitLevelTable() {
        File file = new File(GGMCraft.dataPath);
    }

    public int calculateLevel(int exp) {
        return 1;
    }

    public static PlayerExpData GetOrCreateData(Player player) {
        if (playerExpDatas.containsKey(player))
            return playerExpDatas.get(player);
        PlayerExpData expData = new PlayerExpData(player);
        playerExpDatas.put(player, expData);
        return expData;
    }
}
