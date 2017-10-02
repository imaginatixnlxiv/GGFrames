/**
 * Class that JFrame functions will take place in
 *
 * @author(ImaginatixnLXIV)
 * @version(8/25/17)
 */

import javax.swing.*;//Import JFrame functions
import java.awt.*;

/**
 * Class that handles all JFrame Functions
 * */
public class Window {
    //Creating instance of JFrame
    JFrame mainWindow;

    public Window(String title) {
        //Calling creation methods
        CreateMainMenu();
        JMenuCreate();
        JButtonCreation(title);
    }

    /**
     * Method that creates window
     * @param none
     * @return none
     * */
    private void CreateMainMenu() {
        //Creating JFrame
        mainWindow = new JFrame("GGFrames");//Creates instnace of JFrame and assigns window name
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Close operation
        mainWindow.setSize(800, 600);//Determines size of window
        mainWindow.setLocationRelativeTo(null);//Opens window in the center of the screen
        mainWindow.setVisible(true);//Displays window
    }//End of create method

    /**
     * Menu bar creation
     * @param none
     * @return none
     */
    private void JMenuCreate() {
        //Creating instance of JMenuBar
        JMenuBar MenuBar = new JMenuBar();

    }//End of JMenuCreate

    /**
     * Creates buttons
     * @param none
     * @return none
     */
    private void JButtonCreation(String top_text) {
        //Creating main_label JLabel
        JLabel main_label = new JLabel(top_text, JLabel.CENTER);
        //Creating label Chara_menu
        JLabel chara_menu = new JLabel("Character Select", JLabel.CENTER);
        //Creating JPanel character_select
        JPanel character_select = new JPanel(new GridLayout());
        //Adding JLabel to character_select JPanel
        character_select.add(main_label);
        character_select.add(chara_menu);
        //Creating imageicon
        ImageIcon BaikenIcon = new ImageIcon("Baiken.png");
        //Creating character buttons
        JButton Baiken_button = new JButton("Baiken", BaikenIcon);
        character_select.add(Baiken_button);
        //Adding panel to JFrame
        mainWindow.add(character_select);
        mainWindow.revalidate();
    }
}//End of class Window
