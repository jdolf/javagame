/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay.slot.item.equipment;

import placeholder.item.equipment.legsequipment.LegsEquipment;
import placeholder.sprite.entity.Entity;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class LegsEquipmentSlot extends EquipmentSlot {

    public LegsEquipmentSlot(Player player) {
        super(LegsEquipment.class, player);
    }

    @Override
    public void executeCommand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
