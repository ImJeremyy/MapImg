package minestarnetwork.mapimg.map;

import minestarnetwork.mapimg.MapImgMain;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.map.MapView;

public class MapInitializeListener implements Listener {

    private MapImgMain plugin;

    public MapInitializeListener(final MapImgMain plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMapInit(final MapInitializeEvent event) {
        MapView view = event.getMap();
        view.setScale(MapView.Scale.FARTHEST);
        view.setUnlimitedTracking(false);
        view.setTrackingPosition(false);
        view.getRenderers().clear();
        view.addRenderer(new Renderer());
    }

}
