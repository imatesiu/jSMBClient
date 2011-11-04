/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Enumeration;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.io.file.FileSystemRegistry;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotFoundException;
import javax.microedition.rms.RecordStoreNotOpenException;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import org.netbeans.microedition.lcdui.SplashScreen;

/**
 * @author mart3
 */
public class ProfileConnect extends MIDlet implements CommandListener {

    FileView localView = new FileView("Local");
    FileView remoteView = new FileView("Remote");
    FSStore mfs1;
    private boolean midletPaused = false;
    public RecordStore SMBRec;
    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    // private SplashScreen splashScreen;
    private Form form1;
    private TextField textField1;
    private TextField textField;
    private TextField textField5;
    private TextField textField4;
    private TextField textField3;
    private TextField textField2;
    private List list;
    private Form form;
    private ChoiceGroup choiceGroup;
    private Command backCommand;
    private Command okCommand;
    private Command exitCommand;
    private Command NuovoProfilo;
    private Command exitCommand1;
    private Command Connetti;
    private Command Salva;
    private Command Indietro;
    private Command ModificaProfilo;
    private Command CancellaProfilo;
    private Command Connetti1;
    private Command backCommand1;
    private Command Done;
    private Image image1;
    private Image image2;
    private Image image3;
    private Form form2;
    private ImageItem imageItem;
    private ImageItem imageItem1;
    private StringItem stringItem2;

    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The ProfileConnect constructor.
     */
    public ProfileConnect() {
//        try {
//            RecordStore.deleteRecordStore("StoreSMB");
//
//
//        } catch (RecordStoreException e) {
//            this.getDisplay().setCurrent(new Alert(e.getMessage()));
//        }
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|
    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//         if (RecordStore.listRecordStores()== null){
//             Alert sd = new Alert("db Vuoto");
//                     sd.isShown();
//             this.getDisplay().setCurrent(sd);
//         }
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here

        switchDisplayable(null, getForm2());

        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == form) {//GEN-BEGIN:|7-commandAction|1|73-preAction
            if (command == Connetti1) {//GEN-END:|7-commandAction|1|73-preAction
                // write pre-action user code here
                if (list.size() > 0) {
                    connect1();
                }
//GEN-LINE:|7-commandAction|2|73-postAction
                // write post-action user code here
            } else if (command == backCommand1) {//GEN-LINE:|7-commandAction|3|75-preAction
                // write pre-action user code here
                switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|4|75-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|45-preAction
        } else if (displayable == form1) {
            if (command == Indietro) {//GEN-END:|7-commandAction|5|45-preAction
                // write pre-action user code here
                switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|6|45-postAction
                // write post-action user code here
            } else if (command == Salva) {//GEN-LINE:|7-commandAction|7|48-preAction
                // write pre-action user code here
                salvaprof();
//GEN-LINE:|7-commandAction|8|48-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|9|57-preAction
        } else if (displayable == list) {
            if (command == CancellaProfilo) {//GEN-END:|7-commandAction|9|57-preAction
                // write pre-action user code here
                cancellaprof();
//GEN-LINE:|7-commandAction|10|57-postAction
                // write post-action user code here
            } else if (command == Connetti) {//GEN-LINE:|7-commandAction|11|42-preAction
                // write pre-action user code here
                if (list.size() > 0) {
                    switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|12|42-postAction
                }
                // write post-action user code here
            } else if (command == List.SELECT_COMMAND) {//GEN-LINE:|7-commandAction|13|34-preAction
                // write pre-action user code here
                listAction();//GEN-LINE:|7-commandAction|14|34-postAction
                // write post-action user code here
            } else if (command == ModificaProfilo) {//GEN-LINE:|7-commandAction|15|59-preAction
                // write pre-action user code here
                form1.deleteAll();
                form1 = new Form("Dati Connessione", new Item[]{getTextField5(), getTextField(), getTextField1(), getTextField2(), getTextField3(), getTextField4()});
                form1.addCommand(getIndietro());
                form1.addCommand(getSalva());
                form1.setCommandListener(this);
                cancellaprof();
                switchDisplayable(null, form1);
//GEN-LINE:|7-commandAction|16|59-postAction
                // write post-action user code here
            } else if (command == NuovoProfilo) {//GEN-LINE:|7-commandAction|17|40-preAction
                // write pre-action user code here
                switchDisplayable(null, getForm1());//GEN-LINE:|7-commandAction|18|40-postAction
                // write post-action user code here
            } else if (command == exitCommand1) {//GEN-LINE:|7-commandAction|19|38-preAction
                // write pre-action user code here
                this.destroyApp(true);
//GEN-LINE:|7-commandAction|20|38-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|21|25-preAction
        } else if (displayable == form2) {
            if (command == Done) {
                // write pre-action user code here
                switchDisplayable(null, getList());
                // write post-action user code here
            }
        }
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|24|
    //</editor-fold>//GEN-END:|7-commandAction|24|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: splashScreen ">//GEN-BEGIN:|23-getter|0|23-preInit
    /**
     * Returns an initiliazed instance of splashScreen component.
     * @return the initialized component instance
     */
    public Form getForm2() {
        if (form2 == null) {
            // write pre-init user code here
            form2 = new Form("Application Info", new Item[]{getImageItem(), getStringItem2(), getImageItem2()});
            form2.addCommand(getDone());
            form2.setCommandListener(this);
            // write post-init user code here
        }
        return form2;
    }

    //</editor-fold>//GEN-END:|23-getter|2|
    public ImageItem getImageItem() {
        if (imageItem == null) {
            // write pre-init user code here
            imageItem = new ImageItem("", getImage1(), ImageItem.LAYOUT_CENTER | Item.LAYOUT_TOP | Item.LAYOUT_BOTTOM | Item.LAYOUT_VCENTER, "", Item.PLAIN);
            imageItem.setPreferredSize(50, 50);
            // write post-init user code here
        }
        return imageItem;
    }

    public ImageItem getImageItem2() {
        if (imageItem1 == null) {
            // write pre-init user code here
            imageItem1 = new ImageItem("", getImage2(), ImageItem.LAYOUT_CENTER | Item.LAYOUT_TOP | Item.LAYOUT_BOTTOM | Item.LAYOUT_VCENTER, "", Item.PLAIN);
            imageItem1.setPreferredSize(50, 50);
            // write post-init user code here
        }
        return imageItem1;
    }
    //</editor-fold>

    public Image getImage1() {
        if (image1 == null) {
            // write pre-init user code here
            try {
                image1 = Image.createImage("/samba.png");
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            // write post-init user code here
        }
        return image1;
    }

    public Image getImage2() {
        if (image2 == null) {
            // write pre-init user code here
            try {
                image2 = Image.createImage("/88x31.png");
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            // write post-init user code here
        }
        return image2;
    }

    public Command getDone() {
        if (Done == null) {
            // write pre-init user code here
            Done = new Command("Done", Command.BACK, 0);
            // write post-init user code here
        }
        return Done;
    }
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem2 ">

    /**
     * Returns an initiliazed instance of stringItem2 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem2() {
        if (stringItem2 == null) {
            // write pre-init user code here
            stringItem2 = new StringItem("", "Programma creato da Siu  Si ringrazia  bjoernQ per il porting di jCIFS port for JME di mobile-j.de Rilasciato sotto licenza: Creative Commons License -  Creative Commons Attribuzione-Non commerciale-Condividi allo stesso modo 3.0 Unported -  http://creativecommons.org/licenses/by-nc-sa/3.0/ ");
            // write post-init user code here
        }
        return stringItem2;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|18-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|20-getter|0|20-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|20-getter|0|20-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|20-getter|1|20-postInit
            // write post-init user code here
        }//GEN-BEGIN:|20-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|20-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|28-getter|0|28-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|28-getter|1|28-postInit
            // write post-init user code here
        }//GEN-BEGIN:|28-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|28-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: form1 ">//GEN-BEGIN:|31-getter|0|31-preInit
    /**
     * Returns an initiliazed instance of form1 component.
     * @return the initialized component instance
     */
    public Form getForm1() {
        if (form1 == null) {//GEN-END:|31-getter|0|31-preInit
            // write pre-init user code here
            form1 = new Form("Dati Connessione", new Item[]{getTextField5(), getTextField(), getTextField1(), getTextField2(), getTextField3(), getTextField4()});//GEN-BEGIN:|31-getter|1|31-postInit
            form1.addCommand(getIndietro());
            form1.addCommand(getSalva());
            form1.setCommandListener(this);//GEN-END:|31-getter|1|31-postInit
            // write post-init user code here
        }//GEN-BEGIN:|31-getter|2|
        return form1;
    }
    //</editor-fold>//GEN-END:|31-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: list ">//GEN-BEGIN:|32-getter|0|32-preInit
    /**
     * Returns an initiliazed instance of list component.
     * @return the initialized component instance
     */
    public List getList() {
        if (list == null) {//GEN-END:|32-getter|0|32-preInit
            // write pre-init user code here
            list = new List("Profili Connessione", Choice.EXCLUSIVE);//GEN-BEGIN:|32-getter|1|32-postInit
            list.addCommand(getExitCommand1());
            list.addCommand(getNuovoProfilo());
            list.addCommand(getConnetti());
            list.addCommand(getCancellaProfilo());
            list.addCommand(getModificaProfilo());
            list.setCommandListener(this);
            list.setFitPolicy(Choice.TEXT_WRAP_DEFAULT);
            list.setSelectedFlags(new boolean[]{});//GEN-END:|32-getter|1|32-postInit
            // write post-init user code here
            SMBList();
        }//GEN-BEGIN:|32-getter|2|
        return list;
    }
    //</editor-fold>//GEN-END:|32-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: listAction ">//GEN-BEGIN:|32-action|0|32-preAction
    /**
     * Performs an action assigned to the selected list element in the list component.
     */
    public void listAction() {//GEN-END:|32-action|0|32-preAction
        // enter pre-action user code here
        String __selectedString = getList().getString(getList().getSelectedIndex());//GEN-LINE:|32-action|1|32-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|32-action|2|
    //</editor-fold>//GEN-END:|32-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|37-getter|0|37-preInit
    /**
     * Returns an initiliazed instance of exitCommand1 component.
     * @return the initialized component instance
     */
    public Command getExitCommand1() {
        if (exitCommand1 == null) {//GEN-END:|37-getter|0|37-preInit
            // write pre-init user code here
            exitCommand1 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|37-getter|1|37-postInit
            // write post-init user code here
        }//GEN-BEGIN:|37-getter|2|
        return exitCommand1;
    }
    //</editor-fold>//GEN-END:|37-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: NuovoProfilo ">//GEN-BEGIN:|39-getter|0|39-preInit
    /**
     * Returns an initiliazed instance of NuovoProfilo component.
     * @return the initialized component instance
     */
    public Command getNuovoProfilo() {
        if (NuovoProfilo == null) {//GEN-END:|39-getter|0|39-preInit
            // write pre-init user code here
            NuovoProfilo = new Command("Nuovo Profilo", Command.ITEM, 0);//GEN-LINE:|39-getter|1|39-postInit
            // write post-init user code here
        }//GEN-BEGIN:|39-getter|2|
        return NuovoProfilo;
    }
    //</editor-fold>//GEN-END:|39-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Connetti ">//GEN-BEGIN:|41-getter|0|41-preInit
    /**
     * Returns an initiliazed instance of Connetti component.
     * @return the initialized component instance
     */
    public Command getConnetti() {
        if (Connetti == null) {//GEN-END:|41-getter|0|41-preInit
            // write pre-init user code here
            Connetti = new Command("Connetti", Command.OK, 0);//GEN-LINE:|41-getter|1|41-postInit
            // write post-init user code here
        }//GEN-BEGIN:|41-getter|2|
        return Connetti;
    }
    //</editor-fold>//GEN-END:|41-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Indietro ">//GEN-BEGIN:|44-getter|0|44-preInit
    /**
     * Returns an initiliazed instance of Indietro component.
     * @return the initialized component instance
     */
    public Command getIndietro() {
        if (Indietro == null) {//GEN-END:|44-getter|0|44-preInit
            // write pre-init user code here
            Indietro = new Command("Indietro", Command.BACK, 0);//GEN-LINE:|44-getter|1|44-postInit
            // write post-init user code here
        }//GEN-BEGIN:|44-getter|2|
        return Indietro;
    }
    //</editor-fold>//GEN-END:|44-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Salva ">//GEN-BEGIN:|47-getter|0|47-preInit
    /**
     * Returns an initiliazed instance of Salva component.
     * @return the initialized component instance
     */
    public Command getSalva() {
        if (Salva == null) {//GEN-END:|47-getter|0|47-preInit
            // write pre-init user code here
            Salva = new Command("Salva", Command.OK, 0);//GEN-LINE:|47-getter|1|47-postInit
            // write post-init user code here
        }//GEN-BEGIN:|47-getter|2|
        return Salva;
    }
    //</editor-fold>//GEN-END:|47-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField ">//GEN-BEGIN:|50-getter|0|50-preInit
    /**
     * Returns an initiliazed instance of textField component.
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {//GEN-END:|50-getter|0|50-preInit
            // write pre-init user code here
            textField = new TextField("Host", "10.42.43.1", 32, TextField.ANY);//GEN-LINE:|50-getter|1|50-postInit
            // write post-init user code here
        }//GEN-BEGIN:|50-getter|2|
        return textField;
    }
    //</editor-fold>//GEN-END:|50-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField1 ">//GEN-BEGIN:|51-getter|0|51-preInit
    /**
     * Returns an initiliazed instance of textField1 component.
     * @return the initialized component instance
     */
    public TextField getTextField1() {
        if (textField1 == null) {//GEN-END:|51-getter|0|51-preInit
            // write pre-init user code here
            textField1 = new TextField("Port", "139", 32, TextField.ANY);//GEN-LINE:|51-getter|1|51-postInit
            // write post-init user code here
        }//GEN-BEGIN:|51-getter|2|
        return textField1;
    }
    //</editor-fold>//GEN-END:|51-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField2 ">//GEN-BEGIN:|52-getter|0|52-preInit
    /**
     * Returns an initiliazed instance of textField2 component.
     * @return the initialized component instance
     */
    public TextField getTextField2() {
        if (textField2 == null) {//GEN-END:|52-getter|0|52-preInit
            // write pre-init user code here
            textField2 = new TextField("Username", "st4fil0", 32, TextField.ANY);//GEN-LINE:|52-getter|1|52-postInit
            // write post-init user code here
        }//GEN-BEGIN:|52-getter|2|
        return textField2;
    }
    //</editor-fold>//GEN-END:|52-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField3 ">//GEN-BEGIN:|53-getter|0|53-preInit
    /**
     * Returns an initiliazed instance of textField3 component.
     * @return the initialized component instance
     */
    public TextField getTextField3() {
        if (textField3 == null) {//GEN-END:|53-getter|0|53-preInit
            // write pre-init user code here
            textField3 = new TextField("Password", "faloxa22", 32, TextField.ANY | TextField.PASSWORD);//GEN-LINE:|53-getter|1|53-postInit
            // write post-init user code here
        }//GEN-BEGIN:|53-getter|2|
        return textField3;
    }
    //</editor-fold>//GEN-END:|53-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField4 ">//GEN-BEGIN:|54-getter|0|54-preInit
    /**
     * Returns an initiliazed instance of textField4 component.
     * @return the initialized component instance
     */
    public TextField getTextField4() {
        if (textField4 == null) {//GEN-END:|54-getter|0|54-preInit
            // write pre-init user code here
            textField4 = new TextField("Dominio", "WORKGROUP", 32, TextField.ANY);//GEN-LINE:|54-getter|1|54-postInit
            // write post-init user code here
        }//GEN-BEGIN:|54-getter|2|
        return textField4;
    }
    //</editor-fold>//GEN-END:|54-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField5 ">//GEN-BEGIN:|55-getter|0|55-preInit
    /**
     * Returns an initiliazed instance of textField5 component.
     * @return the initialized component instance
     */
    public TextField getTextField5() {
        if (textField5 == null) {//GEN-END:|55-getter|0|55-preInit
            // write pre-init user code here
            textField5 = new TextField("Nome Profilo", null, 32, TextField.ANY);//GEN-LINE:|55-getter|1|55-postInit
            // write post-init user code here
        }//GEN-BEGIN:|55-getter|2|
        return textField5;
    }
    //</editor-fold>//GEN-END:|55-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: CancellaProfilo ">//GEN-BEGIN:|56-getter|0|56-preInit
    /**
     * Returns an initiliazed instance of CancellaProfilo component.
     * @return the initialized component instance
     */
    public Command getCancellaProfilo() {
        if (CancellaProfilo == null) {//GEN-END:|56-getter|0|56-preInit
            // write pre-init user code here
            CancellaProfilo = new Command("Cancella Profilo", Command.ITEM, 0);//GEN-LINE:|56-getter|1|56-postInit
            // write post-init user code here
        }//GEN-BEGIN:|56-getter|2|
        return CancellaProfilo;
    }
    //</editor-fold>//GEN-END:|56-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ModificaProfilo ">//GEN-BEGIN:|58-getter|0|58-preInit
    /**
     * Returns an initiliazed instance of ModificaProfilo component.
     * @return the initialized component instance
     */
    public Command getModificaProfilo() {
        if (ModificaProfilo == null) {//GEN-END:|58-getter|0|58-preInit
            // write pre-init user code here
            ModificaProfilo = new Command("Modifica profilo", Command.ITEM, 0);//GEN-LINE:|58-getter|1|58-postInit
            // write post-init user code here
        }//GEN-BEGIN:|58-getter|2|
        return ModificaProfilo;
    }
    //</editor-fold>//GEN-END:|58-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|66-getter|0|66-preInit
    /**
     * Returns an initiliazed instance of form component.
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {//GEN-END:|66-getter|0|66-preInit
            // write pre-init user code here
            form = new Form("Scegli", new Item[]{getChoiceGroup()});//GEN-BEGIN:|66-getter|1|66-postInit
            form.addCommand(getConnetti1());
            form.addCommand(getBackCommand1());
            form.setCommandListener(this);//GEN-END:|66-getter|1|66-postInit
            // write post-init user code here
            populateform();

        }//GEN-BEGIN:|66-getter|2|
        return form;
    }
    //</editor-fold>//GEN-END:|66-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: choiceGroup ">//GEN-BEGIN:|69-getter|0|69-preInit
    /**
     * Returns an initiliazed instance of choiceGroup component.
     * @return the initialized component instance
     */
    public ChoiceGroup getChoiceGroup() {
        if (choiceGroup == null) {//GEN-END:|69-getter|0|69-preInit
            // write pre-init user code here
            choiceGroup = new ChoiceGroup("Impostare Memoria Locale", Choice.EXCLUSIVE);//GEN-BEGIN:|69-getter|1|69-postInit
            choiceGroup.setSelectedFlags(new boolean[]{});//GEN-END:|69-getter|1|69-postInit
            // write post-init user code here
        }//GEN-BEGIN:|69-getter|2|
        return choiceGroup;
    }
    //</editor-fold>//GEN-END:|69-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Connetti1 ">//GEN-BEGIN:|72-getter|0|72-preInit
    /**
     * Returns an initiliazed instance of Connetti1 component.
     * @return the initialized component instance
     */
    public Command getConnetti1() {
        if (Connetti1 == null) {//GEN-END:|72-getter|0|72-preInit
            // write pre-init user code here
            Connetti1 = new Command("Ok", Command.OK, 0);//GEN-LINE:|72-getter|1|72-postInit
            // write post-init user code here
        }//GEN-BEGIN:|72-getter|2|
        return Connetti1;
    }
    //</editor-fold>//GEN-END:|72-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|74-getter|0|74-preInit
    /**
     * Returns an initiliazed instance of backCommand1 component.
     * @return the initialized component instance
     */
    public Command getBackCommand1() {
        if (backCommand1 == null) {//GEN-END:|74-getter|0|74-preInit
            // write pre-init user code here
            backCommand1 = new Command("Back", Command.BACK, 0);//GEN-LINE:|74-getter|1|74-postInit
            // write post-init user code here
        }//GEN-BEGIN:|74-getter|2|
        return backCommand1;
    }
    //</editor-fold>//GEN-END:|74-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {

        switchDisplayable(null, null);
        //destroyApp(true);
        // notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
        notifyDestroyed();
    }

    public void salvaprof() {
        if ((textField.getString() != null)
                && (textField1.getString() != null)
                && (textField2.getString() != null)
                && (textField3.getString() != null)
                && (textField4.getString() != null) && (textField5.getString() != null)) {

            dataConnetion sd = new dataConnetion(textField5.getString(), textField.getString(), textField1.getString(),
                    textField2.getString(), textField3.getString(), textField4.getString());
            String lists = textField5.getString() + "[" + textField.getString() + "]";
            if (list.size() != 0) {
                for (int i = 0; i < list.size(); i++) {

                    if (!(list.getString(i).equals(lists))) {
                        list.append(lists, null);
                        this.SMBAdd(sd);
                        switchDisplayable(null, getList());

                    } else {
                        switchDisplayable(null, getList());
                    }

                }
            } else {
                list.append(lists, null);
                this.SMBAdd(sd);
                switchDisplayable(null, getList());
            }
        }

    }

    private void SMBAdd(dataConnetion dc) {

        try {
            SMBRec = RecordStore.openRecordStore("StoreSMB", true);
            RecordEnumeration rec = SMBRec.enumerateRecords(null, null, false);
            byte[] oppw = dc.getByte();
//            try {
            boolean trovato = false;
            for (int ii = 0; ii < rec.numRecords(); ii++) {
                int ind = rec.nextRecordId();
                byte[] opps = SMBRec.getRecord(ind);
                dataConnetion newss = new dataConnetion(opps);
                if (newss.nomeC.equals(dc.nomeC)) {
                    trovato = true;
                    break;
                }
            }
            if (!trovato) {
                SMBRec.addRecord(oppw, 0, oppw.length);
            }
//            } //catch (RecordStoreNotOpenException e) {e.printStackTrace();}
//            //catch (RecordStoreFullException e) {e.printStackTrace();}
//            catch (Exception e) {
//                Alert a = new Alert("Errore nel record store codDebug Pn00");
//                a.setString(e.getMessage());
//                a.setTimeout(Alert.FOREVER);
//                this.getDisplay().setCurrent(a);
//            }
            SMBRec.closeRecordStore();
        } catch (RecordStoreNotOpenException e) {
            e.printStackTrace();
        } catch (RecordStoreException e) {
            e.printStackTrace();
        }
    }

    private void SMBList() {
        byte[] array;
        try {
            //Apro il record dei prof salvati
            SMBRec = RecordStore.openRecordStore("StoreSMB", true);
            RecordEnumeration re = SMBRec.enumerateRecords(null, null, false);
            //Se c'Ã¨ ne sono
            if (re.numRecords() > 0) {
                //finche c'Ã¨ ne sono
                while (re.hasNextElement()) {
                    array = SMBRec.getRecord(re.nextRecordId());
                    dataConnetion dc = new dataConnetion(array);
                    //inserisci la notizia nella lista
                    if (list != null) {
                        for (int i = 0; i < list.size(); i++) {
                            if (!(list.getString(i).equals(dc.nomeC + "[" + dc.host + "]"))) {
                                list.append(dc.nomeC + "[" + dc.host + "]", null);
                            }
                        }
                    } else {
                        list.append(dc.nomeC + "[" + dc.host + "]", null);
                    }
                }
            } else {
                //Alert Db Ã¨ Vuoto
                // mDisplay.setCurrent(alert1);
                // this.getDisplay().setCurrent(new Alert("db Vuoto"));
                // return;
            }
            SMBRec.closeRecordStore();
        } catch (RecordStoreFullException e) {
            e.printStackTrace();
        } catch (RecordStoreNotFoundException e) {
            e.printStackTrace();
        } catch (RecordStoreException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cancellaprof() {
        byte[] array;
        try {
            SMBRec = RecordStore.openRecordStore("StoreSMB", true);
            RecordEnumeration rec = SMBRec.enumerateRecords(null, null, false);
            for (int i = 0; i < list.size(); i++) {
                int rid = rec.nextRecordId();
                array = SMBRec.getRecord(rid);


                if (list.isSelected(i)) {
                    try {


                        dataConnetion dc = new dataConnetion(array);
                        textField5.setString(dc.nomeC);
                        textField.setString(dc.host);
                        textField1.setString(dc.porta);
                        textField2.setString(dc.user);
                        textField3.setString(dc.passwd);
                        textField4.setString(dc.dominio);
                        list.delete(i);
                        SMBRec.deleteRecord(rid);
                    } //catch (RecordStoreNotOpenException e) {e.printStackTrace();}
                    //catch (RecordStoreFullException e) {e.printStackTrace();}
                    catch (Exception e) {
                        Alert a = new Alert("Errore nel record store codDEBUG cS ");
                        a.setString(e.getMessage());
                        a.setTimeout(Alert.FOREVER);
                        this.getDisplay().setCurrent(a);
                    }
                }
            }
        } catch (RecordStoreException e) {
            e.printStackTrace();
        }
        try {
            SMBRec.closeRecordStore();
        } catch (RecordStoreNotOpenException e) {
            e.printStackTrace();
        } catch (RecordStoreException e) {
            e.printStackTrace();
        }
    }

    private void populateform() {
        try {

            // this is really bad code ... please rewrite this!

            Enumeration drives = FileSystemRegistry.listRoots();
            System.out.println("The valid roots found are: ");
            String firstRoot = null;
            int cnt = 0;
            while (drives.hasMoreElements()) {
                String root = (String) drives.nextElement();
                System.out.println("\t" + root);
                String vendor = System.getProperty("microedition.platform");
                if ((vendor.toLowerCase().indexOf("nokia") >= 0) && (root.indexOf("C:") >= 0)) {
                  //  choiceGroup.append(root + "/Data/", this.getImagedir());
                } else {
                    choiceGroup.append(root, this.getImagedir());
                }


                cnt++;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
// * <blockquote><pre>
// *     smb://[[[domain;]username[:password]@]server[:port]/[[share/[dir/]file]]][?[param=value[param2=value2[...]]]
// * </pre></blockquote>

    private void connect1() {
        SMBStore mfs2 = new SMBStore(getProfiloSel());
        mfs1 = new FSStore(choiceGroup.getString(choiceGroup.getSelectedIndex()));

        localView.setFileStore(mfs1);
        localView.setOtherFileStore(mfs2);
        localView.setFileman(this);
        this.getDisplay().setCurrent(localView);
        remoteView.setFileman(this);
        remoteView.setFileStore(mfs2);
        remoteView.setOtherFileStore(mfs1);



    }

    public void switchView() {
        if (this.getDisplay().getCurrent() == localView) {
            this.getDisplay().setCurrent(remoteView);
        } else {
            localView.setFileStore(mfs1);
            this.getDisplay().setCurrent(localView);
        }
    }

    private String getProfiloSel() {
        dataConnetion dc = null;
        byte[] array;
        try {
            SMBRec = RecordStore.openRecordStore("StoreSMB", true);
            RecordEnumeration rec = SMBRec.enumerateRecords(null, null, false);
            for (int i = 0; i < list.size(); i++) {
                int rid = rec.nextRecordId();
                array = SMBRec.getRecord(rid);


                if (list.isSelected(i)) {
                    try {


                        dc = new dataConnetion(array);

                    } //catch (RecordStoreNotOpenException e) {e.printStackTrace();}
                    //catch (RecordStoreFullException e) {e.printStackTrace();}
                    catch (Exception e) {
                        Alert a = new Alert("Errore nel record store codDEBUG cS ");
                        a.setString(e.getMessage());
                        a.setTimeout(Alert.FOREVER);
                        this.getDisplay().setCurrent(a);
                    }
                }
            }
        } catch (RecordStoreException e) {
            e.printStackTrace();
        }
        try {
            SMBRec.closeRecordStore();
        } catch (RecordStoreNotOpenException e) {
            e.printStackTrace();
        } catch (RecordStoreException e) {
            e.printStackTrace();
        }
        System.out.println("siamo" + dc.host + " " + dc.user);

        return "smb://" + dc.dominio + ";" + dc.user + ":" + dc.passwd + "@" + dc.host + ":" + dc.porta + "/";
    }

    public Image getImagedir() {
        if (image3 == null) {
            // write pre-init user code here
            try {
                image3 = Image.createImage("/folder50.png");
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            // write post-init user code here
        }
        return image3;
    }
}
