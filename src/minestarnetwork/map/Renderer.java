package minestarnetwork.map;

import minestarnetwork.utility.Util;
import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import java.awt.image.BufferedImage;

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
        canvas.drawImage(0, 0, Util.getScaledImage(Util.cropImage(image, width, height, x, y), 128, 128));
    }
}
