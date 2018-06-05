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

    @Override
    public void renderAnimation(Animation animation, ScreenItem screenItem) {
        gc.drawImage(
                animation.getImage(),
                animation.getSourceX(),
                animation.getSourceY(),
                animation.getSourceWidth(),
                animation.getSourceHeight(),
                screenItem.getPosition().x,
                screenItem.getPosition().y,
                screenItem.getDimension().width,
                screenItem.getDimension().height
        );
    }

    @Override
    public void renderImage(Image image, ScreenItem screenItem) {
        gc.drawImage(
            image,
            screenItem.getPosition().x,
            screenItem.getPosition().y,
            screenItem.getDimension().width,
            screenItem.getDimension().height
        );
        
    }

    @Override
    public void renderRect(Paint paint, ScreenItem screenItem) {
        gc.setFill(paint);
        gc.fillRect(
                screenItem.getPosition().x,
                screenItem.getPosition().y,
                screenItem.getDimension().width,
                screenItem.getDimension().height
        );
    }
    
    @Override
    public void renderRectStroke(Paint paint, int lineWidth, ScreenItem screenItem) {
        gc.setStroke(paint);
        gc.setLineWidth(lineWidth);
        gc.strokeRect(
                screenItem.getPosition().x,
                screenItem.getPosition().y,
                screenItem.getDimension().width,
                screenItem.getDimension().height
        );
    }

    @Override
    public void renderText(Paint paint, Font font, String text, ScreenItem screenItem, TextAlignment ta) {
        int height = screenItem.getPosition().y;
        gc.setFont(font);
        gc.setFill(paint);
        gc.setTextAlign(ta);
        gc.fillText(
                text,
                screenItem.getPosition().x,
                height + gc.getFont().getSize()
        );
    }

    @Override
    public void renderRoundRect(Paint paint, Dimension arcDimension, ScreenItem screenItem) {
        gc.setFill(paint);
        gc.fillRoundRect(
                screenItem.getPosition().x,
                screenItem.getPosition().y,
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
                screenItem.getPosition().x,
                screenItem.getPosition().y,
                screenItem.getDimension().width,
                screenItem.getDimension().height,
                arcDimension.width,
                arcDimension.height
        );
    }
    
    
}
