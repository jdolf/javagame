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
public abstract class DialogSection {
    
    private int id;
    private String header;
    private String message;
    protected Answer selectedAnswer;

    public DialogSection(int id, String header, String message) {
        this.id = id;
        this.header = header;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Answer getSelectedAnswer() {
        return selectedAnswer;
    }
    
    
    
}
