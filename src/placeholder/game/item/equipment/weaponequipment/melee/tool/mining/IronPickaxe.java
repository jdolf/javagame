/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.item.equipment.weaponequipment.melee.tool.mining;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class IronPickaxe extends Pickaxe {
    
    public static final Dimension HITBOX = new Dimension(22, 22);
    public static final String ICON_NAME = "iron_pickaxe_icon.png";
    public static final String ANIMATION_NAME = "iron_pickaxe.png";

    public IronPickaxe(Point position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME),
                HITBOX);
        
        this.meleeStrength = 4;
        this.cooldown = 55;
        this.miningEfficiency = 8;
        this.displayName = "Iron Pickaxe";
    }


    
}
