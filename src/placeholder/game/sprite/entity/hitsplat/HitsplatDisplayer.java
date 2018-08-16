package placeholder.game.sprite.entity.hitsplat;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.ArrayList;
import java.util.Collection;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.render.Renderable;
import placeholder.game.screen.render.Renderer;
import placeholder.game.sprite.entity.Health;
import placeholder.game.sprite.entity.HealthChangedListener;
import placeholder.game.sprite.entity.attack.Hittable;
import placeholder.game.util.Unregisterable;

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
        double newPositionX = parent.getPosition().getX();
        double newPositionY = parent.getPosition().getY() - parent.getDimension().height;
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
        hitsplatsToRemove.clear();
    }

    @Override
    public void unregister(Hitsplat object) {
        hitsplatsToRemove.add(object);
    }
    
    
    
}
