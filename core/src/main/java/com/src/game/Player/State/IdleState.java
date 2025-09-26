package com.src.game.Player.State;

import com.src.game.EntityConfig;
import com.src.game.Player.Player;

public class IdleState extends State {
    private final float duration = 0.1f;

    @Override
    public void update(Player player) {
        handleMovement(player);

        player.nextStateTime();
        player.setRegionTexture(true);
    }

    @Override
    public void enterState(Player player) {
        player.resetStateTime();
        EntityConfig inf = (EntityConfig) player.getType().getBaseConfig();

        player.loadTexture(inf.getPath() + "Idle.png");
        player.loadAnimation(duration, inf.getIdleCol(), inf.getIdleRow());
    }

}
