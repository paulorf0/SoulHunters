package com.src.game.Player.Wizard.FireWizard;

import com.src.game.EntityType;
import com.src.game.EntityTypeInterface;
import com.src.game.Player.Player;
import com.src.game.Player.AttackStrategy.MagicAttack;

public class FireWizard extends Player {

    public FireWizard() {
        super(new FireWizardType(), 256, 256);

        attackStrategy = new MagicAttack(); // Default
        intelligence = 5;
        strengh = 1;
    }

}
