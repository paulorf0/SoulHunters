package com.src.game.ThrowableObjects;

import com.src.game.EntityConfig;
import com.src.game.EntityType;
import com.src.game.EntityTypeInterface;
import com.src.game.ThrowableObjects.Charge.ChargeConfig;

// TO DO HOW CAN I USE THIS CLASS?
public enum ThrowableType implements EntityTypeInterface {
    // CHARGE(EntityType.CHARGE, new ChargeConfig())

    ;

    private final EntityConfig config;
    private final EntityType type;

    private ThrowableType(EntityType type, EntityConfig config) {
        this.config = config;
        this.type = type;
    }

    public EntityConfig getBaseConfig() {
        return config;
    }

    public EntityType getType() {
        return type;
    }

}
