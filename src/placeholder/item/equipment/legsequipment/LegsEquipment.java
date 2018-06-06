/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.item.equipment.legsequipment;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.item.equipment.Equipment;
import placeholder.screen.animation.EquipmentAnimation;
import placeholder.sprite.entity.bodypart.LegsBodyPart;
import placeholder.sprite.entity.player.Player;

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
    
}