package minestarnetwork.mapimg;

import org.bukkit.ChatColor;

public class ChatUtil {

    public static String colourize(final String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String strip(final String text) {
        return ChatColor.stripColor(text);
    }

}
