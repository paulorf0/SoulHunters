package com.src.game.Player.AttackAnimation.Ability.Fire;

import com.src.game.EntityConfig;
import com.src.game.Player.Player;
import com.src.game.Player.AttackAnimation.Ability.Skill;

public class Fireball extends Skill {

    @Override
    public void loadAnimation(Player player) {
        duration = 0.1f;
        
        EntityConfig inf = (EntityConfig) player.getType().getBaseConfig();

        player.loadTexture(inf.getPath() + "Fireball.png");
        player.loadAnimation(duration, inf.getFireballCol(), inf.getFireballRow());
    }
}
