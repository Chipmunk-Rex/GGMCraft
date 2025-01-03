package org.chipmunk.gGMCraft;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public class PLayerManager {
    public static PLayerManager Instance;

    public static void Initailize() {
        new PLayerManager();
    }

    public PLayerManager() {
        if (Instance == null)
            Instance = this;

        File folder = new File(GGMCraft.dataPath, "Players");
        folder.mkdir();
    }

    public HashMap<UUID, PlayerData> playerDatas = new HashMap<>();

    public void tryLoadPlayerData(Player player) {
        GGMCraft.Debug("wwwwwww");
        File file = getPLayeFile(player);
        if (file.exists() == false) {
            createPlayerFile(player);
        }
        FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration(file);
        String playerData = fileConfiguration.get("PlayerData").toString();
        GGMCraft.Debug(playerData);
    }

    private void createPlayerFile(Player player) {
        File file = getPLayeFile(player);
        FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    private File getPLayeFile(Player player) {
        UUID uuid = player.getUniqueId();
        File file = new File(GGMCraft.dataPath + "/Players", uuid.toString() + ".yml");
        return file;
    }
}
