package com.src.game.ThrowableObjects;

import com.badlogic.gdx.Gdx;
import com.src.game.EntityTypeInterface;
import com.src.game.GameEntity;

public class ThrowableObject extends GameEntity {
    private int speed;
    private int direction;
    private GameEntity parent;

    public ThrowableObject(EntityTypeInterface type, GameEntity parent, int width, int height,
            float duration,
            int frame_col, int frame_row) {
        super(type, width, height);

        speed = 5;
        this.parent = parent;

        resetStateTime();
        loadTexture(type.getBaseConfig().getPath());
        loadAnimation(duration, frame_col, frame_row);
    }

    public void update() {
        if (!isAlive)
            return;

        float delta = Gdx.graphics.getDeltaTime();
        float vel = delta * 100 * speed * direction;

        translateX(vel);

        threatWallCollision();
    }

    @Override
    public void threatWallCollision() {
        int max_x = screen_width - width / 2;
        int min_x = 0 - width / 2;

        int side = wallCollision(max_x, min_x);

        if (side != 0) {
            isAlive = false;
        }
    }

    public void setDirection() {
        if (parent.getFacingRight()) {
            direction = 1;
        } else {
            direction = -1;
        }
    }

    public void setPos() {
        float x = parent.getX() + width;
        float y = parent.getY();

        setPosition(x, y);
    }

}
