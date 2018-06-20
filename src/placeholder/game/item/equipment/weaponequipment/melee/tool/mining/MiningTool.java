/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.item.equipment.weaponequipment.melee.tool.mining;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.game.item.equipment.weaponequipment.melee.tool.Tool;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.SpriteReceiver;
import placeholder.game.sprite.collision.MiningInteraction;
import placeholder.game.sprite.collision.ResourceInteraction;
import placeholder.game.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public abstract class MiningTool extends Tool {

    public MiningTool(Point2D position, Image icon, Image animationImage, Dimension hitbox) {
        super(position, icon, animationImage, hitbox);
    }

    @Override
    protected ResourceInteraction createResourceInteraction() {
        return new MiningInteraction(player, this, Arrays.asList(player));
    }
    
    
}
