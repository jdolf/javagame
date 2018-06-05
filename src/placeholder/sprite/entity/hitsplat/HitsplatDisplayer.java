package placeholder.sprite.entity.hitsplat;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import placeholder.screen.TickUpdatable;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.render.Renderable;
import placeholder.screen.render.Renderer;
import placeholder.sprite.entity.Health;
import placeholder.sprite.entity.HealthChangedListener;
import placeholder.sprite.entity.attack.Hittable;
import placeholder.util.Unregisterable;

/**
 *
 * @author jdolf
 */
public class HitsplatDisplayer implements HealthChangedListener, Renderable, TickUpdatable, Unregisterable<Hitsplat> {
    
    private Health health;
    private ScreenItem parent;
    private Collection<Hitsplat> hitsplats = new ArrayList();
    private Collection<Hitsplat> hitsplatsToRemove = new ArrayList();
    
    public HitsplatDisplayer(Health health, ScreenItem parent) {
        this.parent = parent;
        this.health = health;
        health.addHealthChangedListener(this);
    }

    @Override
    public void onHealthChanged(int amount) {
        int newDimensionWidth = parent.getDimension().width / 2;
        int newDimensionHeight = parent.getDimension().height;
        int newPositionX = parent.getPosition().x;
        int newPositionY = parent.getPosition().y - parent.getDimension().height;
        hitsplats.add(new Hitsplat(
                this,
                ScreenItem.merge(new Dimension(newDimensionWidth, newDimensionHeight), new Point(newPositionX, newPositionY)),
                amount)
        );
    }

    @Override
    public void render(Renderer renderer) {
        hitsplats.forEach((hitsplat) -> {
            hitsplat.render(renderer);
        });
    }

    @Override
    public void tickUpdate() {
        hitsplats.forEach((hitsplat) -> {
            hitsplat.tickUpdate();
        });
        hitsplats.removeAll(hitsplatsToRemove);
    }

    @Override
    public void unregister(Hitsplat object) {
        hitsplatsToRemove.add(object);
    }
    
    
    
}
