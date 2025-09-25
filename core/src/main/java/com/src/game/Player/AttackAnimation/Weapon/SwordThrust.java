package com.src.game.Player.AttackAnimation.Weapon;

import com.src.game.Player.Player;
import com.src.game.Player.Wizard.WizardConfig;

public class SwordThrust extends Weapon {
    private final float duration = 0.2f;

    public SwordThrust() {
        super();
    }

    @Override
    public void loadAnimation(Player player) {
        WizardConfig inf = (WizardConfig) player.getType().getBaseConfig();

        player.loadTexture(inf.getPath() + "SwordThrust.png");
        player.loadAnimation(duration, inf.getFire_wizard_sword_thrust_col(), inf.getFire_wizard_sword_thrust_row());
    }
}
