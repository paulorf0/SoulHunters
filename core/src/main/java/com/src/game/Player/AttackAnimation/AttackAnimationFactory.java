package com.src.game.Player.AttackAnimation;

import com.src.game.Player.PlayerType;
import com.src.game.Player.Type;
import com.src.game.Player.AttackAnimation.Ability.Ability;
import com.src.game.Player.AttackAnimation.Ability.Fire.Fireball;
import com.src.game.Player.AttackAnimation.Ability.Fire.Flamejet;
import com.src.game.Player.AttackAnimation.Weapon.Weapon;
import com.src.game.Player.AttackAnimation.Weapon.Sword.SwordSliding;
import com.src.game.Player.AttackAnimation.Weapon.Sword.SwordThrust;

// This class is not totaly equal a Factory Pattern
public class AttackAnimationFactory {
    private static Weapon lungeAttack;
    private static Weapon slidingAttack;
    private static Ability chargeAttack;
    private static Ability jetAttack;

    private AttackAnimationFactory() {

    }

    public static Weapon getLungeAttack() {
        if (lungeAttack == null) {
            lungeAttack = new SwordThrust();
        }
        return lungeAttack;
    }

    public static Weapon getSlidingAttack() {
        if (slidingAttack == null) {
            slidingAttack = new SwordSliding();
        }

        return slidingAttack;
    }

    public static Ability getChargeAttack(PlayerType type) {
        if (type.getType() == Type.FIRE_WIZARD && !(jetAttack instanceof Fireball)) {
            chargeAttack = new Fireball();
        }

        return chargeAttack;
    }

    public static Ability getJetAttack(PlayerType type) {
        if (type.getType() == Type.FIRE_WIZARD && !(jetAttack instanceof Flamejet)) {
            jetAttack = new Flamejet();
        }
        return jetAttack;
    }

}
