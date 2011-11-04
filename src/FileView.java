/*
 * FileView.java
 *
 * Created on 1. November 2006, 15:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;

/**
 *
 * @author bquentin
 */
public class FileView extends List implements CommandListener {

    private Command backCommand = new Command("Back", Command.OK, 30);
    private Image image3;
    private Image image4;
    public class Refresher2 implements Runnable {

        public Display display;
        public Displayable view;

        public void run() {
            display.setCurrent(view);
        }
    }
    Refresher2 refresher2 = new Refresher2();

    public class Refresher implements Runnable {

        public Gauge theGauge = null;
        public int val = 0;

        public void run() {
            theGauge.setValue(val);
        }
    }
    Refresher refresher = new Refresher();
    ProfileConnect fileman = null;
    FileStore fileStore = null;
    FileStore otherStore = null;  // where to copy files to etc., shown in the other view
    BasicFile[] tmpFileList = null;
    Command goTo = new Command("Go", Command.OK, 1);
    Command otherCmd = new Command("Switch view", Command.BACK, 2);
    Command copyCmd = new Command("Copy", Command.OK, 20);
    Command moveCmd = new Command("Move", Command.OK, 23);
    Command rmCmd = new Command("Remove", Command.OK, 24);
    Command renameCmd = new Command("Rename", Command.OK, 25);
    Form gaugeForm = new Form("Please wait");
    Gauge gauge = new Gauge("Progess", false, 100, 0);

    /** Creates a new instance of FileView */
    public FileView(String title) {
        super(title, List.IMPLICIT);
        this.setCommandListener(this);
        this.setSelectCommand(goTo);
        this.addCommand(goTo);
        this.addCommand(otherCmd);
        this.addCommand(copyCmd);
        this.addCommand(moveCmd);
        this.addCommand(rmCmd);
        this.addCommand(renameCmd);
        this.addCommand(backCommand);
        gaugeForm.append(gauge);

    }

    void setFileStore(FileStore fileStore) {
        this.fileStore = fileStore;
        populateList();
    }

    void setOtherFileStore(FileStore fileStore) {
        this.otherStore = fileStore;
    }

    private void populateList() {
        this.deleteAll();
        try{
        BasicFile[] files = fileStore.getFiles();
        for (int i = 0; i < files.length; i++) {
            //if (files[i].getName().indexOf("$") < 0) {
            String name =files[i].getName();
            if(!files[i].isIsDirectory()){
                this.append(name, this.getImagefile());
            }else{
                this.append(name, this.getImagedir());
            }
           // }
        }
        tmpFileList = files;
        }catch(Exception e){
            String df = e.getMessage();
          
            System.out.println(df+"ss\n");
            Alert a = new Alert("alert", e.getMessage(), null, AlertType.ERROR);
           
                a.setTimeout(5000);
                fileman.switchDisplayable(a, fileman.getList());
//                fileman.getDisplay().setCurrent(a);
//                fileman.getDisplay().setCurrent(fileman.getList());
        }
    }

    // command handler
    public void commandAction(Command command, Displayable displayable) {
        if (command == goTo) {
            BasicFile bf = tmpFileList[this.getSelectedIndex()];
            System.out.println("isADir=" + bf.isIsDirectory() + bf.getName());
            if (bf.isIsDirectory()) {
                fileStore.cd(bf.getName());
                populateList();
            }
        }

        if (command == otherCmd) {
            // switch view ...
            fileman.switchView();
        }

        if (command == copyCmd) {
            copyFile(false);
        }
        if (command == moveCmd) {
            copyFile(true);
        }
        if (command == rmCmd) {
            deleteFile();
        }
        if (command == renameCmd) {
            renameFile();
            populateList();
        }
        if (command == backCommand) {
            fileman.getDisplay().setCurrent(fileman.getForm());
        }

    }

    private void copyFile(final boolean deleteAfter) {
        final FileView fv = this;

        Thread t = new Thread() {

            public void run() {
                String fname = tmpFileList[fv.getSelectedIndex()].getName();
                Displayable oldView = fileman.getDisplay().getCurrent();
                gauge.setValue(0);
                fileman.getDisplay().setCurrent(gaugeForm);
                InputStream is = null;
                OutputStream os = null;
                try {
                    // here we copy the stuff ..
                    // <work>
                    byte[] buffer = new byte[2048];
                    long len = fileStore.getSize(fname);
                    long total = 0;
                    int read = -1;
                    is = fileStore.getFile(fname);
                    os = otherStore.createFile(fname);
                    // TODO: how to deal with errors ???
                    refresher.theGauge = gauge;

                    do {
                        read = is.read(buffer);
                        if (read > 0) {
                            os.write(buffer, 0, read);
                            total += read;
                            int v = (int) ((100* total)/len);
                            refresher.val = v;
                            fileman.getDisplay().callSerially(refresher);
                        }else{
                            System.out.print(len+"prova"+total);
                        }


                    } while (read != -1);

                    if (deleteAfter) {
                        fileStore.delete(fname);
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception ee) {
                            //
                        }
                    }
                    if (os != null) {
                        try {
                            os.close();
                        } catch (Exception ee) {
                            //
                        }
                    }
                }






                // </work>
                // set the old view

                refresher2.view = oldView;
                refresher2.display = fileman.getDisplay();
                fileman.getDisplay().callSerially(refresher2);
            }
        };
        t.start();


    }

    void setFileman(ProfileConnect sMBFileman) {
        fileman = sMBFileman;
    }

    private void deleteFile() {
//        final FileView fv = this;
//        Thread t = new Thread() {
//
//            public void run() {
                String fname = tmpFileList[this.getSelectedIndex()].getName();
//                Displayable oldView = fileman.getDisplay().getCurrent();
//                gauge.setValue(0);
//                fileman.getDisplay().setCurrent(gaugeForm);

                // here we copy the stuff ..
                // <work>
                boolean result = fileStore.delete(fname);
                // </work>
                // set the old view
                if (result) {
                    this.delete(this.getSelectedIndex());
                }
//                refresher2.view = oldView;
//                refresher2.display = fileman.getDisplay();
//                fileman.getDisplay().callSerially(refresher2);

//            }
//        };
//
//        t.start();

    }
    public Image getImagedir() {
        if (image3 == null) {
            // write pre-init user code here
            try {
                image3 = Image.createImage("/folder64.png");
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            // write post-init user code here
        }
        return image3;
    }
    public Image getImagefile() {
        if (image4 == null) {
            // write pre-init user code here
            try {
                image4 = Image.createImage("/imageslogo.jpg");
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            // write post-init user code here
        }
        return image4;
    }
    private void renameFile() {
        String name = "newname";

        fileStore.rename(tmpFileList[this.getSelectedIndex()].getName(), name);
    }
}
