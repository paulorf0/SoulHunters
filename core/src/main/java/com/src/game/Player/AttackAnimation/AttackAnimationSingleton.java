package com.src.game.Player.AttackAnimation;

import com.src.game.Player.AttackAnimation.Ability.Ability;
import com.src.game.Player.AttackAnimation.Ability.Fireball;
import com.src.game.Player.AttackAnimation.Ability.Flamejet;
import com.src.game.Player.AttackAnimation.Weapon.SwordSliding;
import com.src.game.Player.AttackAnimation.Weapon.SwordThrust;
import com.src.game.Player.AttackAnimation.Weapon.Weapon;

public class AttackAnimationSingleton {
    private static Weapon lungeAttack;
    private static Weapon slidingAttack;
    private static Ability fireBall;
    private static Ability flameJet;

    private AttackAnimationSingleton() {

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

    public static Ability getFireBall() {
        if (fireBall == null) {
            fireBall = new Fireball();
        }
        return fireBall;
    }

    public static Ability getFlameJet() {
        if (flameJet == null) {
            flameJet = new Flamejet();
        }
        return flameJet;
    }

}
