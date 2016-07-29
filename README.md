# PowerfulPerms API
API for Spigot plugin PowerfulPerms.
This API works on both BungeeCord and Spigot.

<repositories>
	<repository>
		<id>alskebo-repo</id>
		<url>http://repo.alskebo.com/repository/maven-releases</url>
	</repository>
</repositories>

<dependencies>
	<dependency>
		<groupId>com.github.cheesesoftware</groupId>
		<artifactId>PowerfulPermsAPI</artifactId>
		<version>X.X.X</version>
	</dependency>
</dependencies>

Example of how to use:
```
PowerfulPermsPlugin plugin = (PowerfulPermsPlugin) Bukkit.getPluginManager().getPlugin("PowerfulPerms");
PermissionManager permissionManager = plugin.getPermissionManager();

// Add permission to player
// Both UUID and name is required because that's how the table is.
permissionManager.addPlayerPermission(uuid, playerName, "some.permission", new ResponseRunnable() {

    @Override
    public void run() {
        // This function is run synchronously when the action is finished.
        // There is a boolean to tell you if the action succeeded or not, there is also a string response.
        boolean result = success;
        if (!result)
            Bukkit.getLogger().log(Level.SEVERE, "Could not add player permission. " + response);
    }
});

// Get prefix of an online/offline player.
// This time you will use a ResultRunnable with template for the returned data.
permissionManager.getPlayerPrefix(uuid, new ResultRunnable<String>() {

    @Override
    public void run() {
        // This function is run synchronously when the action is finished.
        // The prefix is in the variable called "result"
        String prefix = result;
    }
});

// Get an online player.
// Will be null if the player isn't online.
// This is simpler to use since there are no callbacks involved.
PermissionPlayer permissionPlayer = permissionManager.getPermissionPlayer(uuid);

// Get the prefix for a specific ladder from the online player.
String staffPrefix = permissionPlayer.getPrefix("staff");

// Get the prefix for the default ladder, if the player has his own prefix set it returns that instead.
String prefix = permissionPlayer.getPrefix();

// Get the player's own prefix.
String ownPrefix = permissionPlayer.getOwnPrefix();     
