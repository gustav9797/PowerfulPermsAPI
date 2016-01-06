package com.github.cheesesoftware.PowerfulPermsAPI;

import java.util.HashMap;
import java.util.List;

public interface Group {

    public int getId();

    public String getName();

    public List<Group> getParents();

    public String getPrefix(String server);

    public String getSuffix(String server);

    public HashMap<String, String> getServerPrefix();

    public HashMap<String, String> getServerSuffix();

    public List<Permission> getOwnPermissions();

    public List<Permission> getPermissions();

    public String getRawOwnParents();

    public void setParents(List<Group> parents);

}