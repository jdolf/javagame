/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.render;

import placeholder.game.util.Dimension;
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
public interface Renderer {
    void renderAnimation(Animation animation, ScreenItem screenItem);
    void renderImage(Image image, ScreenItem screenItem);
    void renderRect(Paint paint, ScreenItem screenItem);
    void renderRectStroke(Paint paint, int lineWidth, ScreenItem screenItem);
    void renderRoundRect(Paint paint, Dimension arcDimension, ScreenItem screenItem);
    void renderRoundRectStroke(Paint paint, int lineWidth, Dimension arcDimension, ScreenItem screenItem);
    void renderText(Paint paint, Font font, String text, ScreenItem screenItem, TextAlignment ta);
    void setGameDimension(Dimension dimension);
    void clear();
}
