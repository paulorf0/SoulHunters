package com.src.game.Player.AttackAnimation.Weapon.Sword;

import com.src.game.Player.Player;
import com.src.game.Player.Wizard.WizardConfig;

public class SwordThrust extends SwordWeapon {
    private final float duration = 0.2f;

    public SwordThrust() {
        super();
    }

    @Override
    public void loadAnimation(Player player) {
        WizardConfig inf = (WizardConfig) player.getType().getBaseConfig();

        player.loadTexture(inf.getPath() + "SwordThrust.png");
        player.loadAnimation(duration, inf.getSwordThrustCol(), inf.getSwordThrustRow());
    }
}
