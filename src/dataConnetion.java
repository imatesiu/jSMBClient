/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mart3
 */
public class dataConnetion {

    public String nomeC =null;
    public String host =null;
    public String user =null;
    public String passwd=null;
    public String porta=null;
    public String dominio=null;

    public dataConnetion(String nc, String h, String p,String u, String pwd, String dom) {
        this.nomeC = nc;
        this.host = h;
        this.porta = p;
        this.user = u;
        this.passwd = pwd;
        this.dominio = dom;
    }
    public  dataConnetion(byte[] bite) {
        String df = new String(bite);
        int mi = df.indexOf("++");
        int i = df.indexOf("[");
        int ii = df.indexOf("]");
        int i3 = df.indexOf("{");
        int i4 = df.indexOf("}");
        nomeC = df.substring(0, mi);
        host = df.substring(mi + 2, i);
        porta = df.substring(i + 1, ii);
        user = df.substring(ii + 1, i3);
        passwd = df.substring(i3 + 1, i4);
        dominio = df.substring(i4 + 1, df.length());
    }
      public byte[] getByte() {
        String te = nomeC + "++" + host + "[" + porta + "]" + user + "{" + passwd + "}" + dominio;
        return te.getBytes();
    }
}
