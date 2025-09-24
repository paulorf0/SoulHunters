package com.src.game.Player.State;

import com.src.game.Player.Player;
import com.src.game.Player.Wizard.WizardConfig;

public class DyingState extends State {
    private final float duration = 0.2f;

    @Override
    public void update(Player player) {
        player.nextStateTime();
        player.setRegionTexture(false);
    }

    @Override
    public void enterState(Player player) {
        player.resetStateTime();
        WizardConfig inf = (WizardConfig) player.getType().getBaseConfig();

        player.loadTexture(inf.getPath() + "Dead.png");
        player.loadAnimation(duration, inf.getDyingCol(), inf.getDyingRow());
    }

}
