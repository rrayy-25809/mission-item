package com.rrayy.msit.MsInv;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class EventListener implements Listener {
    private final InventoryManager inventoryManager;

    public EventListener(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        Inventory Inv = event.getClickedInventory();
        if(Inv == null) return;
        Player player = (Player) event.getWhoClicked();
        Inventory playerWindow = (Inventory) inventoryManager.playerWindows.get(player);
        if (Inv.equals(playerWindow)) {
            // Add your logic here for when the inventories match
        }
    }
}
