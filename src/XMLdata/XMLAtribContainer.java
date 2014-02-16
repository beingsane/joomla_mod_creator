/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XMLdata;

import dataStrucures.dataDoubleList;

/**
 *
 * @author user
 */
public class XMLAtribContainer {

    private String name = "";
    private dataDoubleList Atribs = new dataDoubleList();

    public XMLAtribContainer(){
        
    }
    
    public XMLAtribContainer(String name){
        this.name = name;
        
    }

    public XMLAtribContainer(String name, dataDoubleList atribs){
        this.name = name;
        this.Atribs = atribs;
    }




    public dataDoubleList getAtribs() {
        return Atribs;
    }

    public void setAtribs(dataDoubleList Atribs) {
        this.Atribs = Atribs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

}
