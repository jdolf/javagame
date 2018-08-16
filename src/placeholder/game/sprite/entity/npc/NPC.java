package placeholder.game.sprite.entity.npc;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.screen.animation.EntityAnimation;
import placeholder.game.screen.overlay.window.dialog.DialogWindow;
import placeholder.game.screen.render.Renderer;
import placeholder.game.sprite.ImageSprite;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.collision.Interactable;
import placeholder.game.sprite.entity.AnimatedEntity;
import placeholder.game.sprite.entity.Entity;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public abstract class NPC extends ImageSprite implements Interactable {
    
    protected String name = "Unknown";

    public NPC(Dimension dimension, Point location, Image image) {
        super(dimension, location, image);
    }

    
    
    
}
