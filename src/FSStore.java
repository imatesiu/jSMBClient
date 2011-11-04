/*
 * FSStore.java
 *
 * Created on 15. November 2006, 15:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.io.file.FileSystemRegistry;
import jcifs.smb.SmbException;

/**
 *
 * @author bquentin
 */
public class FSStore implements FileStore{
    FileConnection filecon = null;
    Vector files = null;
    
    /** Creates a new instance of FSStore */
    public FSStore(String roots) {
        try {
            
            // this is really bad code ... please rewrite this!
            
      
                filecon = (FileConnection)Connector.open("file:///"+roots);
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public BasicFile[] getFiles() throws SmbException {
        BasicFile[] array=null;
        try {
            Enumeration enumer = filecon.list();
            files = new Vector();
            BasicFile topDir = new BasicFile("..",true);
            files.addElement(topDir);
            while(enumer.hasMoreElements()){
                
                String fileName = (String) enumer.nextElement();
                boolean isDir = false;
                System.out.println("Test for "+filecon.getURL() + fileName);
                FileConnection fc = (FileConnection)Connector.open(filecon.getURL() +  fileName);
                if(fc.isDirectory()) {
                    System.out.println(filecon.getURL() + fileName+" is a directory");
                    isDir = true;
                }
                BasicFile bf = new BasicFile(fileName,isDir);
                files.addElement(bf);
            }
            array = new BasicFile[files.size()];
            files.copyInto(array);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return array;
    }
    
    public boolean cd(String directory) {
        try {
            System.out.println("going to "+directory);
            
            filecon = (FileConnection)Connector.open( handleUrl(filecon.getURL()+directory)  );
           
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean alreadyExists(String file) {
        return false;
    }
    
    public OutputStream createFile(String file) {
        FileConnection newfilecon=null;
        OutputStream os = null;
        try {
            newfilecon = (FileConnection) Connector.open(handleUrl(filecon.getURL() +  file));
            newfilecon.create();
            os = newfilecon.openDataOutputStream();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return os;
    }
    
    public InputStream getFile(String file) {
        FileConnection newfilecon=null;
        InputStream os = null;
        try {
            newfilecon = (FileConnection) Connector.open(handleUrl(filecon.getURL() +  file));
            os = newfilecon.openDataInputStream();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return os;
    }
    
    public boolean remove(String file) {
        return delete(file);
    }
    
    public boolean rename(String file, String newName) {
        FileConnection newfilecon=null;
        boolean res = false;
        try {
            newfilecon = (FileConnection) Connector.open(handleUrl(filecon.getURL() +  file));
            newfilecon.rename(newName);
            res = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return res;    }
    
    public long getSize(String f) {
        FileConnection newfilecon=null;
        long len = 0;
        try {
            newfilecon = (FileConnection) Connector.open(handleUrl(filecon.getURL() +  f));
            len = newfilecon.fileSize();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return len;
        
        
        
    }
    
    public boolean delete(String file) {
        FileConnection newfilecon=null;
        boolean res = false;
        try {
            if(file.endsWith("/")){
                file = file.substring(0, file.length()-1);
            }
            newfilecon = (FileConnection) Connector.open(handleUrl(filecon.getURL()) + file, Connector.READ_WRITE);
            if(newfilecon.exists()){
               boolean s = newfilecon.canWrite();
            newfilecon.delete();
             res = true;
            }
           
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.print(ex.toString());
            System.out.print(ex);
        }
        
        return res;
    }
    
    // wandele ".." um am Ende des Strings
    private static String handleUrl(String s){
        if(s.endsWith("/..")){
            String c=s;
            int idx = s.lastIndexOf('/');
            s = s.substring(0,idx-1);
            idx = s.lastIndexOf('/');
            s = s.substring(0,idx)+"/";
            if (s.length()<=8){
                idx = c.lastIndexOf('/');
                c= c.substring(0,idx+1);
                s=c;
            }
        }
        System.out.println("now its "+s);
        return s;
    }
}
