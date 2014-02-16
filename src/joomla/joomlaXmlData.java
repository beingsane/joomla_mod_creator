/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joomla;

import XMLparser.XMLCreator;
import directoryParser.dirParser;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author histtech
 */
public class joomlaXmlData {

    public String name;
    public String author;
    public String creationDate;
    public String copyright;
    public String license;
    public String authorEmail;
    public String authorUrl;
    public String version;
    public String discription;
    public XMLCreator xmlcreate;
    public String path;
    public dirParser dp;

    public joomlaXmlData(String name,
            String author,
            String creationDate,
            String copyright,
            String license,
            String authorEmail,
            String authorUrl,
            String version,
            String discription) {
        //System.out.println(name);
        this.name = name;
        this.author = author;
        this.creationDate = creationDate;
        this.copyright = copyright;
        this.license = license;
        this.authorEmail = authorEmail;
        this.authorUrl = authorUrl;
        this.version = version;
        this.discription = discription;

    //System.out.println(path);


    }

    public int setPath(String path, Component c) {
        this.path = path;
        this.xmlcreate = new XMLCreator(this.name, path);
        dp = new dirParser(this.path, this.name);
        this.createData();
        JOptionPane.showMessageDialog(c, "File Created");
        return 0;
    }

    public void createData() {
        this.xmlcreate.addStringToFile("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n\r" +
                "<install type=\"module\" version=\"1.5.0\">\n\r" +
                "   <!-- Name of the Module -->\n\r" +
                "  <name>" + this.name + "</name>\n\r" +
                "   <!-- Name of the Author -->\n\r" +
                "  <author>" + this.author + "</author>\n\r" +
                "   <!-- Version Date of the Module -->\n\r" +
                "  <creationDate>" + this.creationDate + "</creationDate>\n\r" +
                "   <!-- Copyright information -->\n\r" +
                "  <copyright>" + this.copyright + "</copyright>\n\r" +
                "   <!-- License Information -->\n\r" +
                "  <license>" + this.license + "</license>\n\r" +
                "   <!-- Authors email address -->\n\r" +
                "  <authorEmail>" + this.authorEmail + "</authorEmail>\n\r" +
                "<!-- Authors website -->\n\r" +
                "  <authorUrl>" + this.authorUrl + "</authorUrl>\n\r" +
                "   <!-- Module version number -->\n\r" +
                "  <version>" + this.version + "</version>\n\r" +
                "   <!-- Description of what the module does -->\n\r" +
                "   <description>" + this.discription + "</description>\n\r" +
                "  <!-- Listing of all files that should be installed for the module to function -->\n\r" +
                " <files>" + this.dp.xml + "\n\r" +
                "</files>\n\r</install>\n\r");


    }
}
