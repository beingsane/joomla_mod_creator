/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runtimeHanlder;

import joomla_mod_creator.Main;
import java.util.StringTokenizer;

/**
 *
 * @author histtech
 */
public class runtimeVersionChecker {

    private static errorWindow errWin = new errorWindow();
    private static int reqVersion = 16;

    private static int getVersion(){
          StringTokenizer st = new StringTokenizer(System.getProperty("java.version"), ".");
         String s;
         s = st.nextToken() + st.nextToken();
         return Integer.parseInt(s);
    }

    public static void main(String[] args) {
       // System.getProperties().list(System.out);
       int systemVer = getVersion();
        if (systemVer >= reqVersion) {

            joomla_mod_creator.Main.main(args);
        
        }
        else{
            errWin.getLabel1().setText("Java Runtime: " + reqVersion +" Requiered to run this Application");
            errWin.setVisible(true);
        }

    }
}
