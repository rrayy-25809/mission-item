package com.rrayy.msit;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class EventListener implements Listener {
    private final InventoryManager inventoryManager;

    public EventListener(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    @EventHandler
    public void onSwift(PlayerSwapHandItemsEvent e) {
        Player p = e.getPlayer();
        if (p.isSneaking()) {
            e.setCancelled(true);
            inventoryManager.openInventory(p);
        }
    }
}