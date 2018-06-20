/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.sprite.entity.bodypart;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import placeholder.game.screen.render.Renderer;
import placeholder.game.item.equipment.Equipment;
import placeholder.game.item.equipment.EquipmentManager;
import placeholder.game.sprite.entity.Entity;
import placeholder.game.util.Container;

/**
 *
 * @author jdolf
 */
public class BodyPartContainer implements Container<Entity, BodyPart> {
    
    Entity Entity;
    List<BodyPart> bodyParts;
    
    public BodyPartContainer(List<BodyPart> bodyParts, Entity Entity) {
        this.bodyParts = bodyParts;
        this.Entity = Entity;
    }

    @Override
    public void sort() {
        Collections.sort(bodyParts, new Comparator<BodyPart>() {
            @Override
            public int compare(BodyPart o1, BodyPart o2) {
                return Integer.compare(o1.getZIndex(), o2.getZIndex());
            }
        });
    }

    @Override
    public void render(Renderer renderer) {
        for (BodyPart bodyPart : bodyParts) {
            bodyPart.render(renderer);
        }
    }

    @Override
    public List<BodyPart> getItems() {
        return this.bodyParts;
    }

    @Override
    public void render(Renderer renderer, EquipmentManager em) {
        for (BodyPart bodyPart : bodyParts) {
            bodyPart.render(renderer);
            Collection<Equipment> collection = em.getWornEquipment();
            for (Equipment equipment : collection) {
                if (equipment.isMadeFor(bodyPart.getClass())) {
                    equipment.render(renderer, bodyPart);
                }
            }
        }
    }

    private void updateBodyParts() {
        for (BodyPart bodyPart : bodyParts) {
            bodyPart.update();
        }
    }

    @Override
    public void update() {
        updateBodyParts();
        sort();
    }
}
