package minestarnetwork.map;

import minestarnetwork.utility.Util;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * A CustomMap contains the full BufferedImage. It also contains a List<ItemStack> object which contains
 * the full image broken down into its desired dimensions.
 *
 * Sample Code:
 * CustomMap myImg = new CustomMap(Bukkit.getWorld(world), "Lemon", 3, 4)
 */

public class CustomMap {

    private World world;
    private String url;
    private int width,height;

    private BufferedImage completeImg;
    private List<ItemStack> maps;

    public CustomMap(World world, String url, int width, int height) {
        this.world = world;
        this.url = url;
        this.width = width;
        this.height = height;
        this.completeImg = Util.getImage(url);

        initItems();
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
                ItemStack item = Util.createMapItemStack("&6Map", world, completeImg, width, height, x, y);
                maps.add(item);
            }
        }
    }

}
