package com.rrayy.msit.MsInv;

import org.bukkit.entity.Player;
import com.rrayy.msit.msit;

import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.item.Item;
import xyz.xenondevs.invui.item.impl.SimpleItem;
import xyz.xenondevs.invui.window.Window;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    public final Map<Player, Window> playerWindows = new HashMap<>();
    @SuppressWarnings("unused")
    private final msit plugin;
    private final RandomIt randomIt;

    public InventoryManager(msit plugin) {
        this.plugin = plugin;
        this.randomIt = new RandomIt(plugin);
        plugin.getServer().getPluginManager().registerEvents(new EventListener(this), plugin);
    }

    public void openInventory(Player player) {
        Window window = playerWindows.computeIfAbsent(player, this::createInventoryWindow);
        window.open();
    }

    private Window createInventoryWindow(Player player) {
        SimpleItem item = randomIt.getRandomItem();
        Gui gui = Gui.empty(9, 2);

        // set items using x and y coordinates
        gui.setItem(0, 0, item);

        // set an item using the slot index
        gui.setItem(10, item);

        Window window = Window.single()
        .setViewer(player)
        .setTitle("당신의 미션 아이템")
        .setGui(gui)
        .build();
        return window;
    }

    public void ClickEvent(Player player, int slot) {
        Gui gui = (Gui) playerWindows.get(player);
        Item clickedItem = gui.getItem(slot);
        if (clickedItem != null) {
            // Add your logic here for when the inventories match and an item is clicked
        }
    }

    public boolean isCorrectSlot(int slot) {
        int x = slot % 9;
        int y = slot / 9;
        return (x == 3 || x == 5 || x == 7) && y == 2;
    }
}