/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dateTime;

import java.text.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Travis
 */
public class keeper {
    private static String ISOdateNoDash;
    private static String ISOdateDash;
    private static Date currentDate;
    private static String timeTweleve;
    private static String timeMil;
    //=====================formats
    private static SimpleDateFormat ISOformatDash = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat ISOformatNoDash = new SimpleDateFormat("yyyyMMdd");
    private static SimpleDateFormat timeFormatTweleve = new SimpleDateFormat("hh:mm:ss a");
    private static SimpleDateFormat timeFormatMil = new SimpleDateFormat("kk:mm:ss");
    //==================================================================== 
    public String getISOformatDash(){
           currentDate = new Date();
           ISOdateDash = ISOformatDash.format(currentDate);
        return ISOdateDash;
    }
    //==================================================================
    public String getISOformatDash(Date setDate){
           currentDate = setDate;
           ISOdateDash = ISOformatDash.format(currentDate);
        return ISOdateDash;
    }
    //=================================================================
    public Date swapISOformatDash(String isoDash){
        try {
            return ISOformatDash.parse(isoDash);
        } catch (ParseException ex) {
            System.out.println(ex.toString());
           // Logger.getLogger(keeper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //====================================================================
    public String getISOformatNODash(){
           currentDate = new Date();
           ISOdateNoDash = ISOformatNoDash.format(currentDate);
        return ISOdateNoDash;
    }
    //===================================================================
    public String getTimeFormatTweleve(){
            currentDate = new Date();
            timeTweleve = timeFormatTweleve.format(currentDate);
            return timeTweleve;
    }
     //===================================================================
     public String getTimeFormatMil(){
            currentDate = new Date();
            timeMil = timeFormatMil.format(currentDate);
            return timeMil;
     }
     //===================================================================
}
