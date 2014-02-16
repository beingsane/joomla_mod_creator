/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XMLparser;

import XMLdata.XMLnodeData;
import XMLdata.XMLAtribData;
import XMLdata.XMLAtribContainer;
import XMLdata.XMLdataNode;
import XMLdata.XMLnodeContainer;
import dataStrucures.dataDoubleList;
import dataStrucures.dataListNode;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Travis
 */
public class XMLParser {

    private  dataDoubleList parsedxml;
    private  File file;
    private boolean error = false;
    private Component c;
    public dataDoubleList getParsedxml() {
        return parsedxml;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }


    

    private  void parseData() {
        parsedxml = new dataDoubleList();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            //+++++++++++++++++++++++++++++++++++++++

            parseDoc(doc);

        } catch (ParserConfigurationException ex) {
            error = true;
            JOptionPane.showMessageDialog(c, "Invalid XML or FileMaker Document, Import will not proceed\nParser error:" + ex.toString());
            System.out.println(ex.toString());
        } catch (SAXException ex) {
            error = true;
            JOptionPane.showMessageDialog(c, "Invalid XML or FileMaker Document, Import will not proceed\nParser error:" + ex.toString());
            System.out.println(ex.toString());
        } catch (IOException ex) {
            error = true;
            JOptionPane.showMessageDialog(c, "Invalid XML or FileMaker Document, Import will not proceed\nParser error:" + ex.toString());
            System.out.println(ex.toString());
        }




    }
    //=====================================================

    private  XMLnodeContainer buildNodeContainer(Node dat) {
        XMLnodeContainer cont = new XMLnodeContainer(dat.getNodeName());
        dataListNode val = new dataListNode();
        XMLnodeData data = new XMLnodeData(dat.getNodeName(), dat.getNodeValue(), dat.getTextContent());
        val.setContainer(data);
        cont.getData().insertNode(val);
        return cont;
    }
    //=====================================================

    private  void addDataToNodeContainer(XMLnodeContainer node, Node data) {
        XMLnodeData dataCon = new XMLnodeData(data.getNodeName(), data.getNodeValue(), data.getTextContent());
        dataListNode con = new dataListNode();
        con.setContainer(dataCon);
        node.getData().insertNode(con);
    }

    //=====================================================
    private  XMLAtribContainer buildAtribContainer(Node dat) {
        XMLAtribContainer cont = new XMLAtribContainer(dat.getNodeName());

        return cont;
    }

    private  void addAtribToContainer(XMLAtribContainer contain, String atribName, String value) {
        dataListNode atribCon = new dataListNode();
        XMLAtribData data = new XMLAtribData(atribName, value);
        atribCon.setContainer(data);
        contain.getAtribs().insertNode(atribCon);
    }


    //=====================================================
    private  void parseDoc(Document doc) {
        int depth = 0;
        Node fn = doc.getFirstChild();
        XMLnodeContainer fncon = buildNodeContainer(fn);


        dataListNode confd = new dataListNode();
        confd.setContainer(fncon);
        XMLdataNode currentNode = new XMLdataNode("xmlnodecontainer", confd, depth);
        confd = new dataListNode();
        confd.setContainer(currentNode);
        parsedxml.insertNode(confd);

        //System.out.println(fn.getNodeName() + "~first node name");
        //System.out.println(fn.getNodeValue());




        if (fn.hasAttributes()) {
            checkAllAtrib(fn, depth);
        }
        if (fn.hasChildNodes()) {
            getAllChilds(fn, (depth + 1));
        }

    }
    //==========================================

    private  void checkAllAtrib(Node cn, int depth) {
        NamedNodeMap nnm = cn.getAttributes();
        Node nnn;
       // System.out.println("--Atrib--");
        XMLAtribContainer atribCon = buildAtribContainer(cn);
        for (int i = 0; i < nnm.getLength(); i++) {
            nnn = nnm.item(i);
            addAtribToContainer(atribCon, nnn.getNodeName(), nnn.getNodeValue());
            //System.out.println(nnn.getNodeName() + " ~atrib name");
            //System.out.println(nnn.getNodeValue());

        }

        dataListNode confd = new dataListNode();
        confd.setContainer(atribCon);
        XMLdataNode currentNode = new XMLdataNode("xmlatribcontainer", confd, depth);
        confd = new dataListNode();
        confd.setContainer(currentNode);
        parsedxml.insertNode(confd);

        //System.out.println("----");

    }

    //==========================================
    private  void getAllChilds(Node cn, int depth) {
        NodeList nl = cn.getChildNodes();
        Node cln;
        //System.out.println(" --Node-- depth: " + depth);
        XMLnodeContainer con;
        for (int i = 0; i < nl.getLength(); i++) {
            cln = nl.item(i);
            con = buildNodeContainer(cln);


            dataListNode confd = new dataListNode();
            confd.setContainer(con);
            XMLdataNode currentNode = new XMLdataNode("xmlnodecontainer", confd, depth);
            confd = new dataListNode();
            confd.setContainer(currentNode);
            parsedxml.insertNode(confd);

            //System.out.println(cln.getNodeName() + " ~node name");
            //System.out.println(cln.getNodeValue());
            //System.out.println(cln.getTextContent());
            //System.out.println("*****");
            //System.out.println(cln.get);
            if (cln.hasAttributes()) {
                checkAllAtrib(cln, depth);
            }
            if (cln.hasChildNodes()) {
                getAllChilds(cln, (depth + 1));
            }
        }
    }
//========================================
    public XMLParser(File f, Component c){
        this.file = f;
        this.c = c;
        parseData();
        
    }

    //public  void main(String[] args) {
        //parseData();
        //System.out.println("Node count" + parsedxml.getNodeCount());
    //}
 //===============================
}
