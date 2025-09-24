package com.src.game.Player.State;

import com.src.game.Player.Player;

public class AttackingState extends State {
    private final float duration = 0.7f;

    @Override
    public void update(Player player) {
    }

    @Override
    public void enterState(Player player) {

        // player.loadTexture(player.getType().getBasePath() +
        // player.getAttackingPathTexture());
        // player.loadAnimation(player.getAttackingAnimationDuration(),
        // player.getAttackingAnimationCols(), player.getAttackingAnimationRows());

    }

}
