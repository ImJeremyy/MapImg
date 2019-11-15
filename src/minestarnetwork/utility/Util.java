package minestarnetwork.utility;

import minestarnetwork.MapImgMain;
import minestarnetwork.map.Renderer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

/**
 * Contains public static methods for wide-use.
 *
 */
public class Util {

    // ============================================================================================================
    // String utility methods
    // ============================================================================================================
    public static String colourize(final String text) {
        return ChatColor.translateAlternateColorCodes('&', "&b[&6MapImg&b]&r " + text);
    }

    public static String cleanColourize(final String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String strip(final String text) {
        return ChatColor.stripColor(text);
    }

    // ============================================================================================================
    // Image handling methods
    // ============================================================================================================

    /**
     * Scale (resize) a BufferedImage and get a new BufferedImage.
     * @param image - the image to be scaled
     * @param width - x pixels (eg 128)
     * @param height - y pixels (eg 128)
     * @return New scaled image
     */
    public static BufferedImage getScaledImage(BufferedImage image, int width, int height) {
        BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2 = newImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image, 0, 0, width, height, null);
        g2.dispose();
        return newImg;
    }

    /**
     * Get the BufferedImage from a String url
     * @param urlString url of the image
     * @return BufferedImage object | can return null, if url not valid.
     */
    public static BufferedImage getImage(String urlString) {
        try {
            URL url = new URL(urlString);
            return ImageIO.read(url);
        } catch (IOException e) {
            MapImgMain.log.warning(Util.colourize("&cAn invalid URL was inputted."));
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Crop an image based on coordinate system
     * @param completeImg - The complete image
     * @param width - The width of the image (coordinate integer)
     * @param height - The height of the image (coordinate integer)
     * @param xCoord - The x coordinate portion you want
     * @param yCoord - The y coordinate portion you want
     * @return Cropped BufferedImage
     */
    public static BufferedImage cropImage(BufferedImage completeImg, int width, int height, int xCoord, int yCoord) {
        int coordWidth = completeImg.getWidth()/width;
        int coordHeight = completeImg.getHeight()/height;
        BufferedImage croppedImg = new BufferedImage(completeImg.getWidth(), completeImg.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) croppedImg.getGraphics();
        g2.drawImage(completeImg, 0, 0, completeImg.getWidth(), completeImg.getHeight(),  null);
        g2.dispose();
        return croppedImg.getSubimage(coordWidth*(xCoord - 1), coordHeight*(yCoord - 1), coordWidth, coordHeight);
    }

    /**
     * Checks if a URL is a valid image
     * @param urlName Url of the image
     * @return true if the image is invalid (if an error is thrown basically)
     */
    public static boolean invalidURLImage(String urlName) {
        try {
            URL url = new URL(urlName);
            BufferedImage image = ImageIO.read(url);
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    // ============================================================================================================
    // ItemStack methods
    // ============================================================================================================

    /**
     * Create an ItemStack object of type Material.FILLED_MAP
     * Uses Renderer class
     * Tampers with MapMeta and MapView to add a portion of the complete BufferedImage,
     * given the width and height (in blocks) of the image and the desired x & y coordinat
     * @param name
     * @param world
     * @param completeImage
     * @param width
     * @param height
     * @param x
     * @param y
     * @return ItemStack object
     */
    public static ItemStack createMapItemStack(String name, World world, BufferedImage completeImage, int width, int height, int x, int y) {
        ItemStack map = new ItemStack(Material.FILLED_MAP, 1);
        MapMeta meta = (MapMeta) map.getItemMeta();
        meta.setDisplayName(Util.cleanColourize("&6" + name + "(&7" + x + "&6, &7" + y + "&6)"));
        meta.setMapView(Bukkit.createMap(world));
        MapView view = meta.getMapView();
        view.setUnlimitedTracking(false);
        view.getRenderers().clear();
        view.addRenderer(new Renderer(completeImage, width, height, x, y));
        meta.setMapView(view);
        map.setItemMeta(meta);
        return map;
    }

    /**
     * Returns amount of empty slots in an inventory
     * @param inventory Inventory object
     * @return amount of empty slots
     */
    public static int getEmptySlots(Inventory inventory) {
        int counter = 0;
        for(ItemStack item : inventory.getContents()) {
            if (item == null) {
                counter++;
            }
        }
        return counter;
    }

}
