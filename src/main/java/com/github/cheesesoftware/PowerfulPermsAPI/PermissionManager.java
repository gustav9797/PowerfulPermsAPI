package com.github.cheesesoftware.PowerfulPermsAPI;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
    public void getPlayerOwnGroups(UUID uuid, ResultRunnable<LinkedHashMap<String, List<CachedGroup>>> resultRunnable);

    /**
     * Retrieves all current groups of the player with the specified name. If player does not have any groups it includes the groups of player [default].
     */
    public void getPlayerCurrentGroups(UUID uuid, ResultRunnable<LinkedHashMap<String, List<CachedGroup>>> resultRunnable);

    /**
     * Checks if player uses groups from player [default].
     */
    public void isPlayerDefault(UUID uuid, ResultRunnable<Boolean> resultRunnable);
    
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
    public String getGroupPrefix(int groupId, String server);

    /**
     * Retrieves the suffix of the group with the specified name on the specified server. Set server to an empty String or "all" for all servers.
     */
    public String getGroupSuffix(int groupId, String server);

    /**
     * Retrieves the prefixes of the group with the specified name. The map is indexed by server name.
     */
    public HashMap<String, String> getGroupServerPrefix(int groupId);

    /**
     * Retrieves the suffixes of the group with the specified name. The map is indexed by server name.
     */
    public HashMap<String, String> getGroupServerSuffix(int groupId);

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

    public void removePlayerGroup(UUID uuid, int groupId, ResponseRunnable response);

    public void removePlayerGroup(UUID uuid, int groupId, boolean negated, ResponseRunnable response);

    public void removePlayerGroup(UUID uuid, int groupId, String server, boolean negated, ResponseRunnable response);

    public void addPlayerGroup(UUID uuid, int groupId, ResponseRunnable response);

    public void addPlayerGroup(UUID uuid, int groupId, boolean negated, ResponseRunnable response);

    public void addPlayerGroup(UUID uuid, int groupId, String server, boolean negated, ResponseRunnable response);

    public void setPlayerRank(UUID uuid, int groupId, ResponseRunnable response);

    public void promotePlayer(UUID uuid, String ladder, ResponseRunnable response);

    public void demotePlayer(UUID uuid, String ladder, ResponseRunnable response);

    public void createGroup(String name, String ladder, int rank, ResponseRunnable response);

    public void deleteGroup(int groupId, ResponseRunnable response);

    public void addGroupPermission(int groupId, String permission, ResponseRunnable response);

    public void addGroupPermission(int groupId, String permission, String world, String server, ResponseRunnable response);

    public void removeGroupPermission(int groupId, String permission, ResponseRunnable response);

    public void removeGroupPermission(int groupId, String permission, String world, String server, ResponseRunnable response);

    public void removeGroupPermissions(int groupId, ResponseRunnable response);

    public void addGroupParent(int groupId, int parentGroupId, ResponseRunnable response);

    public void removeGroupParent(int groupId, int parentGroupId, ResponseRunnable response);

    public void setGroupPrefix(int groupId, String prefix, ResponseRunnable response);

    public void setGroupPrefix(int groupId, String prefix, String server, ResponseRunnable response);

    public void setGroupSuffix(int groupId, String suffix, ResponseRunnable response);

    public void setGroupSuffix(int groupId, String suffix, String server, ResponseRunnable response);

    public void setGroupLadder(int groupId, String ladder, ResponseRunnable response);

    public void setGroupRank(int groupId, int rank, ResponseRunnable response);

}