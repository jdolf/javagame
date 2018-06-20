/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.contextmenu.entry;

import placeholder.game.item.equipment.Equipment;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class EquipEntry extends ContextMenuEntry {
    
    public static final String DISPLAY_NAME = "Equip";
    private Equipment equipment;
    private Player player;
    
    public EquipEntry(Player player, Equipment equipment) {
        super(DISPLAY_NAME);
        this.equipment = equipment;
        this.player = player;
    }

    @Override
    public void execute() {
        player.getPlayerEquipmentManager().tryEquip(equipment);
    }
    
}
