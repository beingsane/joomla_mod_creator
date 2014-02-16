/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XMLparser;

import directoryParser.dirParser;
import fileIO.stream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author histtech
 */
public class XMLCreator {

    File file;
    PrintWriter buffWriter;

    public XMLCreator(String name, String path) {

        try {
            file = new File(path +file.separator + "mod_" + name + ".xml");
            file.createNewFile();
            buffWriter = new PrintWriter(file);
        } catch (IOException ex) {
            System.out.println(ex.toString());
            //Logger.getLogger(XMLCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }

    public void addStringToFile(String add) {
       // System.out.println(add);
        
              buffWriter.append(add);
              buffWriter.flush();
              buffWriter.close();

    }
}
