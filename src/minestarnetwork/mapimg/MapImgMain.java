package minestarnetwork.mapimg;

import minestarnetwork.mapimg.commands.MapImgCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class MapImgMain extends JavaPlugin {

    public static Logger log;

    @Override
    public void onEnable() {
        initObjects();
        initCommands();
    }

    private void initObjects() {
        log = getLogger();
    }

    private void initCommands() {
        getCommand("mapimg").setExecutor(new MapImgCommand());
    }
}
