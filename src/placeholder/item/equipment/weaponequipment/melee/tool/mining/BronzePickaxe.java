/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.item.equipment.weaponequipment.melee.tool.mining;

import java.awt.Dimension;
import java.awt.Point;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class BronzePickaxe extends Pickaxe {
    
    public static final Dimension HITBOX = new Dimension(30, 30);
    public static final String ICON_NAME = "bronze_pickaxe_icon.png";
    public static final String ANIMATION_NAME = "bronze_helmet.png";

    public BronzePickaxe(Point position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME),
                HITBOX);
        
        this.meleeStrength = 2;
        this.cooldown = 60;
        this.efficiency = 5;
    }


    
}
