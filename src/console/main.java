/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import logger.loggerClass;

/**
 *
 * @author Travis
 */
public class main extends JFrame implements Runnable {

   // private resourceHandler executor;
    private JTextField enterField;
    private JTextArea displayArea;
    private String console_name = "System Console:";
    private logger.loggerClass logger;
   // private commandInterpreter CI = new commandInterpreter();
    private TextAreaOutputStream textout;

    public main() {
        super("main");
        super.setTitle("Console");
        //hostServer = host;

        enterField = new JTextField();
        enterField.setEditable(false);
        enterField.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        // sendDataObject(e.getActionCommand());
                        runCommand(enterField.getText());
                        enterField.setText("");
                    }
                });
        add(enterField, BorderLayout.NORTH);

        logger = new loggerClass(this);
        displayArea = new JTextArea();
        textout = TextAreaOutputStream.getInstance(displayArea, logger);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        displayArea.setEditable(false);
        setSize(300, 150);
        setVisible(true);
        
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }//end constuctor

//================
    

   
//================
//===============================================================

    public void run() {
        // throw new UnsupportedOperationException("Not supported yet.");
    }
//=============================================================

    public void appendToConsole(String s) {
        logger.appendToLog(s);
        displayArea.append(s + "\n");
    }
    //===============================

    public void setEditable(boolean var) {
        enterField.setEditable(var);
    }
    //============================================

    public void runCommand(String s) {
        appendToConsole(console_name + s);
        String c;
        if (s.contains("-")) {
            StringTokenizer token = new StringTokenizer(s, "-");
            c = token.nextToken().trim();
            String[] flags = new String[token.countTokens()];
            int i = 0;
            while (token.hasMoreTokens()) {
                flags[i] = token.nextToken().trim();
                i++;
            }
          //  CI.setFlags(flags);
        }//end if
        else {
          //  CI.setFlags(null);
            c = s;
        }

        if (c.compareToIgnoreCase("shutdown") == 0) {
            System.exit(0);
        //} else if (executor.checkCommand(c)) {
          //  CI.setCommand(c);
            //CI.runCommand();
        } else {
            appendToConsole(console_name + " Command Not Found->" + s);
        }
    }
    //===========================================
}
