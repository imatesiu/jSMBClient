/*
 * BasicFile.java
 *
 * Created on 1. November 2006, 15:39
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



/**
 *
 * @author bquentin
 */
public class BasicFile {

    private boolean isDirectory;

    private String name;
    
    /** Creates a new instance of BasicFile */
    public BasicFile(String name,boolean isDirectory) {
        this.setName(name);
        this.setIsDirectory(isDirectory);
    }

    public boolean isIsDirectory() {
        return isDirectory;
    }

    public void setIsDirectory(boolean isDirectory) {
        this.isDirectory = isDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
