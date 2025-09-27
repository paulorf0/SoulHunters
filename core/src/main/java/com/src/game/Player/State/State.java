package com.src.game.Player.State;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.src.game.Player.Player;
import com.src.game.Player.AttackAnimation.AttackAnimationFactory;
import com.src.game.Player.AttackAnimation.Ability.Skill;
import com.src.game.Player.AttackAnimation.Weapon.Weapon;
import com.src.game.ThrowableObjects.ThrowableObject;

public abstract class State {

    public abstract void update(Player player);

    public abstract void enterState(Player player);

    protected void handleMovement(Player player) {
        float delta = Gdx.graphics.getDeltaTime();

        // if i add more keys, this method should change.
        // Moves
        boolean movingA = Gdx.input.isKeyPressed(Input.Keys.A);
        boolean movingD = Gdx.input.isKeyPressed(Input.Keys.D);
        boolean jumping = Gdx.input.isKeyPressed(Input.Keys.SPACE);

        // Weapon Attacks
        boolean lungeAttack = Gdx.input.isKeyJustPressed(Input.Keys.E);
        boolean slidingAttack = Gdx.input.isButtonJustPressed(Input.Buttons.LEFT);

        // Ability Attacks
        boolean jetAttack = Gdx.input.isKeyJustPressed(Input.Keys.R);
        boolean chargeAttack = Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT);

        boolean weaponAttack = lungeAttack || slidingAttack;
        boolean abilityAttack = jetAttack || chargeAttack;

        boolean moving = movingA || movingD || jumping;
        boolean sprint = Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT);

        boolean stopMovement = player.getIsJumping();
        boolean stopAttack = player.getIsAttacking();

        boolean stop = stopMovement || stopAttack;
        boolean movement = moving || weaponAttack || abilityAttack;

        State movementState = sprint ? player.getRunningState() : player.getWalkingState();

        if (movement) {
            if (!stop) {
                if (lungeAttack) {
                    Weapon weapon = AttackAnimationFactory.getLungeAttack();

                    player.setCurrentAnimableAttack(weapon);
                    player.setWeapon(weapon);
                    player.setState(player.getAttackingState());
                    return;
                }

                if (slidingAttack) {
                    Weapon weapon = AttackAnimationFactory.getSlidingAttack();

                    player.setCurrentAnimableAttack(weapon);
                    player.setWeapon(weapon);
                    player.setState(player.getAttackingState());
                    return;
                }

                if (jetAttack) {
                    Skill ability = AttackAnimationFactory.getJetAttack(player.getType());

                    player.setCurrentAnimableAttack(ability);
                    player.setAbility(ability);
                    player.setState(player.getAttackingState());
                    return;
                }

                if (chargeAttack) {
                    Skill ability = AttackAnimationFactory.getChargeAttack(player.getType());

                    for(ThrowableObject to : player.getPool())
                
                    player.setCurrentAnimableAttack(ability);
                    player.setAbility(ability);
                    player.setState(player.getAttackingState());
                    return;
                }

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
        } else if (!stop) {
            player.setState(player.getIdleState());
        }
    }
}
