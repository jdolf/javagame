/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.slot.item.equipment;

import placeholder.game.item.equipment.headequipment.HeadEquipment;
import placeholder.game.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.game.sprite.entity.Entity;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class HeadEquipmentSlot extends EquipmentSlot {

    public HeadEquipmentSlot(ContextMenuManager cm, Player player) {
        super(cm, HeadEquipment.class, player);
    }

    
    
}
