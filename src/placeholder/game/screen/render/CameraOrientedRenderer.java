/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.render;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import placeholder.game.screen.animation.Animation;
import placeholder.game.screen.overlay.ScreenItem;

/**
 *
 * @author jdolf
 */
public class CameraOrientedRenderer extends DefaultRenderer {
    
    private Camera camera;

    public CameraOrientedRenderer(GraphicsContext gc, Dimension gameDimension) {
        super(gc, gameDimension);
        this.camera = new Camera(gameDimension);
    }
    
    public Camera getCamera() {
        return this.camera;
    }
    
    @Override
    public void renderAnimation(Animation animation, ScreenItem screenItem) {
        gc.drawImage(
                animation.getImage(),
                animation.getSourceX(),
                animation.getSourceY(),
                animation.getSourceWidth(),
                animation.getSourceHeight(),
                sharpen(screenItem.getPosition().getX() - camera.getPosition().getX()),
                sharpen(screenItem.getPosition().getY() - camera.getPosition().getY()),
                screenItem.getDimension().width,
                screenItem.getDimension().height
        );
    }

    @Override
    public void renderImage(Image image, ScreenItem screenItem) {
        gc.drawImage(
            image,
            sharpen(screenItem.getPosition().getX() - camera.getPosition().getX()),
            sharpen(screenItem.getPosition().getY() - camera.getPosition().getY()),
            screenItem.getDimension().width,
            screenItem.getDimension().height
        );
        
    }

    @Override
    public void renderRect(Paint paint, ScreenItem screenItem) {
        gc.setFill(paint);
        gc.fillRect(
                sharpen(screenItem.getPosition().getX() - camera.getPosition().getX()),
                sharpen(screenItem.getPosition().getY() - camera.getPosition().getY()),
                screenItem.getDimension().width,
                screenItem.getDimension().height
        );
    }
    
    @Override
    public void renderRectStroke(Paint paint, int lineWidth, ScreenItem screenItem) {
        gc.setStroke(paint);
        gc.setLineWidth(lineWidth);
        gc.strokeRect(
                sharpen(screenItem.getPosition().getX() - camera.getPosition().getX()),
                sharpen(screenItem.getPosition().getY() - camera.getPosition().getY()),
                screenItem.getDimension().width,
                screenItem.getDimension().height
        );
    }

    @Override
    public void renderText(Paint paint, Font font, String text, ScreenItem screenItem, TextAlignment ta) {
        double height = screenItem.getPosition().getY() - camera.getPosition().getY();
        gc.setFont(font);
        gc.setFill(paint);
        gc.setTextAlign(ta);
        gc.fillText(
                text,
                sharpen(screenItem.getPosition().getX() - camera.getPosition().getX()),
                height + gc.getFont().getSize()
        );
    }

    @Override
    public void renderRoundRect(Paint paint, Dimension arcDimension, ScreenItem screenItem) {
        gc.setFill(paint);
        gc.fillRoundRect(
                sharpen(screenItem.getPosition().getX() - camera.getPosition().getX()),
                sharpen(screenItem.getPosition().getY() - camera.getPosition().getY()),
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
                sharpen(screenItem.getPosition().getX() - camera.getPosition().getX()),
                sharpen(screenItem.getPosition().getY() - camera.getPosition().getY()),
                screenItem.getDimension().width,
                screenItem.getDimension().height,
                arcDimension.width,
                arcDimension.height
        );
    }
    
}
