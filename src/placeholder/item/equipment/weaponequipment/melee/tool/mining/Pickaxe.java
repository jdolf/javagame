/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.item.equipment.weaponequipment.melee.tool.mining;

import java.awt.Dimension;
import java.awt.Point;
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
