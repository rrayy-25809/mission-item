package com.rrayy.msit;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.xenondevs.invui.InvUI;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.SimpleItem;
import xyz.xenondevs.invui.window.Window;

import java.util.HashMap;
import java.util.Map;

public class msit extends JavaPlugin implements Listener {
    private final Map<Player, Window> playerWindows = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        InvUI.getInstance().setPlugin(this);
        getLogger().info("msit plugin has been enabled!");
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
            Window window = playerWindows.computeIfAbsent(p, k -> createInventoryWindow(p));
            window.open();
        }
    }

    private Window createInventoryWindow(Player player) {
        Gui gui = Gui.normal() // Creates the GuiBuilder for a normal GUI
        .setStructure(
        "# # # # # # # # #",
        "# . a . b . c . #",
        "# . A . B . C . #",
        "# # # # # # # # #")
        .addIngredient('#', new SimpleItem(new ItemBuilder(Material.LIGHT_GRAY_STAINED_GLASS_PANE)))
        .build();

        Window window = Window.single()
        .setViewer(player)
        .setTitle("InvUI")
        .setGui(gui)
        .build();
        
        return window;
    }
}