package com.github.cheesesoftware.PowerfulPermsAPI;

public class CachedGroup {
    private Group group;
    private boolean primary;
    private boolean secondary;
    private boolean negated;

    public CachedGroup(Group group, boolean primary, boolean secondary, boolean negated) {
        this.group = group;
        this.primary = primary;
        this.secondary = secondary;
        this.negated = negated;
    }

    public Group getGroup() {
        return this.group;
    }

    public boolean isPrimary() {
        return this.primary;
    }

    public boolean isSecondary() {
        return this.secondary;
    }

    public boolean isNegated() {
        return this.negated;
    }
}
