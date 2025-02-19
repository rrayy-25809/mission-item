package com.rrayy.msit;

import org.bukkit.plugin.java.JavaPlugin;

import com.rrayy.msit.MsInv.InventoryManager;
import xyz.xenondevs.invui.InvUI;

public class msit extends JavaPlugin {
    private InventoryManager inventoryManager;

    @Override
    public void onEnable() { // Plugin startup logic
        InvUI.getInstance().setPlugin(this); // InvUI 플러그인 설정
        inventoryManager = new InventoryManager(this);
        getServer().getPluginManager().registerEvents(new EventListener(this), this);
        getLogger().info("msit plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("msit plugin has been disabled!");
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }
}