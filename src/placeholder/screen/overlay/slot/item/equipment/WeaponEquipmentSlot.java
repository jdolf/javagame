/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay.slot.item.equipment;

import placeholder.item.equipment.weaponequipment.WeaponEquipment;
import placeholder.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.sprite.entity.Entity;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class WeaponEquipmentSlot extends EquipmentSlot<WeaponEquipment> {

    public WeaponEquipmentSlot(ContextMenuManager cm, Player player) {
        super(cm, WeaponEquipment.class, player);
    }
    
}
