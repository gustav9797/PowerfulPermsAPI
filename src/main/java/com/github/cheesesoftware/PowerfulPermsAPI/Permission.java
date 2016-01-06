package com.github.cheesesoftware.PowerfulPermsAPI;

public interface Permission {

    /**
     * Returns the permission string.
     */
    public String getPermissionString();

    /**
     * Returns the name of the world the permission applies to.
     */
    public String getWorld();

    /**
     * Returns the name of the server the permission applies to. If empty or "all", applies to all servers.
     */
    public String getServer();

}