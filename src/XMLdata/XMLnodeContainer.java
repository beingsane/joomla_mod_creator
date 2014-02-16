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
public class XMLnodeContainer {

    private String name = "";
    private dataDoubleList data = new dataDoubleList();

    public XMLnodeContainer() {
    }

    public XMLnodeContainer(String name) {
        this.name = name;
    }

    public XMLnodeContainer(String name, dataDoubleList data){
        this.name = name;
        this.data = data;
    }

    public dataDoubleList getData() {
        return data;
    }

    public void setData(dataDoubleList data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
