/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay.slot.item.equipment;

import placeholder.item.equipment.headequipment.HeadEquipment;
import placeholder.sprite.entity.Entity;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class HeadEquipmentSlot extends EquipmentSlot {

    public HeadEquipmentSlot(Player player) {
        super(HeadEquipment.class, player);
    }
    
    @Override
    public void executeCommand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
