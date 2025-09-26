package com.src.game.Player.AttackAnimation;

import com.src.game.EntityType;
import com.src.game.EntityTypeInterface;
import com.src.game.Player.AttackAnimation.Ability.Skill;
import com.src.game.Player.AttackAnimation.Ability.Fire.Fireball;
import com.src.game.Player.AttackAnimation.Ability.Fire.Flamejet;
import com.src.game.Player.AttackAnimation.Weapon.Weapon;
import com.src.game.Player.AttackAnimation.Weapon.Sword.SwordSliding;
import com.src.game.Player.AttackAnimation.Weapon.Sword.SwordThrust;

// This class is not totaly equal a Factory Pattern
public class AttackAnimationFactory {
    private static Weapon lungeAttack;
    private static Weapon slidingAttack;
    private static Skill chargeAttack;
    private static Skill jetAttack;

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

    public static Skill getChargeAttack(EntityTypeInterface type) {
        if (type.getType() == EntityType.FIRE_WIZARD && !(jetAttack instanceof Fireball)) {
            chargeAttack = new Fireball();
        }

        return chargeAttack;
    }

    public static Skill getJetAttack(EntityTypeInterface type) {
        if (type.getType() == EntityType.FIRE_WIZARD && !(jetAttack instanceof Flamejet)) {
            jetAttack = new Flamejet();
        }
        return jetAttack;
    }

}
