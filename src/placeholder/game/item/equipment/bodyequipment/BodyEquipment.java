/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.item.equipment.bodyequipment;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.game.item.equipment.Equipment;
import placeholder.game.item.equipment.headequipment.HeadEquipment;
import placeholder.game.screen.animation.EquipmentAnimation;
import placeholder.game.sprite.entity.bodypart.BodyBodyPart;
import placeholder.game.sprite.entity.player.Player;

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
    
    @Override
    protected Class getRequiredEquipmentClass() {
        return BodyEquipment.class;
    }
    
    
    
}
