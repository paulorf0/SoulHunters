package com.src.game.Player.AttackAnimation.Weapon.Sword;

import com.src.game.EntityConfig;
import com.src.game.Player.Player;
import com.src.game.Player.AttackAnimation.Weapon.Weapon;

public class SwordSliding extends Weapon {
    private final float duration = 0.1f;

    public SwordSliding() {
        super();
    }

    @Override
    public void loadAnimation(Player player) {
        EntityConfig inf = (EntityConfig) player.getType().getBaseConfig();

        player.loadTexture(inf.getPath() + "SwordSliding.png");
        player.loadAnimation(duration, inf.getSwordSlidingCol(), inf.getSwordSlidingRow());
    }

}
