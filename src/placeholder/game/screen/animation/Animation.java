/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.animation;

import placeholder.game.util.Dimension;
import javafx.scene.image.Image;

/**
 *
 * @author jdolf
 */
public interface Animation<T> {
    
    void update();
    void setData(T data);
    Image getImage();
    double getSourceX();
    double getSourceY();
    double getSourceWidth();
    double getSourceHeight();
    int calculateRow();
    int calculateColumn();
    Image createPreviewImage();
    
}
