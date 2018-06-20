/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.contextmenu.entry;

import java.awt.Dimension;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.render.Renderable;
import placeholder.game.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public abstract class ContextMenuEntry extends ScreenItem implements Renderable {
    
    public static final Dimension DEFAULT_DIMENSION = new Dimension(100, 20);
    public static final Font DEFAULT_FONT = new Font("Arial", 14);
    
    protected String displayName;
    
    public ContextMenuEntry(String displayName) {
        super(DEFAULT_DIMENSION);
        this.displayName = displayName;
    }

    @Override
    public void render(Renderer renderer) {
        renderer.renderText(Color.BLACK, DEFAULT_FONT, displayName, this, TextAlignment.LEFT);
    }
    
    public abstract void execute();

    
}
