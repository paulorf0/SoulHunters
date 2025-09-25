package com.src.game.Player.State;

import com.src.game.Player.Player;

public class AttackingState extends State {
    @Override
    public void update(Player player) {
        player.nextStateTime();
        player.setRegionTexture(false);

        if(player.isAnimationFinished()){
            player.setState(player.getIdleState());
        }
    }

    @Override
    public void enterState(Player player) {
        player.resetStateTime();
        player.getAnimableAttack().loadAnimation(player);
    }

}
