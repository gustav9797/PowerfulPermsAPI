package com.github.cheesesoftware.PowerfulPermsAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PermissionManager {

    // TODO: replace "with specified name"

    /**
     * If using Redis: Tells other servers to reload groups.
     */
    public void notifyReloadGroups();

    /**
     * If using Redis: Tells other servers to reload players.
     */
    public void notifyReloadPlayers();

    /**
     * If using Redis: Tells other server to reload a player with the specified UUID.
     */
    public void notifyReloadPlayer(UUID uuid);

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
     * Reloads data for default players.
     */
    public void reloadDefaultPlayers(boolean samethread);

    /**
     * Returns the PermissionPlayer instance for the player with the specified UUID. Player has to be online.
     */
    public PermissionPlayer getPermissionPlayer(UUID uuid);

    /**
     * Returns the PermissionPlayer instance for the player with the specified name. Player has to be online.
     */
    public PermissionPlayer getPermissionPlayer(String name);

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
     * Retrieves all groups of the player with the specified name as they are in the database.
     */
    public void getPlayerGroups(UUID uuid, ResultRunnable<Map<String, List<CachedGroup>>> resultRunnable);

    /**
     * Retrieves all current groups of the player with the specified name. If player does not have any groups it includes the groups of player [default].
     */
    public void getPlayerCurrentGroups(UUID uuid, ResultRunnable<Map<String, List<CachedGroup>>> resultRunnable);

    /**
     * Retrieves a DBDocument with permission data of the player with the specified name.
     */
    public void getPlayerData(UUID uuid, ResultRunnable<DBDocument> resultRunnable);

    /**
     * Retrieves a map containing all the permissions of the player with the specified name.
     */
    public void getPlayerOwnPermissions(UUID uuid, ResultRunnable<List<Permission>> resultRunnable);

    /**
     * Retrieves the prefix of the player with the specified name. If the player is not online it retrieves player own prefix.
     */
    public void getPlayerPrefix(UUID uuid, ResultRunnable<String> resultRunnable);

    /**
     * Retrieves the suffix of the player with the specified name. If the player is not online it retrieves player own suffix.
     */
    public void getPlayerSuffix(UUID uuid, ResultRunnable<String> resultRunnable);

    /**
     * Retrieves the own prefix of the player with the specified name.
     */
    public void getPlayerOwnPrefix(UUID uuid, ResultRunnable<String> resultRunnable);

    /**
     * Retrieves the own suffix of the player with the specified name.
     */
    public void getPlayerOwnSuffix(UUID uuid, ResultRunnable<String> resultRunnable);

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

    /**
     * Retrieves UUID from player name. If player is not online it uses Mojang API.
     */
    public void getConvertUUID(final String playerName, final ResultRunnable<UUID> resultRunnable);

    /**
     * Retrieves the scheduler used for sync and asynchronous operations, working on both BungeeCord and Spigot.
     */
    public IScheduler getScheduler();

    // Database accessing functions below

    public void createPlayer(String name, UUID uuid, ResponseRunnable response);

    public void addPlayerPermission(UUID uuid, String playerName, String permission, ResponseRunnable response);

    public void addPlayerPermission(UUID uuid, String playerName, String permission, String world, String server, ResponseRunnable response);

    public void removePlayerPermission(UUID uuid, String permission, ResponseRunnable response);

    public void removePlayerPermission(UUID uuid, String permission, String world, String server, ResponseRunnable response);

    public void removePlayerPermissions(UUID uuid, ResponseRunnable response);

    public void setPlayerPrefix(UUID uuid, String prefix, ResponseRunnable response);

    public void setPlayerSuffix(UUID uuid, String suffix, ResponseRunnable response);

    public void removePlayerGroup(UUID uuid, String groupName, ResponseRunnable response);

    public void removePlayerGroup(UUID uuid, String groupName, boolean negated, ResponseRunnable response);

    public void removePlayerGroup(UUID uuid, String groupName, String server, boolean negated, ResponseRunnable response);

    public void addPlayerGroup(UUID uuid, String groupName, ResponseRunnable response);

    public void addPlayerGroup(UUID uuid, String groupName, boolean negated, ResponseRunnable response);

    public void addPlayerGroup(UUID uuid, String groupName, String server, boolean negated, ResponseRunnable response);

    public void createGroup(String name, String ladder, int rank, ResponseRunnable response);

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

    public void setGroupLadder(String groupName, String ladder, ResponseRunnable response);

    public void setGroupRank(String groupName, int rank, ResponseRunnable response);

}