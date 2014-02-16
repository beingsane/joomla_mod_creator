package logger;

import console.main;
//import fileIO.text;
import dateTime.keeper;
import java.io.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author histtech
 */
public class loggerClass {

    private String logName;
    private keeper dateTimeKeeper = new keeper();
    private File currentLogFile;
    private PrintWriter buffWriter;
    private console.main console;
    private boolean writeFlag = false;

    //===================================
    public loggerClass(main console) {

        this.console = console;

          /*if (System.getProperties().getProperty("os.name").contains("windows") || System.getProperties().getProperty("os.name").contains("Windows")) {
          //  System.out.println("C://Program Files/filemakerImporter/appInfo.pkf");
            logName = "C:/Program Files/XML_Data_Importer/LOG.txt";
        } else if (System.getProperties().getProperty("os.name").contains("mac")) {
           // System.out.println("/filemaker_importer/appInfo.pkf");
            logName = "/XML_Data_Importer/LOG.txt";
        } else {*/
           // System.out.println("appInfo.pkf");
            logName = "LOG.txt";
        //}

        
        currentLogFile = new File(logName);

        try {
            if (currentLogFile.createNewFile() || currentLogFile.exists()) {
                try {
                    if(currentLogFile.exists()){

                        buffWriter = new PrintWriter(new FileWriter(currentLogFile, true));
                    }
                    else{
                        buffWriter = new PrintWriter(currentLogFile);
                    }
                    writeFlag = true;
                } catch (FileNotFoundException ex) {
                    System.out.println(ex.toString());
                    console.appendToConsole("ERROR OPENING LOG: " + ex.toString());
                }
                createDateHeader();
            }
        } catch (IOException ex) {

            System.out.println(ex.toString());
            console.appendToConsole("ERROR OPENING LOG: " + ex.toString());
        }



    }
    //===================================

    public void createDateHeader() {
        appendToLog("****************************************************");
        appendToLog("******************[" + dateTimeKeeper.getISOformatDash() + " : " + dateTimeKeeper.getTimeFormatMil() + "]***********");
        appendToLog("****************************************************");
    }

    //====================================
    public void appendToLog(String s) {
        if (writeFlag) {
            buffWriter.append(s + "\r\n");
            buffWriter.flush();
        }

    }
    //=================================

    public void appendToLogNoLineBreak(char c) {
        if (writeFlag) {
            buffWriter.append(c);
            buffWriter.flush();
        }

    }
//======================================

    public void closeLog() {
        buffWriter.close();

    }
}
