package com.src.game.Player.Wizard.FireWizard;

import com.src.game.Enemy.Enemy;
import com.src.game.Player.AttackStrategy.MagicAttack;
import com.src.game.Player.Weapon.Sword;
import com.src.game.Player.Wizard.Wizard;
import com.src.game.Player.Wizard.WizardType;

public class FireWizard extends Wizard {

    public FireWizard() {
        super(WizardType.FIRE_WIZARD, 256, 256);

        attackStrategy = new MagicAttack(); // Default
        intelligencePoints = 5;
        strengthPoints = 1;
    }

    @Override
    public void createWeapon() {
        weapon = new Sword();
    }

    @Override
    public void createAbility() {
        // Some ability
    }

    @Override
    public void attack(Enemy enemy) {
        attackStrategy.attack(this, enemy);
    }



}
