/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.item.equipment.weaponequipment.melee.tool.mining;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.Map;
import javafx.scene.image.Image;

/**
 *
 * @author jdolf
 */
public abstract class Pickaxe extends MiningTool {
    
    public Pickaxe(Point position, Image icon, Image animationImage, Dimension hitbox) {
        super(position, icon, animationImage, hitbox);
    }
    
}
