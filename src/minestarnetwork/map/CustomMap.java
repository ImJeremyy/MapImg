package minestarnetwork.map;

import minestarnetwork.utility.Util;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class CustomMap {

    private World world;
    private String name, url;
    private int width,height;

    private BufferedImage completeImg;
    private List<ItemStack> maps;

    public CustomMap(World world, String name, String url, int width, int height) {
        this.world = world;
        this.name = name;
        this.url = url;
        this.width = width;
        this.height = height;
        this.completeImg = Util.getImage(url);

        initItems();
    }

    public String getName() {
        return name;
    }

    public String getURL() {
        return url;
    }

    public World getWorld() {
        return world;
    }

    public List<ItemStack> getMaps() {
        return maps;
    }

    private void initItems() {
        maps = new ArrayList<>();
        for(int x = 1; x <= width; x++) {
            for(int y = 1; y <= height; y++) {
                ItemStack item = Util.createMapItemStack(name, world, completeImg, width, height, x, y);
                maps.add(item);
            }
        }
    }

}
