# PowerfulPerms API
API for Spigot plugin PowerfulPerms

Example of how to use:
```
PowerfulPermsPlugin plugin = (PowerfulPermsPlugin) Bukkit.getPluginManager().getPlugin("PowerfulPerms");
PermissionManager permissionManager = plugin.getPermissionManager();
PermissionPlayer player = permissionManager.getPermissionsPlayer(e.getPlayer().getUniqueId());
Bukkit.getLogger().info("Player prefix: " + player.getPrefix());
Bukkit.getLogger().info("Player own prefix: " + player.getOwnPrefix());
Bukkit.getLogger().info("Player suffix: " + player.getSuffix());
Bukkit.getLogger().info("Player own suffix: " + player.getOwnSuffix());
Bukkit.getLogger().info("Player primary group: " + player.getPrimaryGroup().getName());

String output = "Current groups: ";
for (Group group : player.getGroups()) {
    output += group.getName() + ", ";
}
Bukkit.getLogger().info(output);

output = "All groups: ";
for (Map.Entry<String, List<CachedGroup>> entry : player.getCachedGroups().entrySet()) {
    output += "On server " + entry.getKey() + ": ";
    for (CachedGroup group : entry.getValue()) {
        output += group.getGroup().getName() + " - primary:" + group.isPrimary() + " - negated:" + group.isNegated() + ", ";
    }
}
Bukkit.getLogger().info(output);

output = "Current permissions: ";
for (String perm : player.getPermissionsInEffect()) {
    output += perm + ", ";
}
Bukkit.getLogger().info(output);

output = "All permissions: ";
for (Permission perm : player.getPermissions()) {
    output += perm.getPermissionString() + " - server:" + perm.getServer() + " - world:" + perm.getWorld() + ", ";
}
Bukkit.getLogger().info(output);
```
