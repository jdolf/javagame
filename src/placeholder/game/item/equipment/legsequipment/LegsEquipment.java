/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.item.equipment.legsequipment;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.game.item.equipment.Equipment;
import placeholder.game.item.equipment.headequipment.HeadEquipment;
import placeholder.game.screen.animation.EquipmentAnimation;
import placeholder.game.sprite.entity.bodypart.LegsBodyPart;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public abstract class LegsEquipment extends Equipment {

    public LegsEquipment(Point position, Image icon, Image animationImage) {
        super(position, icon, animationImage, new EquipmentAnimation());
    }
    
    @Override
    protected Dimension calculateDimension() {
        return Player.DEFAULT_LEGS_DIMENSION;
    }

    @Override
    protected Class getBodyPartClass() {
        return LegsBodyPart.class;
    }
    
    @Override
    protected Class getRequiredEquipmentClass() {
        return LegsEquipment.class;
    }
    
}
