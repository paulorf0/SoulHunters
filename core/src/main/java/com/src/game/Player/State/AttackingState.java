package com.src.game.Player.State;

import com.src.game.Player.Player;

public class AttackingState extends State {
    @Override
    public void update(Player player) {
        // player.getCurrentAnimableAttack();
        // if(player.getStamina())

        player.nextStateTime();
        player.setRegionTexture(false);

        if (player.isAnimationFinished()) {
            player.setIsAttacking(false);
            player.setState(player.getIdleState());
            player.resetAttack();
        }
    }

    @Override
    public void enterState(Player player) {
        player.setIsAttacking(true);
        player.resetStateTime();
        player.getCurrentAnimableAttack().loadAnimation(player);
    }
}
