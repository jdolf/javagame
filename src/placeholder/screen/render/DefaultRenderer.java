/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.render;

import java.awt.Dimension;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import placeholder.screen.animation.Animation;
import placeholder.screen.overlay.ScreenItem;

/**
 *
 * @author jdolf
 */
public class DefaultRenderer implements Renderer {

    protected GraphicsContext gc;
    protected Dimension gameDimension;
    
    public DefaultRenderer(GraphicsContext gc, Dimension gameDimension) {
        this.gc = gc;
        this.gameDimension = gameDimension;
    }

    @Override
    public void clear() {
        // Clear Image
        gc.clearRect(0, 0, gameDimension.width, gameDimension.height);
    }
    
    /**
     * JavaFx Canvas allows for double coordinates. These appear blurry if the end
     * product is not an integer. This method makes it an integer.
     * @param coord
     * @return 
     */
    private double sharpen(double coord) {
        return (int) coord;
    }

    @Override
    public void renderAnimation(Animation animation, ScreenItem screenItem) {
        gc.drawImage(
                animation.getImage(),
                animation.getSourceX(),
                animation.getSourceY(),
                animation.getSourceWidth(),
                animation.getSourceHeight(),
                sharpen(screenItem.getPosition().getX()),
                sharpen(screenItem.getPosition().getY()),
                screenItem.getDimension().width,
                screenItem.getDimension().height
        );
    }

    @Override
    public void renderImage(Image image, ScreenItem screenItem) {
        gc.drawImage(
            image,
            sharpen(screenItem.getPosition().getX()),
            sharpen(screenItem.getPosition().getY()),
            screenItem.getDimension().width,
            screenItem.getDimension().height
        );
        
    }

    @Override
    public void renderRect(Paint paint, ScreenItem screenItem) {
        gc.setFill(paint);
        gc.fillRect(
                sharpen(screenItem.getPosition().getX()),
                sharpen(screenItem.getPosition().getY()),
                screenItem.getDimension().width,
                screenItem.getDimension().height
        );
    }
    
    @Override
    public void renderRectStroke(Paint paint, int lineWidth, ScreenItem screenItem) {
        gc.setStroke(paint);
        gc.setLineWidth(lineWidth);
        gc.strokeRect(
                sharpen(screenItem.getPosition().getX()),
                sharpen(screenItem.getPosition().getY()),
                screenItem.getDimension().width,
                screenItem.getDimension().height
        );
    }

    @Override
    public void renderText(Paint paint, Font font, String text, ScreenItem screenItem, TextAlignment ta) {
        double height = screenItem.getPosition().getY();
        gc.setFont(font);
        gc.setFill(paint);
        gc.setTextAlign(ta);
        gc.fillText(
                text,
                sharpen(screenItem.getPosition().getX()),
                height + gc.getFont().getSize()
        );
    }

    @Override
    public void renderRoundRect(Paint paint, Dimension arcDimension, ScreenItem screenItem) {
        gc.setFill(paint);
        gc.fillRoundRect(
                sharpen(screenItem.getPosition().getX()),
                sharpen(screenItem.getPosition().getY()),
                screenItem.getDimension().width,
                screenItem.getDimension().height,
                arcDimension.width,
                arcDimension.height
        );
    }

    @Override
    public void renderRoundRectStroke(Paint paint, int lineWidth, Dimension arcDimension, ScreenItem screenItem) {
        gc.setStroke(paint);
        gc.setLineWidth(lineWidth);
        gc.strokeRoundRect(
                sharpen(screenItem.getPosition().getX()),
                sharpen(screenItem.getPosition().getY()),
                screenItem.getDimension().width,
                screenItem.getDimension().height,
                arcDimension.width,
                arcDimension.height
        );
    }
    
    
}
