package com.rrayy.msit.MsInv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.bukkit.Material;

import com.rrayy.msit.msit;

import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.SimpleItem;

public class RandomIt {
    private ArrayList<Material> materials = new ArrayList<>(Arrays.asList(Material.values()));
    @SuppressWarnings("unused")
    private final msit plugin;
    private Random random = new Random();

    public RandomIt(msit plugin) {
        this.plugin = plugin;
    }

    public SimpleItem getRandomItem() {
        int index = random.nextInt(materials.size());
        Material material = materials.get(index);
        return new SimpleItem(new ItemBuilder(material));
    }
}
