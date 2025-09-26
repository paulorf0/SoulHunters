package com.src.game.Player.AttackAnimation.Weapon.Sword;

import com.src.game.EntityConfig;
import com.src.game.Player.Player;
import com.src.game.Player.AttackAnimation.Weapon.Weapon;

public class SwordThrust extends Weapon {
    private final float duration = 0.2f;

    public SwordThrust() {
        super();
    }

    @Override
    public void loadAnimation(Player player) {
        EntityConfig inf = (EntityConfig) player.getType().getBaseConfig();

        player.loadTexture(inf.getPath() + "SwordThrust.png");
        player.loadAnimation(duration, inf.getSwordThrustCol(), inf.getSwordThrustRow());
    }
}
