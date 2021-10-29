/**
* Printout class that contains various printout statements in accordance to
* the style, colour scheme and format that maven uses.
*
* @author Shaun Oosthuizen
*/

package VoIP.Misc;
import java.util.Collections;

public class PrintOut {

    /**Global terminal style reset.*/
    private static final String ANSI_RESET = "\u001B[0m";
    /**Global terminal bold setting.*/
    private static final String ANSI_BOLD = "\u001B[1m";
    /**Global terminal colour setting.*/
    private static final String ANSI_RED = "\u001B[31m";
    /**Global terminal colour setting.*/
    private static final String ANSI_GREEN = "\u001B[32m";
    /**Global terminal colour setting.*/
    private static final String ANSI_BLUE = "\u001B[34m";

    /**
     * Formats and prints the output error message.
     * @param message
     */
    public static void printError(String message) {
        String line = String.join("", Collections.nCopies(71, "-"));
        String errorFormat = "[" + ANSI_RED + ANSI_BOLD + "ERROR" + ANSI_RESET + "] ";
        System.out.println(errorFormat + ANSI_BOLD + line + ANSI_RESET);
        System.out.println(errorFormat + ANSI_RED + ANSI_BOLD + message + ANSI_RESET);
        System.out.println(errorFormat + ANSI_BOLD + line + ANSI_RESET);
        //System.exit(1);
    }

    /**
     * Formats and prints the output info message.
     * @param message
     */
    public static void printInfo(String message) {
        String line = String.join("", Collections.nCopies(72, "-"));
        String infoFormat = "[" + ANSI_BLUE + ANSI_BOLD + "INFO" + ANSI_RESET + "] ";
        System.out.println(infoFormat + ANSI_BOLD + line);
        System.out.println(infoFormat + ANSI_GREEN + ANSI_BOLD +
        message + ANSI_RESET);
        System.out.println(infoFormat + ANSI_BOLD + line + ANSI_RESET);
    }
}
