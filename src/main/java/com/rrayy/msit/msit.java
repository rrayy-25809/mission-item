package com.rrayy.msit;

import org.bukkit.plugin.java.JavaPlugin;

public class msit extends JavaPlugin {
    private InventoryManager inventoryManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        inventoryManager = new InventoryManager(this);
        getServer().getPluginManager().registerEvents(new EventListener(inventoryManager), this);
        getLogger().info("msit plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("msit plugin has been disabled!");
    }
}