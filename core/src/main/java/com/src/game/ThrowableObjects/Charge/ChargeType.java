package com.src.game.ThrowableObjects.Charge;

import com.src.game.EntityConfig;
import com.src.game.EntityType;
import com.src.game.EntityTypeInterface;

public class ChargeType implements EntityTypeInterface {
    private final EntityConfig config;
    private final EntityType type;

    public ChargeType(EntityConfig config, EntityType type) {
        this.config = config;
        this.type = type;
    }

    @Override
    public EntityConfig getBaseConfig() {
        return config;
    }

    @Override
    public EntityType getType() {
        return type;
    }

}
