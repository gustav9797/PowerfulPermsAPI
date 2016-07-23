package com.github.cheesesoftware.PowerfulPermsAPI;

import java.util.Map;

public class DBDocument {

    protected Map<String, Object> data;

    public DBDocument(Map<String, Object> data) {
        this.data = data;
    }

    public Object get(String key) {
        return data.get(key);
    }

    public String getString(String key) {
        return (String) data.get(key);
    }

    public int getInt(String key) {
        Object input = data.get(key);
        if (input instanceof Long) {
            return ((Long) input).intValue();
        }
        return (Integer) input;
    }

    public boolean getBoolean(String key) {
        return (Boolean) data.get(key);
    }
}
