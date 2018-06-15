/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.item.equipment.weaponequipment.melee.tool;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.item.equipment.weaponequipment.WeaponEquipment;
import placeholder.item.equipment.weaponequipment.melee.MeleeWeapon;
import placeholder.sprite.collision.CollisionDetector;
import placeholder.sprite.collision.DefaultCollisionDetector;
import placeholder.sprite.collision.ResourceInteraction;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public abstract class Tool extends MeleeWeapon {
    
    public Tool(Point2D position, Image icon, Image animationImage, Dimension hitbox) {
        super(position, icon, animationImage, hitbox);
    }

    @Override
    public void attack() {
        if (!createResourceInteraction().hasSuccess()) {
            super.attack();
        }
    }
    
    protected abstract ResourceInteraction createResourceInteraction();
}
