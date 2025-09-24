package com.src.game.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.src.game.Enemy.Enemy;
import com.src.game.Player.Ability.Ability;
import com.src.game.Player.AttackStrategy.Attack;
import com.src.game.Player.ProtectionStrategy.Protection;
import com.src.game.Player.State.AttackingState;
import com.src.game.Player.State.DyingState;
import com.src.game.Player.State.IdleState;
import com.src.game.Player.State.JumpingState;
import com.src.game.Player.State.RunningState;
import com.src.game.Player.State.State;
import com.src.game.Player.State.WalkingState;
import com.src.game.Player.Weapon.Weapon;
import com.src.game.Player.Wizard.WizardType;

// Abstract Factory Pattern
public abstract class Player extends Sprite {
    protected State state;
    protected Attack attackStrategy;
    protected Weapon weapon;
    protected Ability ability;
    protected Protection protection;
    protected PlayerType type;

    protected int width;
    protected int height;
    protected boolean facingRight = true;

    protected float xp;
    protected int level;
    protected float life;
    protected int runningSpeed;
    protected int walkingSpeed;
    protected int jumpSpeed;
    protected int jumpForce; // Total that player can jump (in pixel's)
    protected float velocityX;
    protected float velocityY;
    protected boolean isJumping;

    protected int intelligencePoints;
    protected int strengthPoints;

    protected Texture texture;
    protected Animation<TextureRegion> animation;
    protected float stateTime;

    protected int screen_width;
    protected int screen_height;

    // States
    protected AttackingState attackingState;
    protected DyingState dyingState;
    protected IdleState idleState;
    protected RunningState runningState;
    protected WalkingState walkingState;
    protected JumpingState jumpingState;

    protected Player(WizardType type, int width, int height) {
        super();
        xp = 0.f;
        level = 1;
        life = 10;

        intelligencePoints = 1;
        strengthPoints = 1;

        runningSpeed = 5;
        walkingSpeed = 2;
        jumpSpeed = 2;
        jumpForce = 6;

        screen_width = Gdx.graphics.getWidth();
        screen_height = Gdx.graphics.getHeight();

        this.width = width;
        this.height = height;

        // Initialize states
        attackingState = new AttackingState();
        dyingState = new DyingState();
        idleState = new IdleState();
        runningState = new RunningState();
        walkingState = new WalkingState();
        jumpingState = new JumpingState();

        isJumping = false;

        setType(type);
        setState(idleState);
    }

    public abstract void createWeapon();

    public abstract void createAbility();

    public abstract void takeDamage(int amount);

    public abstract void attack(Enemy enemy);

    public void update() {
        state.update(this);

        updateSpriteDirection();
        wallCollision();
    }

    public void handleInput() {
        boolean isMoving = Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.D);

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            setState(jumpingState);
        } else if (isMoving) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                setState(runningState);
            } else {
                setState(walkingState);
            }
        } else {
            setState(idleState);
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

    public void resetStateTime() {
        stateTime = 0.f;
    }

    public void nextStateTime() {
        stateTime += Gdx.graphics.getDeltaTime();
    }

    public void setRegionTexture(boolean repeat) {
        setRegion(animation.getKeyFrame(stateTime, repeat));
    }

    public void dispose() {
        if (texture != null)
            texture.dispose();
    }

    public State getState() {
        return state;
    }

    public Attack getAttackStrategy() {
        return attackStrategy;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Ability getAbility() {
        return ability;
    }

    public PlayerType getType() {
        return type;
    }

    public float getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public float getLife() {
        return life;
    }

    public int getIntelligencePoints() {
        return intelligencePoints;
    }

    public int getStrengthPoints() {
        return strengthPoints;
    }

    public float getStateTime() {
        return stateTime;
    }

    public void setState(State newState) {
        if (state != null && newState.getClass().equals(state.getClass()))
            return;
        state = newState;
        state.enterState(this);
    }

    public void setAttackStrategy(Attack attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public void setLife(float life) {
        this.life = life;
    }

    public void setProtection(Protection protection) {
        this.protection = protection;
    }

    public void setIntelligencePoints(int intelligencePoints) {
        this.intelligencePoints = intelligencePoints;
    }

    public void setStrengthPoints(int strengthPoints) {
        this.strengthPoints = strengthPoints;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public void setFacingRight(boolean facing) {
        facingRight = facing;
    }

    public void setVelocityX(float vel) {
        velocityX = vel;
    }

    public void setVelocityY(float vel) {
        velocityY = vel;
    }

    public void setIsJumping() {
        if (isJumping == false)
            isJumping = true;
        else
            isJumping = false;
    }

    public int getRunningSpeed() {
        return runningSpeed;
    }

    public AttackingState getAttackingState() {
        return attackingState;
    }

    public DyingState getDyingState() {
        return dyingState;
    }

    public IdleState getIdleState() {
        return idleState;
    }

    public RunningState getRunningState() {
        return runningState;
    }

    public WalkingState getWalkingState() {
        return walkingState;
    }

    public JumpingState getJumpingState() {
        return jumpingState;
    }

    public int getWalkingSpeed() {
        return walkingSpeed;
    }

    public int getJumpForce() {
        return jumpForce;
    }

    public float getJumpSpeed() {
        return jumpSpeed;
    }

    public float getVelocityX() {
        return velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public boolean getIsJumping(){
        return isJumping;
    }

}
