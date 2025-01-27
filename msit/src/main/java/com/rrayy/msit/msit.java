package com.rrayy.msit;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class msit extends JavaPlugin implements Listener {
    private final Map<Player, Inventory> playerInventories = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("msit plugin has been enabled!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("msit plugin has been disabled!");
    }

    @EventHandler
    public void onSwift(PlayerSwapHandItemsEvent e) {
        Player p = e.getPlayer();
        if (p.isSneaking()) {
            e.setCancelled(true);
            Inventory inventory = playerInventories.computeIfAbsent(p, k -> Bukkit.createInventory(p, InventoryType.CHEST));

            // 인벤토리의 첫 번째 슬롯에 아이템을 추가합니다.
            ItemStack item = new ItemStack(Material.DIAMOND, 1);
            inventory.setItem(0, item);
            p.openInventory(inventory);
        }
    }
}