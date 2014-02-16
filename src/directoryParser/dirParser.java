/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package directoryParser;

import java.io.File;

public class dirParser {

    public String xml = "";
    public String name = "";

    public dirParser(String file, String name) {
        this.name = name;
        File folder = new File(file);
        File[] listOfFiles = folder.listFiles();
        listIn(listOfFiles, 0, "");


    }

    public void listIn(File[] listOfFiles, int depth, String parent) {
        String cmp = "mod_" + this.name + ".php";
        String tmp;
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                tmp = "";
                tmp = listOfFiles[i].getName();
                if (cmp.compareTo(tmp) == 0) {
                    xml = xml + "<filename module=\"mod_" + name + "\">" + parent + listOfFiles[i].getName() + "</filename>\n\r";
                } else {
                    xml = xml + "<filename>" + parent + listOfFiles[i].getName() + "</filename>\n\r";
                }

            } else if (listOfFiles[i].isDirectory()) {
                listIn(listOfFiles[i].listFiles(), depth++, parent + listOfFiles[i].getName() + File.separator);
            }
        }
    }
}