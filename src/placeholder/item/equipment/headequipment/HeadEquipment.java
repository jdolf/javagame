/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.item.equipment.headequipment;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.item.equipment.Equipment;
import placeholder.screen.animation.EquipmentAnimation;
import placeholder.sprite.entity.bodypart.HeadBodyPart;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public abstract class HeadEquipment extends Equipment {

    public HeadEquipment(Point position, Image icon, Image animationImage) {
        super(position, icon, animationImage, new EquipmentAnimation());
    }

    @Override
    protected Class getBodyPartClass() {
        return HeadBodyPart.class;
    }

    @Override
    protected Dimension calculateDimension() {
        return Player.DEFAULT_HEAD_DIMENSION;
    }

    @Override
    protected Class getRequiredEquipmentClass() {
        return HeadEquipment.class;
    }
    
    
    
    
    
}
