package minestarnetwork;

import minestarnetwork.commands.DebugCommand;
import minestarnetwork.commands.MapImgCommand;
import minestarnetwork.map.MapHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class MapImgMain extends JavaPlugin {

    public static Logger log;

    private MapHandler mapHandler;

    @Override
    public void onEnable() {
        initObjects();
        initCommands();
    }

    public MapHandler getMapHandler() {
        return mapHandler;
    }

    private void initObjects() {
        log = getLogger();
        mapHandler = new MapHandler();
    }

    private void initCommands() {
        getCommand("mapimg").setExecutor(new MapImgCommand(this));
        getCommand("test").setExecutor(new DebugCommand());
    }
}
