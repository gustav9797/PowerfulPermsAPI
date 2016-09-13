package com.github.cheesesoftware.PowerfulPermsAPI;

import java.util.UUID;

public class PlayerLoadedEvent extends Event {
    private final UUID playerUUID;

    public PlayerLoadedEvent(UUID playerUUID) {
        this.playerUUID = playerUUID;
    }

    public UUID getPlayerUUID() {
        return this.playerUUID;
    }

}
