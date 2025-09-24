package com.src.game.Player.State;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.src.game.Player.Player;

public abstract class State {

    public abstract void update(Player player);

    public abstract void enterState(Player player);

    protected void handleMovement(Player player) {
        float delta = Gdx.graphics.getDeltaTime();

        // if i add more keys, this method should change.
        boolean movingA = Gdx.input.isKeyPressed(Input.Keys.A);
        boolean movingD = Gdx.input.isKeyPressed(Input.Keys.D);
        boolean jumping = Gdx.input.isKeyPressed(Input.Keys.SPACE);
        boolean moving = movingA || movingD || jumping;
        boolean sprint = Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT);
        boolean isJumping = player.getIsJumping();

        State movementState = sprint ? player.getRunningState() : player.getWalkingState();

        if (moving) {
            if (!isJumping) {
                if (sprint) {
                    player.setVelocityX(player.getRunningSpeed() * delta * 100);
                } else {
                    player.setVelocityX(player.getWalkingSpeed() * delta * 100);
                }

                if (jumping) {
                    player.setState(player.getJumpingState());
                    player.setVelocityY(player.getJumpSpeed() * delta * 100);
                } else {
                    player.setState(movementState);
                }
            }

            if (movingA) {
                player.translateX(-player.getVelocityX());
                player.setFacingRight(false);
            }

            if (movingD) {
                player.translateX(player.getVelocityX());
                player.setFacingRight(true);
            }
        } else if (!isJumping) {
            player.setState(player.getIdleState());
        }
    }
}
