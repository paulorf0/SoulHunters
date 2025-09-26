package com.src.game.Player.Wizard;

import com.src.game.Player.PlayerType;
import com.src.game.Player.Type;
import com.src.game.Player.Wizard.FireWizard.FireWizardConfig;

public enum WizardType implements PlayerType {
    // Agora o enum guarda a configuração de todas as animações principais
    FIRE_WIZARD(new FireWizardConfig(), Type.FIRE_WIZARD),
    ;

    private final WizardConfig config;
    private final Type type;

    WizardType(WizardConfig config, Type type) {
        this.config = config;
        this.type = type;

    }

    @Override
    public WizardConfig getBaseConfig() {
        return config;
    }

    @Override
    public Type getType() {
        return type;
    }

}