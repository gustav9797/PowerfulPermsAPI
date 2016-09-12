# PowerfulPerms API
API for Spigot plugin PowerfulPerms.
This API works on both BungeeCord and Spigot.

```xml
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
```

Example of how to use:
```java
final PowerfulPermsPlugin plugin = (PowerfulPermsPlugin) Bukkit.getPluginManager().getPlugin("PowerfulPerms");
PermissionManager permissionManager = plugin.getPermissionManager();

// Add permission to player. There are more optional parameters such as server, world and expiry date.
final ListenableFuture<Response> future = permissionManager.addPlayerPermission(uuid, "some.permission");
future.addListener(new Runnable() {

    @Override
    public void run() {
        // This function is run synchronously when the action is finished. You can also change the executor so that it executes in the thread you want.
        // There is a boolean to tell you if the action succeeded or not, there is also a string response.
        boolean result = future.get().succeeded();
        if (!result)
            plugin.getLogger().severe("Could not add player permission. " + future.get().getResponse());
    }

}, MoreExecutors.sameThreadExecutor());

// Get prefix of an online/offline player.
// This time you will use a ResultRunnable with template for the returned data.
final ListenableFuture<String> future = permissionManager.getPlayerPrefix(uuid);
future.addListener(new Runnable() {

    @Override
    public void run() {
        // This function is run synchronously when the action is finished.
        // The prefix is in the variable called "result"
        String prefix = future.get();
    }

}, MoreExecutors.sameThreadExecutor());

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
```
