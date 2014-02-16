/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package joomla_mod_creator;
import gui.*;
/**
 *
 * @author histtech
 */
public class Main {
    public static mainWindow mw;

    public static void main(String[] main){
        mw = new mainWindow();
        mw.setConsole(new console.main());
        mw.openWidnow();
        
    }


}
