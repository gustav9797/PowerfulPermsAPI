package com.github.cheesesoftware.PowerfulPermsAPI;

import java.util.HashMap;
import java.util.List;

public interface PermissionPlayer {

    public HashMap<String, List<CachedGroup>> getCachedGroups();
    
    public List<CachedGroup> getCachedGroups(String server);
    
    public List<Group> getGroups(String server);
    
    public List<Group> getGroups();
    
    public List<Permission> getPermissions();
    
    public List<String> getPermissionsInEffect();

    public Boolean hasPermission(String permission);

    public boolean isPermissionSet(String permission);
    
    public Group getGroup(String ladder);
    
    public Group getGroup();
    
    public String getPrefix(String ladder);
    
    public String getSuffix(String ladder);

    public String getPrefix();

    public String getSuffix();
    
    public String getOwnPrefix();
    
    public String getOwnSuffix();
    
    public boolean isDefault();

}
