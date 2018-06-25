/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.item.equipment.weaponequipment.melee.tool.mining;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class SteelPickaxe extends Pickaxe {
    
    public static final Dimension HITBOX = new Dimension(24, 24);
    public static final String ICON_NAME = "steel_pickaxe_icon.png";
    public static final String ANIMATION_NAME = "steel_pickaxe.png";

    public SteelPickaxe(Point2D position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME),
                HITBOX);
        
        this.meleeStrength = 6;
        this.cooldown = 53;
        this.miningEfficiency = 11;
        this.displayName = "Steel Pickaxe";
    }


    
}
