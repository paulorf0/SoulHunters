package com.src.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class GameEntity extends Sprite {
    private boolean isAlive;
    protected boolean facingRight = true;
    protected float velocityX;
    protected float velocityY;
    protected int mana;
    protected int strengh;
    protected int intelligence;

    protected EntityTypeInterface type;

    protected Texture texture;
    protected Animation<TextureRegion> animation;
    protected float stateTime;

    protected int width;
    protected int height;

    protected int screen_height;
    protected int screen_width;

    public GameEntity(EntityTypeInterface type, int width, int height) {
        this.type = type;
        this.width = width;
        this.height = height;

        mana = 0;
        strengh = 0;
        intelligence = 0;

        velocityX = 0;
        velocityY = 0;

        screen_height = Gdx.graphics.getHeight();
        screen_width = Gdx.graphics.getWidth();
    }

    public void wallCollision() {
        int max_x = screen_width - width / 2;
        if (getX() > max_x) {
            setPosition(max_x, getY());
        }

        int min_x = 0 - width / 2;
        if (getX() < min_x) {
            setPosition(min_x, getY());
        }
    }

    public void loadTexture(String path) {
        texture = new Texture(path);
    }

    public void loadAnimation(float duration, int frame_col, int frame_row) {
        // https://libgdx.com/wiki/graphics/2d/2d-animation
        if (texture == null)
            return;
        if (duration <= 0)
            duration = .7f; // default.

        TextureRegion[][] tmp = TextureRegion.split(texture,
                texture.getWidth() / frame_col,
                texture.getHeight() / frame_row);

        TextureRegion[] frames = new TextureRegion[frame_col * frame_row];
        int index = 0;
        for (int i = 0; i < frame_row; i++) {
            for (int j = 0; j < frame_col; j++) {
                frames[index++] = tmp[i][j];
            }
        }

        animation = new Animation<TextureRegion>(duration, frames);
        setSize(width, height);
    }

    public int getCurrentFrameIndex() {
        if (animation == null) {
            return 0;
        }
        return animation.getKeyFrameIndex(stateTime);
    }

    public boolean isAnimationFinished() {
        if (animation == null) {
            return true;
        }
        return animation.isAnimationFinished(stateTime);
    }

    public void updateSpriteDirection() {
        if (facingRight && isFlipX()) {
            flip(true, false);
        } else if (!facingRight && !isFlipX()) {
            flip(true, false);
        }
    }

    public void setRegionTexture(boolean repeat) {
        setRegion(animation.getKeyFrame(stateTime, repeat));
    }

    public void resetStateTime() {
        stateTime = 0.f;
    }

    public void nextStateTime() {
        stateTime += Gdx.graphics.getDeltaTime();
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setisAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Animation<TextureRegion> getAnimation() {
        return animation;
    }

    public void setAnimation(Animation<TextureRegion> animation) {
        this.animation = animation;
    }

    public float getStateTime() {
        return stateTime;
    }

    public void setStateTime(float stateTime) {
        this.stateTime = stateTime;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getScreen_height() {
        return screen_height;
    }

    public void setScreen_height(int screen_height) {
        this.screen_height = screen_height;
    }

    public int getScreen_width() {
        return screen_width;
    }

    public void setScreen_width(int screen_width) {
        this.screen_width = screen_width;
    }

}
