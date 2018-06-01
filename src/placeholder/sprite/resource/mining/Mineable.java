/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite.resource.mining;

import placeholder.item.equipment.weaponequipment.melee.tool.mining.MiningTool;
import placeholder.sprite.entity.player.inventory.Inventory;



/**
 *
 * @author jdolf
 */
public interface Mineable {
    public void mine(int playerLevel, MiningTool md, Inventory inventory);
}
