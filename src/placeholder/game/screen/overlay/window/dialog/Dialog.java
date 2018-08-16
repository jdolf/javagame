/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.window.dialog;

import java.security.InvalidParameterException;
import java.util.List;

/**
 *
 * @author jannik.dolf
 */
public class Dialog {
    
    private List<DialogSection> sections;
    private DialogSection currentSection;
    private boolean started = false;

    public Dialog(List<DialogSection> sections) {
        this.sections = sections;
    }
    
    private DialogSection searchSections(int id) {
        DialogSection result = null;
        
        for (DialogSection section : sections) {
            if (section.getId() == id) {
                result = section;
                break;
            }
        }
        
        if (result != null) {
            return result;
        }
        
        throw new InvalidParameterException("Id not found");
    }

    public void setSections(List<DialogSection> sections) {
        this.sections = sections;
    }
    
    public DialogSection start() {
        currentSection = searchSections(1);
        
        if (currentSection != null) started = true;
        return currentSection;
    }
    
    public DialogSection nextSection() {
        if (started) {
            currentSection = searchSections(currentSection.getSelectedAnswer().getDestinationId());
            return currentSection;
        }
        
        throw new IllegalStateException("Dialog needs to be started first!");
    }
    
    
    
}
