/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.util;

import java.util.List;
import placeholder.game.screen.render.Renderable;
import placeholder.game.screen.render.Renderer;
import placeholder.game.item.equipment.EquipmentManager;
import placeholder.game.item.equipment.PlayerEquipmentManager;

/**
 *
 * @author jdolf
 */
public interface Container<T, T2> extends Renderable {
    void sort();
    List<T2> getItems();
    void render(Renderer renderer, EquipmentManager em);
    void update();
}
