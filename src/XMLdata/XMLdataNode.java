/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package XMLdata;

import dataStrucures.dataDoubleList;
import dataStrucures.dataListNode;

/**
 *
 * @author Travis
 */
public class XMLdataNode {
    private int level = 0;
    private dataListNode data;
    private String type = "";

    public XMLdataNode(){

    }
    public XMLdataNode(String type, dataListNode data, int level){
        this.level = level;
        this.data = data;
        this.type = type;
    }

    public dataListNode getData() {
        return data;
    }

    public void setData(dataListNode data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public int getLevel() {
        return level;
    }

    

}
