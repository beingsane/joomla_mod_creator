/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package XMLdata;

/**
 *
 * @author user
 */
public class XMLnodeData {
    private String name = "";
    private String value = "";
    private String textContext = "";

    public XMLnodeData(String name, String value, String textContext){
        this.name = name;
        this.value = value;
        this.textContext = textContext;
    }

    public String getName() {
        return name;
    }

    public void setTextContext(String textContext) {
        this.textContext = textContext;
    }

    public String getTextContext() {
        return textContext;
    }

    public String getValue() {
        return value;
    }


    

}
