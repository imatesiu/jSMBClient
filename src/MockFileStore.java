/*
 * MockFileStore.java
 *
 * Created on 1. November 2006, 15:40
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author bquentin
 */
public class MockFileStore implements FileStore{
    String s = "";
    private byte[] data = "Hello World".getBytes();
    
    public MockFileStore(String s){
        this.s = s;
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            sb.append("Hello World.");
            sb.append(s);
        }
        data = sb.toString().getBytes();
                
        
    }

    public BasicFile[] getFiles() {
        BasicFile[] files = new BasicFile[3];
        BasicFile bf = null;
        
        bf=new BasicFile("..",true);
        files[0]=bf;
        
        bf=new BasicFile("MyFolder",true);
        files[1]=bf;

        bf=new BasicFile(s+"MyFile.txt",false);
        files[2]=bf;
        
        return files;
    }

    public boolean cd(String directory) {
        System.out.println("cd'ing to "+directory);
        return true;
    }

    public boolean alreadyExists(String file) {
        return false;
    }

    public OutputStream createFile(String file) {
        OutputStream os = new ByteArrayOutputStream();
        return os;
    }

    public InputStream getFile(String file) {
        InputStream is = new ByteArrayInputStream(data);
        return is;
    }

    public boolean remove(String file) {
        return true;
    }

    public boolean rename(String file, String newName) {
        return true;
    }
    
    public long getSize(String file){
        return data.length;
    }

    public boolean delete(String file) {
        System.out.println("deleted "+file);
        return true;
    }
    
}
