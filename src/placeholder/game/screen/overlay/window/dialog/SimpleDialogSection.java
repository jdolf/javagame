/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.window.dialog;

/**
 *
 * @author jannik.dolf
 */
public class SimpleDialogSection extends DialogSection {
    
    private Answer answer;
    
    public SimpleDialogSection(int id, String header, String message, Answer answer) {
        super(id, header, message);
        this.answer = answer;
    }
    
    
    
}
