package minestarnetwork.mapimg.map;

import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapPalette;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Renderer extends MapRenderer {

    @Override
    public void render(MapView view, MapCanvas canvas, Player player) {
        BufferedImage image;
        try {
            image = ImageIO.read(new URL("https://i.stack.imgur.com/WxVXe.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        canvas.drawImage(0, 0, image);
    }

}
