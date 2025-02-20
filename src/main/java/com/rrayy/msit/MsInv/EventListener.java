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
        if(Inv == null) {
            event.setCancelled(true);
            return;
        }
        Player player = (Player) event.getWhoClicked();
        Inventory playerWindow = (Inventory) inventoryManager.playerWindows.get(player);
        int slot = event.getSlot();
        if (Inv.equals(playerWindow) && inventoryManager.isCorrectSlot(slot)) {
            inventoryManager.ClickEvent(player, slot);
        } else {
            event.setCancelled(true);
        }
    }
}
