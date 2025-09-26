package com.src.game.Player.AttackAnimation.Ability.Fire;

import com.src.game.Player.Player;
import com.src.game.Player.Wizard.WizardConfig;

public class Flamejet extends FireAbility {
    private final float duration = 0.1f;

    @Override
    public void loadAnimation(Player player) {
        WizardConfig inf = (WizardConfig) player.getType().getBaseConfig();

        player.loadTexture(inf.getPath() + "FlameJet.png");
        player.loadAnimation(duration, inf.getFlameJetCol(), inf.getFlameJetRow());

    }

}
