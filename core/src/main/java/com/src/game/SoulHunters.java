package com.src.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.src.game.Player.Player;
import com.src.game.Player.Wizard.FireWizard.FireWizard;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class SoulHunters extends ApplicationAdapter {
    private SpriteBatch batch;

    private Player player;

    @Override
    public void create() {
        batch = new SpriteBatch();
        player = new FireWizard();
        player.setPosition(500, config.floor);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        player.update();

        batch.begin();

        drawSprites();
        drawTextures();

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    private void drawSprites() {
        player.draw(batch);
    }

    private void drawTextures() {

    }
}
