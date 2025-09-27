package com.src.game.Player;

import java.util.ArrayList;
import java.util.List;

import com.src.game.EntityConfig;
import com.src.game.EntityType;
import com.src.game.EntityTypeInterface;
import com.src.game.ThrowableObjects.ThrowableObject;
import com.src.game.ThrowableObjects.Charge.ChargeConfig;
import com.src.game.ThrowableObjects.Charge.ChargeType;

public class ObjectPool {
    private List<ThrowableObject> throwableObjects;
    private Player player;

    // TODO THE ENTITY JUST CAN THROW ONE TYPE OF THROWABLE OBJECT
    public ObjectPool(Player player) {
        this.player = player;
        throwableObjects = new ArrayList<>();

        initThrowableObjects();
    }

    public void initThrowableObjects() {
        int count = player.getThrowableObjectsLimit();

        // This method is bad. Always that a new character is add in game, this part
        // need be modified.
        EntityTypeInterface type = player.getType();
        EntityConfig baseConfig = type.getBaseConfig();
        String parent_path = baseConfig.getPath();
        ChargeType chargeType = new ChargeType(new ChargeConfig(parent_path), EntityType.CHARGE);
        float duration = 0.3f;
        if (type.getType() == EntityType.FIRE_WIZARD) {
            while (count-- > 0) {
                throwableObjects
                        .add(new ThrowableObject(chargeType, player, 32, 32, duration, baseConfig.getChargeCol(),
                                baseConfig.getChargeRow()));
            }

            return;
        } else {
            // To developer.
            System.out.println("Tipo não reconhecido");
        }
    }




    
}
