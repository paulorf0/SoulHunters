package com.src.game.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.src.game.EntityTypeInterface;
import com.src.game.GameEntity;
import com.src.game.Player.AttackAnimation.Animable;
import com.src.game.Player.AttackAnimation.Ability.Skill;
import com.src.game.Player.AttackAnimation.Weapon.Weapon;
import com.src.game.Player.AttackStrategy.AttackStrategy;
import com.src.game.Player.ProtectionStrategy.Protection;
import com.src.game.Player.State.AttackingState;
import com.src.game.Player.State.DyingState;
import com.src.game.Player.State.IdleState;
import com.src.game.Player.State.JumpingState;
import com.src.game.Player.State.RunningState;
import com.src.game.Player.State.State;
import com.src.game.Player.State.WalkingState;

// Abstract Factory Pattern
public abstract class Player extends GameEntity {
    protected State state;
    protected AttackStrategy attackStrategy;
    protected Animable currentAnimableAttack;
    protected Protection protection;

    // What do I do with these attack classes?
    protected Weapon weapon;
    protected Skill ability;
    protected ObjectPool pool;

    protected float xp;
    protected int level;
    protected float life;
    protected int throwableObjectsLimit;
    protected int runningSpeed;
    protected int walkingSpeed;
    protected int jumpSpeed;
    protected int jumpForce;

    protected boolean isJumping;
    protected boolean isAttacking;

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

    protected Player(EntityTypeInterface type, int width, int height) {
        super(type, width, height);

        // Attributes
        xp = 0.f;
        level = 1;
        life = 10;

        runningSpeed = 5;
        walkingSpeed = 2;
        jumpSpeed = 2;
        jumpForce = 6;
        throwableObjectsLimit = 5;

        // Initialize states
        attackingState = new AttackingState();
        dyingState = new DyingState();
        idleState = new IdleState();
        runningState = new RunningState();
        walkingState = new WalkingState();
        jumpingState = new JumpingState();

        // State Attributes
        isJumping = false;
        isAttacking = false;

        screen_width = Gdx.graphics.getWidth();
        screen_height = Gdx.graphics.getHeight();

        setState(idleState);

        // Pool
        pool = new ObjectPool(this);
    }

    public void update() {
        state.update(this);

        updateSpriteDirection();

        
        threatWallCollision();
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

    public void dispose() {
        if (texture != null)
            texture.dispose();
    }

    public State getState() {
        return state;
    }

    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Skill getAbility() {
        return ability;
    }

    public EntityTypeInterface getType() {
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
        return intelligence;
    }

    public float getStateTime() {
        return stateTime;
    }

    public boolean getIsAttacking() {
        return isAttacking;
    }

    public void setIsAttacking(boolean isAttacking) {
        this.isAttacking = isAttacking;
    }

    public void setState(State newState) {
        if (state != null && newState.getClass().equals(state.getClass()))
            return;
        state = newState;
        state.enterState(this);
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setAbility(Skill ability) {
        this.ability = ability;
    }

    public void setLife(float life) {
        this.life = life;
    }

    public void setProtection(Protection protection) {
        this.protection = protection;
    }

    public void setIntelligencePoints(int intelligencePoints) {
        this.intelligence = intelligencePoints;
    }

    public void setType(EntityTypeInterface type) {
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

    public boolean getIsJumping() {
        return isJumping;
    }

    public Animable getCurrentAnimableAttack() {
        return currentAnimableAttack;
    }

    public void setCurrentAnimableAttack(Animable animableAttack) {
        this.currentAnimableAttack = animableAttack;
    }

    public Protection getProtection() {
        return protection;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isFacingRight() {
        return facingRight;
    }

    public void setXp(float xp) {
        this.xp = xp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setRunningSpeed(int runningSpeed) {
        this.runningSpeed = runningSpeed;
    }

    public void setWalkingSpeed(int walkingSpeed) {
        this.walkingSpeed = walkingSpeed;
    }

    public void setJumpSpeed(int jumpSpeed) {
        this.jumpSpeed = jumpSpeed;
    }

    public void setJumpForce(int jumpForce) {
        this.jumpForce = jumpForce;
    }

    public void setJumping(boolean isJumping) {
        this.isJumping = isJumping;
    }

    public void setAttacking(boolean isAttacking) {
        this.isAttacking = isAttacking;
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

    public void setStateTime(float stateTime) {
        this.stateTime = stateTime;
    }

    public int getScreen_width() {
        return screen_width;
    }

    public void setScreen_width(int screen_width) {
        this.screen_width = screen_width;
    }

    public int getScreen_height() {
        return screen_height;
    }

    public void setScreen_height(int screen_height) {
        this.screen_height = screen_height;
    }

    public void setAttackingState(AttackingState attackingState) {
        this.attackingState = attackingState;
    }

    public void setDyingState(DyingState dyingState) {
        this.dyingState = dyingState;
    }

    public void setIdleState(IdleState idleState) {
        this.idleState = idleState;
    }

    public void setRunningState(RunningState runningState) {
        this.runningState = runningState;
    }

    public void setWalkingState(WalkingState walkingState) {
        this.walkingState = walkingState;
    }

    public void setJumpingState(JumpingState jumpingState) {
        this.jumpingState = jumpingState;
    }

    public void resetAttack() {
        ability = null;
        weapon = null;
    }

    public void setPool(ObjectPool pool) {
        this.pool = pool;
    }

    public ObjectPool getPool() {
        return pool;
    }

    public void setThrowableObjectsLimit(int throwableObjectsLimit) {
        this.throwableObjectsLimit = throwableObjectsLimit;
    }

    public int getThrowableObjectsLimit() {
        return throwableObjectsLimit;
    }
}
