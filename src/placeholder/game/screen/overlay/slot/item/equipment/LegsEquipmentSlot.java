/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.slot.item.equipment;

import placeholder.game.item.equipment.legsequipment.LegsEquipment;
import placeholder.game.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.game.sprite.entity.Entity;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class LegsEquipmentSlot extends EquipmentSlot {

    public LegsEquipmentSlot(ContextMenuManager cm, Player player) {
        super(cm, LegsEquipment.class, player);
    }
    
}
