package com.src.game.Player.State;

import com.src.game.EntityConfig;
import com.src.game.Player.Player;

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

        EntityConfig inf = (EntityConfig) player.getType().getBaseConfig();

        player.loadTexture(inf.getPath() + "Walk.png");
        player.loadAnimation(duration, inf.getWalkCol(), inf.getWalkRow());
    }

   

}
