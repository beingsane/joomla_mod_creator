/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package console;

import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JTextArea;
import logger.loggerClass;

/**
 *
 * @author Travis
 */
public class TextAreaOutputStream extends OutputStream {
    private static final TextAreaOutputStream INSTANCE = new TextAreaOutputStream();
    private static final PrintStream OUT;
    private static final PrintStream ERR;
    private static JTextArea outWriter;
    private static boolean TAINTED = false;
    private static logger.loggerClass logger;
    static {
        OUT = System.out;
        ERR = System.err;
        System.setOut(new PrintStream(new TextAreaOutputStream()));
        System.setErr(new PrintStream(new TextAreaOutputStream()));
    }

    /** Creates a new instance of TextAreaOutputStream. */
    public TextAreaOutputStream() {}

    /** Gets the output stream. */
    public static TextAreaOutputStream getInstance(JTextArea textArea, logger.loggerClass logger) {
        TextAreaOutputStream.logger = logger;
        outWriter = textArea;
        return INSTANCE;
    }

    /** Gets the functioning console output.
      * @see java.lang.System.out
      */
    public static PrintStream getOldSystemErr(){
        return ERR;
    }

    public static PrintStream getOldSystemOut() {
        return OUT;
    }

    /** Determines if output has occured. */
    public static boolean isTainted() {
        return TAINTED;
    }

    /** Write output to the Text Area. */
    public void write(int param) {
        outWriter.setText(outWriter.getText() + (char)param);
        logger.appendToLogNoLineBreak((char)param);
        TAINTED = true;
    }
}

