/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.window.dialog;

import java.util.List;

/**
 *
 * @author jannik.dolf
 */
public class AnswerDialogSection extends DialogSection {
    
    private List<Answer> answers;
    
    public AnswerDialogSection(int id, String header, String message) {
        super(id, header, message);
    }
    
    public void addAnswer(Answer answer) {
        answers.add(answer);
    }
    
}
