package placeholder.screen.overlay.contextmenu.entry;

import placeholder.item.equipment.Equipment;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class UnequipEntry extends ContextMenuEntry {
    
    public static final String DISPLAY_NAME = "Unequip";
    private Equipment equipment;
    private Player player;

    public UnequipEntry(Player player, Equipment equipment) {
        super(DISPLAY_NAME);
        this.equipment = equipment;
        this.player = player;
    }

    @Override
    public void execute() {
        player.getPlayerEquipmentManager().tryUnequip(equipment);
    }
    
}
