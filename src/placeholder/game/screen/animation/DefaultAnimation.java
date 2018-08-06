/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.animation;

import java.awt.Dimension;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

/**
 *
 * @author jdolf
 * @param <T>
 */
public abstract class DefaultAnimation<T> implements Animation<T> {

    protected Image image;
    protected Dimension dimension;
    /**
     * Current column using 0-index
     */
    protected int currentColumn = 0;
    /**
     * Current Row using 0-index
     */
    protected int currentRow = 0;
    protected int animationProgress;
    protected T data;

    public DefaultAnimation() {}
    
    public DefaultAnimation(T data, Image image, Dimension dimension) {
        this.data = data;
        this.image = image;
        this.dimension = dimension;
    }
    
    public DefaultAnimation(Image image, Dimension dimension) {
        this.image = image;
        this.dimension = dimension;
    }

    @Override
    public void update() {
        this.animationProgress += 1;
        // TODO: animationProgress limit
        this.currentColumn = calculateColumn();
        this.currentRow = calculateRow();
    }

    @Override
    public double getSourceHeight() {
        return this.dimension.getHeight();
    }

    @Override
    public double getSourceWidth() {
        return this.dimension.getWidth();
    }

    @Override
    public double getSourceY() {
        return currentRow * this.dimension.getHeight();
    }

    @Override
    public double getSourceX() {
        return currentColumn * this.dimension.getWidth();
    }

    @Override
    public abstract int calculateColumn();

    @Override
    public abstract int calculateRow();

    public void setImage(Image image) {
        this.image = image;
    }
    
    public Image getImage() {
        return this.image;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public Image createPreviewImage() {
        PixelReader reader = image.getPixelReader();
        return new WritableImage(reader, 0, 0, (int)dimension.getWidth(), (int)dimension.getHeight());
    }

}
