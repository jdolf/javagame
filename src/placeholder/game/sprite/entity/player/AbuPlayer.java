/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.sprite.entity.player;

import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;
import placeholder.game.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.game.screen.overlay.window.WindowManager;
import placeholder.game.input.InputHandler;

/**
 *
 * @author jdolf
 */
public class AbuPlayer extends Player {
    
    public static final String HEAD = "abu_head.png";
    public static final String BODY = "abu_body.png";
    public static final String LEGS = "abu_legs.png";
    public static final String LEFT_ARM = "abu_hand_left.png";
    public static final String RIGHT_ARM = "abu_hand_right.png";
    
    public AbuPlayer(InputHandler inputHandler, WindowManager windowManager, ContextMenuManager contextManager) {
        super(inputHandler, windowManager, contextManager);
    }

    @Override
    protected Image getHeadImage() {
        return ImageContainer.getInstance().getImage(HEAD);
    }

    @Override
    protected Image getBodyImage() {
        return ImageContainer.getInstance().getImage(BODY);
    }

    @Override
    protected Image getLegsImage() {
        return ImageContainer.getInstance().getImage(LEGS);
    }

    @Override
    protected Image getLeftArmImage() {
        return ImageContainer.getInstance().getImage(LEFT_ARM);
    }

    @Override
    protected Image getRightArmImage() {
        return ImageContainer.getInstance().getImage(RIGHT_ARM);
    }
    
}
