/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.map;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import placeholder.screen.TickUpdatable;
import placeholder.screen.render.Renderable;
import placeholder.screen.render.Renderer;
import placeholder.sprite.collision.DefaultCollisionDetector;
import placeholder.sprite.DefaultSpriteReceiver;
import placeholder.sprite.Sprite;
import placeholder.sprite.SpriteReceiver;
import placeholder.sprite.entity.Entity;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public abstract class Map implements Renderable, TickUpdatable {
    
    public static final Point2D DEFAULT_START_LOCATION = new Point2D.Double(20, 20);
    // Additional sprite lists used to circumvent ConcurrentModificationException
    private List<Sprite> spritesToAdd = new ArrayList();
    private List<Sprite> spritesToDelete = new ArrayList();
    private List<Sprite> sprites = new ArrayList();
    protected SpriteReceiver spriteReceiver = new DefaultSpriteReceiver(this);
    protected MapCode mapCode;
    
    public Map(MapCode mapCode) {
        this.sprites = createSprites();
        this.mapCode = mapCode;
        enrichSprites();
    }
    
    @Override
    public void tickUpdate() {
        for (int i = 0; i < spritesToAdd.size(); i++) {
            sprites.add(spritesToAdd.remove(i));
        }
        for (int i = 0; i < spritesToDelete.size(); i++) {
            sprites.remove(spritesToDelete.remove(i));
        }

        for (Sprite sprite : sprites) {
            sprite.tickUpdate();
        }
    }

    @Override
    public void render(Renderer renderer) {
        for (Sprite sprite : sprites) {
            sprite.render(renderer);
        }
    }

    public List<Sprite> getSprites() {
        return this.sprites;
    }
    
    protected abstract List<Sprite> createSprites();

    public void addSprite(Sprite sprite) {
        spritesToAdd.add(sprite);
    }
    
    public void removeSprite(Sprite sprite) {
        spritesToDelete.add(sprite);
    }

    public boolean matchesMapCode(MapCode testMapCode) {
        return testMapCode.equals(this.mapCode);
    }

    public final void enrichPlayer(Player player) {
        player.setCollisionDetector(new DefaultCollisionDetector(player, spriteReceiver));
        player.setPosition(DEFAULT_START_LOCATION);
        player.setMap(this);
    }
    
    private final void enrichSprites() {
        for (Sprite sprite : sprites) {
            if (sprite instanceof Entity) {
                ((Entity) sprite).setMap(this);
            }
        }
    }
    
    public SpriteReceiver getSpriteReceiver() {
        return this.spriteReceiver;
    }
    
    
}
