package com.github.cheesesoftware.PowerfulPermsAPI;

import java.util.UUID;
import java.util.logging.Logger;

public interface PowerfulPermsPlugin {
    
    public PermissionManager getPermissionManager();
    
    public Logger getLogger();
    
    public void runTaskAsynchronously(Runnable runnable);
    
    public void runTaskLater(Runnable runnable, int delay);
    
    public boolean isDebug();
    
    public boolean isOnlineMode();
    
    public boolean isPlayerOnline(UUID uuid);
    
    public boolean isPlayerOnline(String name);
    
    public UUID getPlayerUUID(String name);
    
    public String getPlayerName(UUID uuid);
    
    public void debug(String message);
    
    public int getOldVersion();
}
