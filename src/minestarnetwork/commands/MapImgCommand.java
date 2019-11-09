package minestarnetwork.commands;

import minestarnetwork.MapImgMain;
import minestarnetwork.map.CustomMap;
import minestarnetwork.utility.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class MapImgCommand implements CommandExecutor {

    public MapImgCommand(MapImgMain plugin) {

    }

    /**
     * /mapimg get url width height 4
     * /mapimg help 1
     */

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("help")) {
                    player.sendMessage(Util.cleanColourize("&6MapImg &bby MarkIsCool"));
                    player.sendMessage(Util.cleanColourize("&6/mapimg get &b<url> <width> <height> &f- Get an img map with desired width and height."));
                    player.sendMessage(Util.cleanColourize("&6/mapimg help &f- Displays this message."));
                } else {
                    player.sendMessage(Util.colourize("&cInvalid command. /mapimg help"));
                }
            } else if(args.length == 4) {
                if(args[0].equalsIgnoreCase("get")) {
                    String url = args[1];
                    int width, height;
                    try {
                        width = Integer.parseInt(args[2]);
                        height = Integer.parseInt(args[3]);
                    } catch (NumberFormatException e) {
                        player.sendMessage(Util.colourize("&cInvalid width or height. Must be numbers. /mapimg help"));
                        return true;
                    }
                    if(!Util.invalidURLImage(url)) {
                        CustomMap map = new CustomMap(player.getWorld(), url, width, height);
                        List<ItemStack> items = map.getMaps();
                        int size = items.size();
                        int emptySlots = 36 - player.getInventory().getContents().length;
                        if(size <= emptySlots) {//checks if amount of maps is less than empty slots
                            items.stream().forEach(x -> player.getInventory().addItem(x));
                            player.sendMessage(Util.colourize("&aSuccessfully given map with URL &6" + url));
                        } else {
                            player.sendMessage(Util.colourize("&cYour inventory is full!"));
                        }
                    } else {
                        player.sendMessage(Util.colourize("&cInvalid URL image."));
                    }
                } else {
                    player.sendMessage(Util.colourize("&cInvalid command. /mapimg help"));
                }
            } else {
                player.sendMessage(Util.colourize("&cInvalid arguments. /mapimg help"));
            }
        } else {
            sender.sendMessage(Util.colourize("&cYou are not a player!"));
        }
        return true;
    }

}
