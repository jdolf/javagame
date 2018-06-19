package placeholder.screen.particle;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Random;
import javafx.scene.image.Image;
import placeholder.map.Map;
import placeholder.screen.TickUpdatable;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.render.Renderable;
import placeholder.screen.render.Renderer;

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
    
    public Particle(Point2D initLocation, Dimension dimension, Image image, Map map) {
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
        if (duration <= 0) map.removeParticle(this);
        
        this.getPosition().setLocation(ScreenItem.mergePoints(this.getPosition(), new Point2D.Double(velocityX, velocityY)));
        duration--;
    }
    
}
