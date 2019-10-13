package minestarnetwork.mapimg;

import minestarnetwork.mapimg.db.URLConfig;
import minestarnetwork.mapimg.map.MapInitializeListener;
import org.bukkit.plugin.java.JavaPlugin;

public class MapImgMain extends JavaPlugin {

    private URLConfig config;

    @Override
    public void onEnable() {
        initConfig();
        getServer().getPluginManager().registerEvents(new MapInitializeListener(this), this);
        getCommand("mapimg").setExecutor(new MapImgCommand(this));
    }

    @Override
    public void onDisable() {

    }

    public URLConfig getURLConfig() {
        return config;
    }

    private void initConfig() {
        config = new URLConfig(this);
    }

}
