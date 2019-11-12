package minestarnetwork.commands;

import minestarnetwork.utility.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DebugCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        try {
            BufferedImage image = ImageIO.read(new URL(args[0]));
            List<ItemStack> items = new ArrayList<>();
            for(int x = 1; x <= 6; x++) { //width
                for(int y = 1; y <= 5; y++) { //height
                    ItemStack item = Util.createMapItemStack("Top Skills", player.getWorld(), image, 6, 5, x, y);
                    items.add(item);
                }
            }
            items.stream().forEach(i -> player.getInventory().addItem(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
