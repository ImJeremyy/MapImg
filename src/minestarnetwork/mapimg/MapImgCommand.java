package minestarnetwork.mapimg;

import minestarnetwork.mapimg.db.URLConfig;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class MapImgCommand implements CommandExecutor {

    private MapImgMain plugin;
    private URLConfig config;

    public MapImgCommand(final MapImgMain plugin) {
        this.plugin = plugin;
        this.config = plugin.getURLConfig();
    }

    /**
     * /mapimg create name url 3
     * /mapimg get name 2
     * /mapimg delete name 2
     * /mapimg list 1
     */

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 1) {

        } else if(args.length >= 2) {
            String path = args[0];
            String name = args[1];
            Player player = (Player) sender;
            if(path.equalsIgnoreCase("create")) {
                String url = args[2];
                config.register(name, url);
                sender.sendMessage(ChatUtil.colourize("&aSuccessfully registered &6" + name));
            } else if(path.equalsIgnoreCase("get")) { //mapimg get <name >
                if(config.exists(name)) {
                    if (player.getInventory().firstEmpty() != - 1) {
                        ItemStack map = new ItemStack(Material.MAP, 1);
                        player.getInventory().addItem(map);
                    } else {
                        player.sendMessage(ChatUtil.colourize("&cYour inventory is full!"));
                    }
                } else {
                    player.sendMessage(ChatUtil.colourize("&cMapImg not found. (/mapimg list)"));
                }
            } else if(path.equalsIgnoreCase("delete")) {

            }
        }
        return true;
    }

}
