package com.src.game.Player.AttackAnimation.Ability;

import com.src.game.Player.AttackAnimation.Animable;

public abstract class Skill implements Animable {
    protected float cooldown;
    protected float duration;

    public Skill() {

    }
}
