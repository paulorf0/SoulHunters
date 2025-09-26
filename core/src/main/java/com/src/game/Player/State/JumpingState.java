package com.src.game.Player.State;

import com.badlogic.gdx.Gdx;
import com.src.game.EntityConfig;
import com.src.game.config;
import com.src.game.Player.Player;

public class JumpingState extends State {
    private final float gravity = -5f;

    // To-Do: Make a method more clear and change the method "setIsJumping" to get a boolean value.
    @Override
    public void update(Player player) {
        float delta = Gdx.graphics.getDeltaTime();
        int currentFrame = player.getCurrentFrameIndex();
        
        if (currentFrame < 3) {
        } else if (currentFrame >= 3 && currentFrame < 5) {
            if (!player.getIsJumping()) {
                player.setIsJumping();
            }
            player.setVelocityY(player.getJumpForce() * delta * 100);
            player.translateY(player.getVelocityY());

        }
        if (player.getIsJumping() && currentFrame == 5) {
            player.translateY(gravity* 100 * delta);

            if (player.getY() <= config.floor) {
                player.nextStateTime();
                player.setRegionTexture(false);
                player.setPosition(player.getX(), config.floor);
            }
        }

        if (currentFrame != 5) {
            player.nextStateTime();
            player.setRegionTexture(false);
        }

        if (player.isAnimationFinished()) {
            player.setIsJumping();
            player.setState(player.getIdleState());
            player.setVelocityY(0);
            player.setVelocityX(0);
        }

        handleMovement(player);
    }

    @Override
    public void enterState(Player player) {
        player.resetStateTime();

        // Duração de cada frame. Ajuste para controlar a velocidade da animação.
        float frameDuration = 0.1f;

        EntityConfig inf = (EntityConfig) player.getType().getBaseConfig();
        player.loadTexture(inf.getPath() + "Jump.png");
        player.loadAnimation(frameDuration, inf.getJumpCol(), inf.getJumpRow());

    }

}