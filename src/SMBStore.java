/*
 * FSStore.java
 *
 * Created on 15. November 2006, 15:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import jcifs.smb.SmbFile;
import javax.microedition.io.SocketConnection;
import jcifs.smb.SmbException;

/**
 *
 * @author bquentin
 */
public class SMBStore implements FileStore {

    SmbFile basefile;
    SmbFile[] files = null;

    /** Creates a new instance of FSStore */
    public SMBStore(String smb) {
        try {

            // open any http url since opening a socket doesn't start the network as it seems ... ?!
            DataInputStream dis = Connector.openDataInputStream("http://www.cafebabe.de/testing");
            SocketConnection con = null;

            //Apro la connessione http
            con = (SocketConnection) Connector.open("socket://193.204.114.233:13");

            System.out.println(con.getLocalAddress());
            con.close();
            dis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
// * <blockquote><pre>
// *     smb://[[[domain;]username[:password]@]server[:port]/[[share/[dir/]file]]][?[param=value[param2=value2[...]]]
// * </pre></blockquote>
        try {
            basefile = new SmbFile(smb);  // start the file view here ...
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public BasicFile[] getFiles() throws SmbException {
        BasicFile[] array = null;

        try {
            files = basefile.listFiles();
            array = new BasicFile[files.length + 1];
            BasicFile topDir = new BasicFile("..", true);
            array[0] = topDir;

            for (int i = 1; i < array.length; i++) {
                array[i] = new BasicFile(files[i - 1].getName(), files[i - 1].isDirectory());
            }

        }catch (SmbException ex) {
            String df = ex.getMessage();
             throw ex;
        }
        
        return array;
    }

    public boolean cd(String directory) {
        try {
            System.out.println("going to " + directory);
            System.out.println("" + handleUrl(basefile.toURL().toString() + "/" + directory));
            //basefile = (FileConnection)Connector.open( handleUrl(filecon.getURL()+"/"+directory)  );
            basefile = new SmbFile(handleUrl(basefile.toURL().toString() + "/" + directory));
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
        SmbFile newfilecon = null;
        OutputStream os = null;
        try {
            newfilecon = new SmbFile(handleUrl(basefile.toURL().toString() + "/" + file));
            os = newfilecon.getOutputStream();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return os;
    }

    public InputStream getFile(String file) {
        SmbFile newfilecon = null;
        InputStream os = null;
        try {
            newfilecon = new SmbFile(handleUrl(basefile.toURL().toString() + "/" + file));
            os = newfilecon.getInputStream();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return os;
    }

    public boolean remove(String file) {
        return delete(file);
    }

    public boolean rename(String file, String newName) {
        SmbFile newfilecon = null;
        boolean res = false;
        try {
            newfilecon = new SmbFile(handleUrl(basefile.toURL().toString() + "/" + file));
            SmbFile dest = new SmbFile(handleUrl(basefile.toURL().toString() + "/" + newName));
            newfilecon.renameTo(dest);
            res = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return res;
    }

    public long getSize(String f) {
        SmbFile newfilecon = null;
        long len = 0;
        try {
            newfilecon = new SmbFile(handleUrl(basefile.toURL().toString() + "/" + f));
            len = newfilecon.length();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return len;



    }

    public boolean delete(String file) {
        SmbFile newfilecon = null;
        boolean res = false;
        try {
            newfilecon = new SmbFile(handleUrl(basefile.toURL().toString() + "/" + file));
            newfilecon.delete();
            res = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return res;
    }

    // wandele ".." um am Ende des Strings
    private static String handleUrl(String s) {
        if (s.endsWith("/..")) {
            int idx = s.lastIndexOf('/');
            s = s.substring(0, idx - 1);
            idx = s.lastIndexOf('/');
            String gs = s.substring(0, idx);
            if (!gs.equals("smb:/")) {
                s = gs;
            }
        }
        if (!s.endsWith("/")) {
            s += "/";
        }
        System.out.println("now its " + s);
        return s;
    }
}
