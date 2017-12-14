/**
 * Class that JFrame functions will take place in
 *
 * @author(ImaginatixnLXIV)
 * @version(8/25/17)
 */

import javax.swing.*;//Import JFrame functions
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Class that handles all JFrame Functions
 * */
public class Window {
    //Creating instance of JFrame
    JFrame mainWindow;
    ArrayList <Characters> WindowData;
    public Window(ArrayList <Characters> list)
    {
        obtainData(list);
        CreateMainWindow();
    }
    public void obtainData(ArrayList <Characters> myList)
    {
        WindowData = myList;

    }
    /**
     * Method that creates window
     * @param none
     * @return none
     * */
    private void CreateMainWindow() {
        //Creating JFrame
        mainWindow = new JFrame("GGFrames");//Creates instnace of JFrame and assigns window name
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Close operation
        mainWindow.setSize(800, 600);//Determines size of window

        mainWindow.setLocationRelativeTo(null);//Opens window in the center of the screen
        mainWindow.setVisible(true);//Displays window
        mainWindow.getContentPane().setBackground(Color.black);
        MainMenuCreation();//Creates Buttons for Character Menu
    }//End of create method

    /**
     * Clears Screen then calls either create frame data or returns to main menu
     * @param mode Determines weather to call CreateMainWindow method or CreateFrameData method
     * @param char_selected Determines what character was clicked
     * @return none
     **/
    private void ClearScreen(boolean mode, int char_selected)
    {
        //Clearing screen
        mainWindow.removeAll();
        mainWindow.revalidate();
        //Calling either CreateFrameData or CreateMainWindow method
        int character = char_selected;
        if(mode == false)
        {
            //CreateFrameData(character);
        }//Creates FrameData table
        else
        {
            CreateMainWindow();
        }//Returns to main menu
    }//End of ClearScreen method

    /**
     * method that creates quitButton
     * @param none
     * @return none
     */
    private void quitButton()
    {
        //Creating Bottom Menu Jpanel
        JPanel bot_menu = new JPanel(new GridBagLayout());
        bot_menu.setPreferredSize(new Dimension(100,100));
        //Creating exit button
        JButton Quit_button = new JButton("Quit");
        //Setting dimensions for quit button
        Quit_button.setPreferredSize(new Dimension(70,70));
        //Styling Quit Button
        Quit_button.setBackground(Color.red);
        //Adding click action to quit button
        Quit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainWindow.dispose();
            }
        });
        //Adding buttons to Jpanel
        bot_menu.add(Quit_button);
        mainWindow.add(bot_menu, BorderLayout.SOUTH);
    }
    /**
     * Creates buttons
     * @param none
     * @return none
     */
    public void MainMenuCreation() {
        //Creating GridBagConstraints
        GridBagConstraints c = new GridBagConstraints();
        //Creating label Chara_menu
        JLabel chara_menu = new JLabel("Character Select", JLabel.CENTER);
        //Constants for button size
        final int BUTTON_HEIGHT = 100;
        final int BUTTON_WIDTH = 100;
        //Creating JPanel character_select
        JPanel character_select = new JPanel(new GridBagLayout());
        //Adding JLabel to character_select JPanel
        //character_select.add(main_label);
        //character_select.add(chara_menu);
        //Creating imageicon
        //ImageIcon BaikenIcon = new ImageIcon("Baiken.png");
        //Creating character buttons
        JButton Answer_button = new JButton(WindowData.get(0).getName());
        JButton Axl_button = new JButton(WindowData.get(1).getName());
        JButton Baiken_button = new JButton(WindowData.get(2).getName());
        JButton Bedman_button = new JButton(WindowData.get(3).getName());
        JButton Chipp_button = new JButton(WindowData.get(4).getName());
        JButton Dizzy_button = new JButton(WindowData.get(5).getName());
        JButton Elphelt_button = new JButton(WindowData.get(6).getName());
        JButton Faust_button = new JButton(WindowData.get(8).getName());
        JButton INo_button = new JButton(WindowData.get(9).getName());
        JButton JackO_button = new JButton(WindowData.get(10).getName());
        //Click Action for Character Buttons
        Baiken_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ClearScreen(false,2);//Calls ClearScreen method passing in false which means create frame data window
            }
        });
        //Setting Dimensions of button
        Baiken_button.setPreferredSize(new Dimension(200,200));
        //Decorating buttons
        Baiken_button.setBackground(Color.black);
        Baiken_button.setForeground(Color.white);
        //Adding buttons to panel
        character_select.add(Answer_button);
        character_select.add(Axl_button);
        character_select.add(Baiken_button);
        //Adding panel to JFrame
        quitButton();//Calls method to create quit button
        mainWindow.add(character_select);
        mainWindow.revalidate();
    }
}//End of class Window
