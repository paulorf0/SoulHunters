package com.src.game.Player.State;

import com.src.game.Player.Player;
import com.src.game.Player.Wizard.WizardConfig;

public class WalkingState extends State {
    private final float duration = 0.3f;

    @Override
    public void update(Player player) {
        handleMovement(player);
        // normalPlayerUpdateMovement(player);

        player.nextStateTime();
        player.setRegionTexture(true);

    }

    public void enterState(Player player) {
        player.resetStateTime();

        WizardConfig inf = (WizardConfig) player.getType().getBaseConfig();

        player.loadTexture(inf.getPath() + "Walk.png");
        player.loadAnimation(duration, inf.getWalkCol(), inf.getWalkRow());
    }

   

}
