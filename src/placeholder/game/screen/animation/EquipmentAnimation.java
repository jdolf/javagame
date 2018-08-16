/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.animation;

import placeholder.game.util.Dimension;
import java.util.concurrent.atomic.AtomicReference;
import javafx.scene.image.Image;
import placeholder.game.item.equipment.Equipment;
import placeholder.game.sprite.entity.Entity;

/**
 *
 * @author jdolf
 */
public class EquipmentAnimation<T extends Equipment> extends DirectionAnimation<Entity> {
    
    protected T equipment;
    
    public EquipmentAnimation() {}
    
    public EquipmentAnimation(Entity Entity, Image image, Dimension dimension, T equipment) {
        super(Entity, Entity, image, dimension);
        this.equipment = equipment;
    }

    @Override
    public int calculateColumn() {
        return 0;
    }

    public T getEquipment() {
        return equipment;
    }

    public void setEquipment(T equipment) {
        this.equipment = equipment;
    }

    @Override
    public void setData(Entity data) {
        super.setData(data);
        this.directionDependent = data;
    }
    
    
    
    
    
}
