/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.item.equipment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.overlay.slot.item.equipment.EquipmentSlot;
import placeholder.game.sprite.entity.Entity;
import placeholder.game.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public abstract class EquipmentManager<T extends Entity> implements TickUpdatable {
    
    private T target;
    protected List<EquipmentSlot> equipmentSlots = new ArrayList();
    private List<EquipmentChangedListener> listener = new ArrayList();
    
    
    public EquipmentManager(T target) {
        this.target = target;
    }
    
    protected void equip(Equipment targetEquipment, EquipmentSlot slot) {
        slot.setItem(targetEquipment);
        notifyEquipmentChangedListeners();
    }
    
    public void tickUpdate() {
        for (EquipmentSlot slot : equipmentSlots) {
            if (!slot.isEmpty()) {
                slot.tickUpdate();
            }
        }
    }
    
    public List<Equipment> getWornEquipment() {
        List<Equipment> list = new ArrayList();

        for (EquipmentSlot slot : equipmentSlots) {
            if (!slot.isEmpty()) {
                list.add(slot.getItem());
            }
        }
        
        return list;
    }
    
    protected void unequip(Equipment equipment) {
        EquipmentSlot slot = getEquipmentSlot(equipment.getClass());
        slot.removeItem();
        notifyEquipmentChangedListeners();
    }
    
    public EquipmentSlot getEquipmentSlot(Class<? extends Equipment> equipmentClass) {
        Class requiredSuperClass;
        Class targetClass = equipmentClass;
        
        for (EquipmentSlot slot : equipmentSlots) {
            requiredSuperClass = slot.getRequiredEquipmentClass();
            if (requiredSuperClass.isAssignableFrom(targetClass)) {
                return slot;
            }
        }
        
        throw new IllegalArgumentException("EquipmentClass not found!");
    }
    
    public void addEquipmentChangedListener(EquipmentChangedListener listener) {
        this.listener.add(listener);
    }
    
    public void notifyEquipmentChangedListeners() {
        this.listener.forEach((listener) -> {
            listener.onEquipmentChanged();
        });
    }
    
    public int calculateMeleeStrengthImpact() {
        return calculateImpact(Equipment::getMeleeStrength);
    }
    
    public int calculateMeleeDefenseImpact() {
        return calculateImpact(Equipment::getMeleeDefense);
    }
    
    public int calculateRangeStrengthImpact() {
        return calculateImpact(Equipment::getRangeStrength);
    }
    
    public int calculateRangeDefenseImpact() {
        return calculateImpact(Equipment::getRangeDefense);
    }
    
    public int calculateMagicStrengthImpact() {
        return calculateImpact(Equipment::getMagicStrength);
    }
    
    public int calculateSpeedPercentage() {
        return calculateImpact(Equipment::getSpeedPercentage);
    }
    
    public int calculateCooldownPercentage() {
        return calculateImpact(Equipment::getCooldownPercentage);
    }
    
    public int calculateMagicDefenseImpact() {
        return calculateImpact(Equipment::getMagicDefense);
    }
    
    public int calculateMiningEfficiencyImpact() {
        return calculateImpact(Equipment::getMiningEfficiency);
    }
    
    public int calculateWoodcuttingEfficiencyImpact() {
        return calculateImpact(Equipment::getWoodcuttingEfficiency);
    }
    
    private int calculateImpact(Function<Equipment, Integer> fx) {
        Integer value = 0;
        for (EquipmentSlot equipmentSlot : equipmentSlots) {
            if (!equipmentSlot.isEmpty()) {
                value += fx.apply(equipmentSlot.getItem());
            }
        }
        return value.intValue();
    }

    public List<EquipmentSlot> getEquipmentSlots() {
        return equipmentSlots;
    }
    
    
}
