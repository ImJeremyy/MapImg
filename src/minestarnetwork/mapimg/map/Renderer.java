package minestarnetwork.mapimg.map;

import minestarnetwork.mapimg.utility.Util;
import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import java.awt.image.BufferedImage;

/**
 * Renderer is a MapRenderer
 * Used in MapView.addRenderer();
 */
public class Renderer extends MapRenderer {

    private BufferedImage image;
    private int width,height,x,y;

    public Renderer(BufferedImage imageToRender, int width, int height, int xCoord, int yCoord) {
        image = imageToRender;
        this.width = width;
        this.height = height;
        this.x = xCoord;
        this.y = yCoord;
    }

    @Override
    public void render(MapView view, MapCanvas canvas, Player player) {
        BufferedImage croppedImage = Util.cropImage(image, width, height, x, y);
        BufferedImage scaledImage = Util.getScaledImage(croppedImage, 128, 128);
        canvas.drawImage(0, 0, scaledImage);
    }
}
