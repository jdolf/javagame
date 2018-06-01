/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.item.equipment.weaponequipment.melee.tool;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.item.equipment.weaponequipment.WeaponEquipment;
import placeholder.item.equipment.weaponequipment.melee.MeleeWeapon;

/**
 *
 * @author jdolf
 */
public abstract class Tool extends MeleeWeapon {

    protected int efficiency = 30;
    
    public Tool(Point position, Image icon, Image animationImage, Dimension hitbox) {
        super(position, icon, animationImage, hitbox);
    }
    
    public void use() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
