package minestarnetwork.mapimg.utility;

import org.bukkit.permissions.Permission;

public enum Perm {

    MAPIMG_GET("mapimg.use");

    private Permission perm;

    Perm(String node) {
        perm = new Permission(node);
    }

    public Permission getPermission() {
        return perm;
    }

}
