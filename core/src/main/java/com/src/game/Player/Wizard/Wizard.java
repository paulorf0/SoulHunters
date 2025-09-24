package com.src.game.Player.Wizard;

import com.src.game.Player.Player;

public abstract class Wizard extends Player {

    protected Wizard(WizardType type, int width, int height) {
        super(type, width, height);
    }

    @Override
    public void takeDamage(int amount) {
        if (life >= amount)
            life -= amount;
    }
}
