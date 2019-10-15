package minestarnetwork.commands;

import minestarnetwork.MapImgMain;
import minestarnetwork.map.MapHandler;
import minestarnetwork.utility.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MapImgCommand implements CommandExecutor {

    private MapHandler mh;

    public MapImgCommand(MapImgMain plugin) {
        this.mh = plugin.getMapHandler();
    }

    /**
     * /mapimg create name url width height 5
     * /mapimg get name 2
     * /mapimg delete name 2
     * /mapimg list 1
     * /mapimg help 1
     */

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("help")) {
                    player.sendMessage(Util.cleanColourize("&6MapImg &bby MarkIsCool"));
                    player.sendMessage(Util.cleanColourize("&6/mapimg create &b<name> <url> <width> <height> &f- Create a (collection of) map(s)."));
                    player.sendMessage(Util.cleanColourize("&6/mapimg get &b<name> &f- Get a (collection of) map(s)"));
                    player.sendMessage(Util.cleanColourize("&6/mapimg delete &b<name> &f- Delete a (collection of) map(s)"));
                    player.sendMessage(Util.cleanColourize("&6/mapimg list &f- Lists all previously created map (collections)."));
                    player.sendMessage(Util.cleanColourize("&6/mapimg help &f- Displays this message."));
                } else if (args[0].equalsIgnoreCase("list")) {
                    //TODO
                } else {
                    player.sendMessage(Util.colourize("&cInvalid command. /mapimg help"));
                }
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("get")) {
                    //TODO
                } else if (args[0].equalsIgnoreCase("delete")) {
                    //TODO
                } else {
                    player.sendMessage(Util.colourize("&cInvalid command. /mapimg help"));
                }
            } else if (args.length == 5) {
                if (args[0].equalsIgnoreCase("create")) { //mapimg create name url width height
                    String name = args[1].toLowerCase();
                    String url = args[2];
                    int width, height;
                    try {
                        width = Integer.parseInt(args[3]);
                        height = Integer.parseInt(args[4]);
                    } catch (NumberFormatException e) {
                        player.sendMessage(Util.colourize("&cInvalid width or height. Numbers must be integers."));
                        return true;
                    }
                    //TODO
                } else {
                    player.sendMessage(Util.colourize("&cInvalid command. /mapimg help"));
                }
            }
        } else {
            sender.sendMessage(Util.colourize("&cYou are not a player!"));
        }
        return true;
    }

}
