package com.github.cheesesoftware.PowerfulPermsAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PermissionManager {

    /**
     * If using Redis: Tells other servers to reload groups.
     */
    public void notifyReloadGroups();

    /**
     * If using Redis: Tells other servers to reload players.
     */
    public void notifyReloadPlayers();

    /**
     * If using Redis: Tells other server to reload a player with the specified name.
     */
    public void notifyReloadPlayer(String playerName);

    /**
     * Reloads permission data for online players.
     */
    public void reloadPlayers();

    /**
     * Reloads permission data for an online player with the specified name.
     */
    public void reloadPlayer(String name);

    /**
     * Reloads permission data for an online player with the specified UUID.
     */
    public void reloadPlayer(UUID uuid);

    /**
     * Returns the PermissionPlayer instance for the player with the specified UUID. Player has to be online.
     */
    public PermissionPlayer getPermissionsPlayer(UUID uuid);

    /**
     * Returns the PermissionPlayer instance for the player with the specified name. Player has to be online.
     */
    public PermissionPlayer getPermissionsPlayer(String name);

    /**
     * Reloads permission data for groups and finally reloads online players.
     */
    public void reloadGroups();

    /**
     * Retrieves a group from its name.
     */
    public Group getGroup(String groupName);

    /**
     * Retrieves a group from its ID.
     */
    public Group getGroup(int id);

    /**
     * Retrieves a clone of all groups.
     */
    public Map<Integer, Group> getGroups();

    /**
     * Retrieves all groups of the player with the specified name.
     */
    public void getPlayerGroups(String playerName, ResultRunnable<Map<String, List<CachedGroup>>> resultRunnable);

    /**
     * Retrieves a DBDocument with permission data of the player with the specified name.
     */
    public void getPlayerData(String playerName, ResultRunnable<DBDocument> resultRunnable);

    /**
     * Retrieves the primary group of the player with the specified name.
     */
    public void getPlayerPrimaryGroup(String playerName, ResultRunnable<Group> resultRunnable);

    /**
     * Retrieves a map containing all the permissions of the player with the specified name.
     */
    public void getPlayerOwnPermissions(String playerName, ResultRunnable<List<Permission>> resultRunnable);

    /**
     * Retrieves the prefix of the player with the specified name. If the player is not online it retrieves player own prefix from database.
     */
    public void getPlayerPrefix(String playerName, ResultRunnable<String> resultRunnable);

    /**
     * Retrieves the suffix of the player with the specified name. If the player is not online it retrieves player own suffix from database.
     */
    public void getPlayerSuffix(String playerName, ResultRunnable<String> resultRunnable);

    /**
     * Retrieves the own prefix of the player with the specified name.
     */
    public void getPlayerOwnPrefix(String playerName, ResultRunnable<String> resultRunnable);

    /**
     * Retrieves the own suffix of the player with the specified name.
     */
    public void getPlayerOwnSuffix(String playerName, ResultRunnable<String> resultRunnable);

    /**
     * Retrieves the prefix of the group with the specified name on the specified server. Set server to an empty String or "all" for all servers.
     */
    public String getGroupPrefix(String groupName, String server);

    /**
     * Retrieves the suffix of the group with the specified name on the specified server. Set server to an empty String or "all" for all servers.
     */
    public String getGroupSuffix(String groupName, String server);

    /**
     * Retrieves the prefixes of the group with the specified name. The map is indexed by server name.
     */
    public HashMap<String, String> getGroupServerPrefix(String groupName);

    /**
     * Retrieves the suffixes of the group with the specified name. The map is indexed by server name.
     */
    public HashMap<String, String> getGroupServerSuffix(String groupName);

    // Database accessing functions below

    public void addPlayerPermission(String playerName, String permission, ResponseRunnable response);

    public void addPlayerPermission(String playerName, String permission, String world, String server, ResponseRunnable response);

    public void removePlayerPermission(String playerName, String permission, ResponseRunnable response);

    public void removePlayerPermission(String playerName, String permission, String world, String server, ResponseRunnable response);

    public void removePlayerPermissions(String playerName, ResponseRunnable response);

    public void setPlayerPrefix(String playerName, String prefix, ResponseRunnable response);

    public void setPlayerSuffix(String playerName, String suffix, ResponseRunnable response);

    public void setPlayerPrimaryGroup(String playerName, String groupName, String server, ResponseRunnable response);

    public void removePlayerGroup(String playerName, String groupName, ResponseRunnable response);

    public void removePlayerGroup(String playerName, String groupName, boolean negated, ResponseRunnable response);

    public void removePlayerGroup(String playerName, String groupName, String server, boolean negated, ResponseRunnable response);

    public void addPlayerGroup(String playerName, String groupName, ResponseRunnable response);

    public void addPlayerGroup(String playerName, String groupName, boolean negated, ResponseRunnable response);

    public void addPlayerGroup(String playerName, String groupName, String server, boolean negated, ResponseRunnable response);

    public void createGroup(String name, ResponseRunnable response);

    public void deleteGroup(String groupName, ResponseRunnable response);

    public void addGroupPermission(String groupName, String permission, ResponseRunnable response);

    public void addGroupPermission(String groupName, String permission, String world, String server, ResponseRunnable response);

    public void removeGroupPermission(String groupName, String permission, ResponseRunnable response);

    public void removeGroupPermission(String groupName, String permission, String world, String server, ResponseRunnable response);

    public void removeGroupPermissions(String groupName, ResponseRunnable response);

    public void addGroupParent(String groupName, String parentGroupName, ResponseRunnable response);

    public void removeGroupParent(String groupName, String parentGroupName, ResponseRunnable response);

    public void setGroupPrefix(String groupName, String prefix, ResponseRunnable response);

    public void setGroupPrefix(String groupName, String prefix, String server, ResponseRunnable response);

    public void setGroupSuffix(String groupName, String suffix, ResponseRunnable response);

    public void setGroupSuffix(String groupName, String suffix, String server, ResponseRunnable response);

}