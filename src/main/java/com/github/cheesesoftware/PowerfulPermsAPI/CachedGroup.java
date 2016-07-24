package com.github.cheesesoftware.PowerfulPermsAPI;

import java.util.Date;

public class CachedGroup {
    private int id;
    private Group group;
    private boolean negated;
    private Date expires;

    public CachedGroup(int id, Group group, boolean negated, Date expires) {
        this.id = id;
        this.group = group;
        this.negated = negated;
        this.expires = expires;
    }

    public int getId() {
        return this.id;
    }

    public Group getGroup() {
        return this.group;
    }

    public boolean isNegated() {
        return this.negated;
    }

    public Date getExpirationDate() {
        return expires;
    }

    public boolean willExpire() {
        return expires != null;
    }

    public static boolean isSimilar(CachedGroup group, int groupId, boolean negated, Date expires) {
        if (group == null)
            return false;
        if (group.getGroup().getId() == groupId) {
            if (group.isNegated() == negated) {
                if (group.getExpirationDate() == null && expires == null)
                    return true;
                else if (group.getExpirationDate() == null || expires == null)
                    return false;
                return group.getExpirationDate().equals(expires);
            }
        }
        return false;
    }
}
