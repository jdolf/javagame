/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.item.equipment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import placeholder.item.equipment.headequipment.HeadEquipment;
import placeholder.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.screen.overlay.slot.item.equipment.BodyEquipmentSlot;
import placeholder.screen.overlay.slot.item.equipment.EquipmentSlot;
import placeholder.screen.overlay.slot.item.equipment.HeadEquipmentSlot;
import placeholder.screen.overlay.slot.item.equipment.LegsEquipmentSlot;
import placeholder.screen.overlay.slot.item.equipment.ShieldEquipmentSlot;
import placeholder.screen.overlay.slot.item.equipment.WeaponEquipmentSlot;
import placeholder.sprite.entity.Entity;
import placeholder.sprite.entity.player.Player;
import placeholder.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public class PlayerEquipmentManager extends EquipmentManager<Player> {
    
    private HeadEquipmentSlot headEquipmentSlot;
    private BodyEquipmentSlot bodyEquipmentSlot;
    private LegsEquipmentSlot legsEquipmentSlot;
    private WeaponEquipmentSlot weaponEquipmentSlot;
    private ShieldEquipmentSlot shieldEquipmentSlot;
    
    public PlayerEquipmentManager(ContextMenuManager cm, Player player) {
        super(player);
        headEquipmentSlot = new HeadEquipmentSlot(cm, player);
        bodyEquipmentSlot = new BodyEquipmentSlot(cm, player);
        legsEquipmentSlot = new LegsEquipmentSlot(cm, player);
        weaponEquipmentSlot = new WeaponEquipmentSlot(cm, player);
        shieldEquipmentSlot = new ShieldEquipmentSlot(cm, player);
        equipmentSlots.add(headEquipmentSlot);
        equipmentSlots.add(bodyEquipmentSlot);
        equipmentSlots.add(legsEquipmentSlot);
        equipmentSlots.add(weaponEquipmentSlot);
        equipmentSlots.add(shieldEquipmentSlot);
    }

    /**
     * Manage inventory of a player in case an item gets equipped
     * @param targetEquipment 
     */
    public void tryEquip(Equipment targetEquipment) {
        EquipmentSlot slot = getEquipmentSlot(targetEquipment.getClass());
        Inventory inventory = targetEquipment.getInventory();
        
        if (!slot.isEmpty()) {
            Equipment removedSlotEquipment = slot.getItem();
            super.equip(targetEquipment, slot);
            inventory.removeItem(targetEquipment);
            inventory.insertItem(removedSlotEquipment);
        } else {
            super.equip(targetEquipment, slot);
            inventory.removeItem(targetEquipment);
        }
    }
    
    public void tryUnequip(Equipment targetEquipment) {
        EquipmentSlot slot = getEquipmentSlot(targetEquipment.getClass());
        Inventory inventory = targetEquipment.getInventory();
        
        if (!slot.isEmpty() && !inventory.isFull()) {
            Equipment removedSlotEquipment = slot.getItem();
            super.unequip(targetEquipment);
            inventory.insertItem(removedSlotEquipment);
        }
    }

    public HeadEquipmentSlot getHeadEquipmentSlot() {
        return headEquipmentSlot;
    }

    public BodyEquipmentSlot getBodyEquipmentSlot() {
        return bodyEquipmentSlot;
    }

    public LegsEquipmentSlot getLegsEquipmentSlot() {
        return legsEquipmentSlot;
    }

    public WeaponEquipmentSlot getWeaponEquipmentSlot() {
        return weaponEquipmentSlot;
    }

    public ShieldEquipmentSlot getShieldEquipmentSlot() {
        return shieldEquipmentSlot;
    }
    
    
    
    
    
}
