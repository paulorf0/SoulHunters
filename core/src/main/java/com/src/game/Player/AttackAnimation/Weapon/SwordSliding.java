package com.src.game.Player.AttackAnimation.Weapon;

import com.src.game.Player.Player;
import com.src.game.Player.Wizard.WizardConfig;

public class SwordSliding extends Weapon {
    private final float duration = 0.1f;

    public SwordSliding(){
        super();
    }

    @Override
    public void loadAnimation(Player player) {
        WizardConfig inf = (WizardConfig) player.getType().getBaseConfig();

        player.loadTexture(inf.getPath() + "SwordSliding.png");
        player.loadAnimation(duration, inf.getFire_wizard_sword_sliding_col(), inf.getFire_wizard_sword_sliding_row());
    }

}
