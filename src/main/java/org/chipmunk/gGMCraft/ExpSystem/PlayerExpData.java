package org.chipmunk.gGMCraft.ExpSystem;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class PlayerExpData {
    HashMap<ExpType, Integer> expMap = new HashMap<ExpType, Integer>() {
        {
            for (ExpType expType : ExpType.values()) {
                put(expType, 0);
            }
        }
    };
    Player owner;

    public PlayerExpData(Player player) {
        owner = player;
    }

    public void AddValue(ExpType expType, Integer amount) {
        Integer currentAmount = expMap.get(expType);
        expMap.put(expType, currentAmount + amount);
    }
}
