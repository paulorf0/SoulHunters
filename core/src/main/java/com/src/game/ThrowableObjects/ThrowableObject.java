package com.src.game.ThrowableObjects;

import com.badlogic.gdx.Gdx;
import com.src.game.EntityTypeInterface;
import com.src.game.GameEntity;

public class ThrowableObject extends GameEntity {
    private int speed;
    private String parent;

    public ThrowableObject(EntityTypeInterface type, String texturePath, String parent, int width, int height,
            float duration,
            int frame_col, int frame_row) {
        super(type, width, height);
        
        speed = 5;
        this.parent = parent;
        
        resetStateTime();
        loadTexture(texturePath);
        loadAnimation(duration, frame_col, frame_row);
    }

    public void update() {
        float delta = Gdx.graphics.getDeltaTime();
        float vel = delta * 100 * speed;

    }

}
