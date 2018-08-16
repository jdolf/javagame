/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.util;

import java.util.ArrayList;
import java.util.List;
import placeholder.game.screen.overlay.SizeChangeListener;

/**
 *
 * @author jannik.dolf
 */
public class Dimension extends java.awt.Dimension {
    
    private List<SizeChangeListener> sizeListener = new ArrayList();

    public Dimension() {
    }

    public Dimension(placeholder.game.util.Dimension d) {
        super(d);
    }

    public Dimension(int width, int height) {
        super(width, height);
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        notifyDimensionChangedListener();
    }

    @Override
    public void setSize(java.awt.Dimension d) {
        super.setSize(d);
    }

    @Override
    public void setSize(double width, double height) {
        super.setSize(width, height);
        notifyDimensionChangedListener();
    }
    
    public void addSizeChangeListener(SizeChangeListener listener) {
        this.sizeListener.add(listener);
    }
    
    private void notifyDimensionChangedListener() {
        this.sizeListener.forEach((listener) -> {
            listener.onSizeChanged(new Dimension((int)this.getWidth(), (int)this.getHeight()));
        });
    }
    
}
