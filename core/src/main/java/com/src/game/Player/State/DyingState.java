package com.src.game.Player.State;

import com.src.game.EntityConfig;
import com.src.game.Player.Player;

public class DyingState extends State {
    private final float duration = 0.2f;

    @Override
    public void update(Player player) {
        player.nextStateTime();
        player.setRegionTexture(false);

        if (player.isAnimationFinished()) {
            player.setAlive(false);
        }
    }

    @Override
    public void enterState(Player player) {
        player.resetStateTime();
        EntityConfig inf = (EntityConfig) player.getType().getBaseConfig();

        player.loadTexture(inf.getPath() + "Dead.png");
        player.loadAnimation(duration, inf.getDyingCol(), inf.getDyingRow());
    }

}
