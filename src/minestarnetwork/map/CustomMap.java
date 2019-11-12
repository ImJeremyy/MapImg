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
 * CustomMap myImg = new CustomMap(Bukkit.getWorld(world), "https://www.image.com/", 3, 4)
 */
public class CustomMap {

    private World world;
    private int width, height;

    private BufferedImage completeImg;
    private List<ItemStack> maps;

    /**
     * Main constructor
     * @param world - the world the overall map will be placed in
     * @param url - url of the image
     * @param width - amount of blocks horizontally
     * @param height - amount of blocks vertically
     *
     * Eg: width = 3 and height = 4 --> will create 12 ItemStack objects
     */
    public CustomMap(World world, String url, int width, int height) {
        this.world = world;
        this.width = width;
        this.height = height;
        this.completeImg = Util.getImage(url);

        this.initItems();
    }

    /**
     * Get all the ItemStack objects, that are all Map items.
     * @return List<ItemStack> all maps
     */
    public List<ItemStack> getMaps() {
        return maps;
    }

    /**
     * Initializes the ItemStack objects. Splits the image into multiple maps into desired dimensions.
     * Puts all ItemStack into List<ItemStack>
     */
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
