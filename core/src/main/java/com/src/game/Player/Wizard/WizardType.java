package com.src.game.Player.Wizard;

import com.src.game.Player.PlayerType;
import com.src.game.Player.Wizard.FireWizard.FireWizardConfig;

public enum WizardType implements PlayerType {
    // Agora o enum guarda a configuração de todas as animações principais
    FIRE_WIZARD(new FireWizardConfig()),
    ;

    private final WizardConfig config;

    WizardType(WizardConfig config) {
        this.config = config;
    }

    @Override
    public WizardConfig getBaseConfig() {
        return config;
    }

}