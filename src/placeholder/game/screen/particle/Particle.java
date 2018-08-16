package placeholder.game.screen.particle;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.Random;
import javafx.scene.image.Image;
import placeholder.game.map.Map;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.render.Renderable;
import placeholder.game.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public abstract class Particle extends ScreenItem implements Renderable, TickUpdatable {
    
    private Map map;
    private int duration = 40;
    private double velocityX = 0;
    private double velocityY = 0;
    private Random random = new Random();
    private Image image;
    
    public Particle(Point initLocation, Dimension dimension, Image image, Map map) {
        super(initLocation, dimension);
        int degrees = random.nextInt(361);
        velocityX = Math.cos(degrees);
        velocityY = Math.sin(degrees);
        this.map = map;
        this.image = image;
    }

    @Override
    public void render(Renderer renderer) {
        renderer.renderImage(image, this);
    }

    @Override
    public void tickUpdate() {
        if (duration <= 0) {
            map.removeParticle(this);
        }
        
        this.getPosition().setLocation(ScreenItem.mergePoints(this.getPosition(), new Point(velocityX, velocityY)));
        duration--;
    }
    
}
