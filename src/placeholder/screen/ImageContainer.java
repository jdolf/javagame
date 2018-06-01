/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import javafx.scene.image.Image;

/**
 *
 * @author jdolf
 */
public class ImageContainer {
    
    public static final String DIRECTORY_NAME = "src/resources/img/";
    
    private static ImageContainer instance;
    private Map<String,Image> images = new LinkedHashMap();
    
    private ImageContainer() {
        
        listf(DIRECTORY_NAME);
        
    }
    
    public static ImageContainer getInstance() {
        if (instance == null) {
            initialize();
        }
        return instance;
    }
    
    public static boolean initialize() {
        if (instance == null) {
            instance = new ImageContainer();
            return true;
        }
        return false;
    }
    
    public Image getImage(String filename) {
        return images.get(filename);
    }
    
    private void listf(String directoryName) {
        File directory = new File(directoryName);

        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                System.out.println(file.getPath());
                images.put(file.getName(), new Image(file.toURI().toString()));
            } else if (file.isDirectory()) {
                listf(file.getAbsolutePath());
            }
        }
    }
}
