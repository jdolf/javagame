/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.item.equipment.bodyequipment;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.item.equipment.Equipment;
import placeholder.screen.animation.EquipmentAnimation;
import placeholder.sprite.entity.bodypart.BodyBodyPart;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public abstract class BodyEquipment extends Equipment {

    public BodyEquipment(Point position, Image icon, Image animationImage) {
        super(position, icon, animationImage, new EquipmentAnimation());
    }

    @Override
    protected Dimension calculateDimension() {
        return Player.DEFAULT_BODY_DIMENSION;
    }

    @Override
    protected Class getBodyPartClass() {
        return BodyBodyPart.class;
    }
    
    
    
}