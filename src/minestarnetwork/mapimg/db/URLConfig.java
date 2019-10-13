package minestarnetwork.mapimg.db;

import minestarnetwork.mapimg.ChatUtil;
import minestarnetwork.mapimg.MapImgMain;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class URLConfig {

    /**
     * urls:
     *  lemon: https://www.google.com/
     *  poopoo: https://www.hypixel.net/
     */

    private MapImgMain plugin;

    private File file;
    private FileConfiguration config;

    private final String pathName = "urls.";

    public URLConfig(final MapImgMain plugin) {
        this.plugin = plugin;
        createFile();
    }

    public void register(final String name, final String url) {
        config.set(pathName + name, url);
        save();
    }

    public URL getURL(final String name) throws MalformedURLException {
        return new URL(config.getString(pathName + name));
    }

    public boolean exists(final String name) {
        return config.contains(pathName + name);
    }

    public List<String> getURLs() {
        return config.getStringList("urls");
    }

    private void createFile() {
        file = new File(plugin.getDataFolder(), "urls.yml");
        try {
            file.createNewFile();
        } catch (IOException e) {
            plugin.getLogger().warning(ChatUtil.colourize("&cCould not create urls.yml"));
            e.printStackTrace();
        }
        config = YamlConfiguration.loadConfiguration(file);

        config.createSection("urls");
        save();
    }

    private void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            plugin.getLogger().warning(ChatUtil.colourize("&cCould not save urls.yml"));
            e.printStackTrace();
        }
    }

}
