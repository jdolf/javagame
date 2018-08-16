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
public class Answer {
    
    public static final String DEFAULT_TEXT = "Continue";
    
    private String message;
    private int destinationId;

    public Answer(String message, int destinationId) {
        this.message = message;
        this.destinationId = destinationId;
    }

    public Answer(int destinationId) {
        this.message = DEFAULT_TEXT;
        this.destinationId = destinationId;
    }
    
    public Answer() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }
    
    
    
}
