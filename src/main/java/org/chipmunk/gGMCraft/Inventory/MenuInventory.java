package org.chipmunk.gGMCraft.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class MenuInventory {
    static Inventory menuInventory;
    public static Inventory GetMenuInventory()
    {
        if(menuInventory == null) {
            menuInventory = Bukkit.createInventory(null, 36,"Menu");
        }
        return menuInventory;
    }
}
