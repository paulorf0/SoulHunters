package com.src.game.Player.AttackStrategy;

import com.src.game.Enemy.Enemy;
import com.src.game.Player.Player;

// Pattern Strategy
public interface AttackStrategy {
    public void attack(Player player, Enemy enemy);
}
