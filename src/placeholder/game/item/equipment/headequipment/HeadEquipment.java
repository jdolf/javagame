/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.item.equipment.headequipment;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.game.item.equipment.Equipment;
import placeholder.game.screen.animation.EquipmentAnimation;
import placeholder.game.sprite.entity.bodypart.HeadBodyPart;
import placeholder.game.sprite.entity.player.Player;

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
