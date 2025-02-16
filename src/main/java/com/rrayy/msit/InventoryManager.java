package com.rrayy.msit;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import xyz.xenondevs.invui.InvUI;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.SimpleItem;
import xyz.xenondevs.invui.window.Window;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private final Map<Player, Window> playerWindows = new HashMap<>();
    public final msit plugin;

    public InventoryManager(msit plugin) {
        this.plugin = plugin;
        InvUI.getInstance().setPlugin(plugin);
    }

    public void openInventory(Player player) {
        Window window = playerWindows.computeIfAbsent(player, this::createInventoryWindow);
        window.open();
    }

    private Window createInventoryWindow(Player player) {
        SimpleItem item = new SimpleItem(new ItemBuilder(Material.DIAMOND).setDisplayName("§aDiamond"));
        Gui gui = Gui.empty(9, 2);

        // set items using x and y coordinates
        gui.setItem(0, 0, item);

        // set an item using the slot index
        gui.setItem(10, item);

        Window window = Window.single()
                .setViewer(player)
                .setTitle("InvUI")
                .setGui(gui)
                .build();
        
        return window;
    }
}