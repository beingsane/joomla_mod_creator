/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package runtimeHanlder;

/**
 *
 * @author histtech
 */
public class osChecker {
    private String OS = "";
    private String fileSeparator = "";

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getFileSeparator() {
        return fileSeparator;
    }

    public void setFileSeparator(String fileSeparator) {
        this.fileSeparator = fileSeparator;
    }
    //private String

    
    public void checkOS(){
       // System.getProperties().list(System.out);
        OS = System.getProperty("os.name");
        fileSeparator = System.getProperty("file.separator");
    }
    

}
