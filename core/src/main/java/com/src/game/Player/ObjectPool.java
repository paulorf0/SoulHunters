package com.src.game.Player;

import java.util.ArrayList;
import java.util.List;

import com.src.game.EntityType;
import com.src.game.ThrowableObjects.ThrowableObject;

public class ObjectPool {
    private List<ThrowableObject> throwableObjects;
    private Player player;

    public ObjectPool(Player player) {
        this.player = player;
        throwableObjects = new ArrayList<>();

        initThrowableObjects();
    }

    public void initThrowableObjects() {
        int count = player.getThrowableObjectsLimit();

        // This method is bad. Always that a new character is add in game, this part
        // need be modified.
        if (player.getType().getType() == EntityType.FIRE_WIZARD) {
            while (count-- > 0) {
                // throwableObjects.add(new ThrowableObject());
            }

            return;
        }else{
            // To developer.
            System.out.println("Tipo não reconhecido");
        }
    }

}
