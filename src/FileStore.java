/*
 * FileStore.java
 *
 * Created on 1. November 2006, 15:38
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import java.io.InputStream;
import java.io.OutputStream;
import jcifs.smb.SmbException;

/**
 *
 * @author bquentin
 */
public interface FileStore {
    public BasicFile[] getFiles() throws SmbException;
    public boolean cd(String directory);
    
    public boolean alreadyExists(String file);
    
    public OutputStream createFile(String file);
    public InputStream getFile(String file);
    
    public boolean remove(String file);
    
    public boolean rename(String file,String newName);
    
    public long getSize(String f);
    
    public boolean delete(String file);
    
}
