package com.src.game.Player.Wizard.FireWizard;

import com.src.game.EntityConfig;
import com.src.game.EntityType;
import com.src.game.EntityTypeInterface;

public class FireWizardType implements EntityTypeInterface {

    private final EntityConfig config;
    private final EntityType type;

    public FireWizardType() {
        config = new FireWizardConfig();
        type = EntityType.FIRE_WIZARD;
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
