/**
 * GG Frame data
 *
 * @author(ImaginatixnLXIV)
 * @version(8/19/17)
 **/

//Imports

import javax.swing.*;//Used for JFrame and JFrame related functions
import java.util.Scanner;//Scanner used for user input

/**
 * Main class
 **/
public class Main {
    /**
     * Main method
     * @param args default main argument
     * @return none
     **/
    public static void main(String[] args) {
        //Creating instance of Scanner
        Scanner user_input = new Scanner(System.in);
        //Input Verification
        boolean flag = false;
        //Creating instance of GGFrames
        GGFrames Frames = new GGFrames();
        //Checking if Dustloop is online
        Frames.check();
        //Creating title string
        String title = "";
        //Getting website <title> tag
        title = Frames.title();
        //Creating instance of Window class
        Window myWindow = new Window(title);
    }//End of main method
}//End of main class
