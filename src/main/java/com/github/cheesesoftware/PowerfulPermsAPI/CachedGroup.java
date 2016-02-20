package com.github.cheesesoftware.PowerfulPermsAPI;

public class CachedGroup {
    private Group group;
    private boolean negated;

    public CachedGroup(Group group, boolean negated) {
        this.group = group;
        this.negated = negated;
    }

    public Group getGroup() {
        return this.group;
    }
    
    public boolean isNegated() {
        return this.negated;
    }
}
