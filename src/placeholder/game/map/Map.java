/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.map;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javafx.scene.image.Image;
import placeholder.game.item.Item;
import placeholder.game.item.ItemReceiver;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.particle.Particle;
import placeholder.game.screen.render.Renderable;
import placeholder.game.screen.render.Renderer;
import placeholder.game.sprite.collision.DefaultCollisionDetector;
import placeholder.game.sprite.Receiver;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.SpriteReceiver;
import placeholder.game.sprite.entity.Entity;
import placeholder.game.sprite.entity.attack.Attack;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public abstract class Map implements Renderable, TickUpdatable {
    
    public static final Point DEFAULT_START_LOCATION = new Point(300, 250);
    // Additional sprite lists used to circumvent ConcurrentModificationException
    private List<Sprite> spritesToAdd = new ArrayList();
    private List<Sprite> spritesToDelete = new ArrayList();
    private List<Sprite> sprites = new ArrayList();
    private List<Item> items = new ArrayList();
    private List<Item> itemsToDelete = new ArrayList();
    private List<Item> itemsToAdd = new ArrayList();
    private List<Particle> particles = new ArrayList();
    private List<Particle> particlesToAdd = new ArrayList();
    private List<Particle> particlesToDelete = new ArrayList();
    private List<Attack> attacks = new ArrayList();
    private List<Attack> attacksToAdd = new ArrayList();
    private List<Attack> attacksToDelete = new ArrayList();
    protected SpriteReceiver spriteReceiver = new SpriteReceiver(this);
    protected ItemReceiver itemReceiver = new ItemReceiver(this);
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
        
        sprites.forEach((sprite) -> {
            sprite.tickUpdate();
        });
        
        particles.forEach((particle) -> {
            particle.tickUpdate();
        });
        
        attacks.forEach((attack) -> {
            attack.tickUpdate();
        });
        
        items.removeAll(itemsToDelete);
        itemsToDelete.clear();
        items.addAll(itemsToAdd);
        itemsToAdd.clear();
        particles.addAll(particlesToAdd);
        particlesToAdd.clear();
        particles.removeAll(particlesToDelete);
        particlesToDelete.clear();
        attacks.removeAll(attacksToDelete);
        attacksToDelete.clear();
        attacks.addAll(attacksToAdd);
        attacksToAdd.clear();
    }

    @Override
    public void render(Renderer renderer) {
        
        for (Sprite sprite : sprites) {
            sprite.render(renderer);
        }
        
        items.forEach((item) -> {
            item.render(renderer);
        });
        
        particles.forEach((particle) -> {
            particle.render(renderer);
        });
    }

    public List<Sprite> getSprites() {
        return this.sprites;
    }
    
    public List<Item> getItems() {
        return this.items;
    }
    
    protected abstract List<Sprite> createSprites();

    public void addSprite(Sprite sprite) {
        spritesToAdd.add(sprite);
    }
    
    public void removeSprite(Sprite sprite) {
        spritesToDelete.add(sprite);
    }
    
    public void addItem(Item item) {
        itemsToAdd.add(item);
    }
    
    public void removeItem(Item item) {
        itemsToDelete.add(item);
    }
    
    public void addParticle(Particle particle) {
        particlesToAdd.add(particle);
    }
    
    public void removeParticle(Particle particle) {
        particlesToDelete.add(particle);
    }
    
    public void addAttack(Attack attack) {
        attacksToAdd.add(attack);
    }
    
    public void removeAttack(Attack attack) {
        attacksToDelete.add(attack);
    }

    public boolean matchesMapCode(MapCode testMapCode) {
        return testMapCode.equals(this.mapCode);
    }

    public final void enrichPlayer(Player player) {
        player.setCollisionDetector(new DefaultCollisionDetector(player, this));
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
    
    public ItemReceiver getItemReceiver() {
        return this.itemReceiver;
    }
    
    
}
