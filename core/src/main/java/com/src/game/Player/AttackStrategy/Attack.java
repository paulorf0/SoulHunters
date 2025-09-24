package com.src.game.Player.AttackStrategy;

import com.src.game.Enemy.Enemy;
import com.src.game.Player.Player;
import com.src.game.Player.Weapon.Weapon;

public interface Attack {
    public void attack(Player player, Enemy enemy);
}
