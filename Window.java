
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
 */
public class Window {
	// Creating instance of JFrame
	JFrame mainWindow;
	ArrayList<Characters> WindowData;

	public Window(ArrayList<Characters> list) {
		obtainData(list);
		CreateMainWindow();
	}

	public void obtainData(ArrayList<Characters> myList) {
		WindowData = myList;
	}

	/**
	 * Method that creates window
	 * 
	 * @param none
	 * @return none
	 */
	private void CreateMainWindow() {
		// Creating JFrame
		mainWindow = new JFrame("GGFrames");// Creates instnace of JFrame and assigns window name
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Close operation
		mainWindow.setSize(1280, 800);// Determines size of window
		mainWindow.setLayout(new BorderLayout());
		mainWindow.setLocationRelativeTo(null);// Opens window in the center of the screen
		mainWindow.setVisible(true);// Displays window
		mainWindow.getContentPane().setBackground(Color.black);
		LoadingScreen();
	}// End of create method
	
	private void LoadingScreen()
	{
		JLabel load = new JLabel("Loading...", SwingConstants.CENTER);
		JPanel quickText = new JPanel(new BorderLayout());
		quickText.add(load, BorderLayout.CENTER);
		mainWindow.add(quickText, BorderLayout.CENTER);
	}
	/**
	 * Clears Screen then calls either create frame data or returns to main menu
	 * 
	 * @param mode
	 *            Determines weather to call CreateMainWindow method or
	 *            CreateFrameData method
	 * @param char_selected
	 *            Determines what character was clicked
	 * @return none
	 **/
	private void ClearScreen(boolean mode, int char_selected) {
		// Clearing screen
		mainWindow.removeAll();
		mainWindow.revalidate();
		// Calling either CreateFrameData or CreateMainWindow method
		int character = char_selected;
		if (mode == false) {
			// CreateFrameData(character);
		} // Creates FrameData table
		else {
			CreateMainWindow();
		} // Returns to main menu
	}// End of ClearScreen method

	/**
	 * method that creates quitButton
	 * 
	 * @param none
	 * @return none
	 */
	private void quitButton() {
		// Creating Bottom Menu Jpanel
		JPanel bot_menu = new JPanel(new GridBagLayout());
		bot_menu.setPreferredSize(new Dimension(100, 100));
		// Creating exit button
		JButton Quit_button = new JButton("Quit");
		// Setting dimensions for quit button
		Quit_button.setPreferredSize(new Dimension(70, 30));
		// Styling Quit Button
		Quit_button.setBackground(Color.red);
		// Adding click action to quit button
		Quit_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				mainWindow.dispose();
			}
		});// End of ActionListener
			// Adding buttons to Jpanel
		bot_menu.add(Quit_button);
		mainWindow.add(bot_menu, BorderLayout.SOUTH);
	}// End of method quitButton

	/**
	 * Creates buttons
	 * 
	 * @param none
	 * @return none
	 */
	public void MainMenuCreation() {
		// Creating label Chara_menu
		JLabel chara_menu = new JLabel("Character Select", SwingConstants.CENTER);
		//Creating JPanel title
		JPanel menu_title = new JPanel(new BorderLayout());
		menu_title.setPreferredSize(new Dimension(200,800));
		//Addint JLabel chara_menu to JPanel menu_title
		menu_title.add(chara_menu);
		// Creating JPanel character_select
		JPanel character_select = new JPanel();
		character_select.add(chara_menu);
		//Grid dimensions
		final int GRID_ROW = 5;//Number of rows in gridlayout
		final int GRID_COL = 5;//Number of columns in gridlayout
		final int GRID_HGAP = 10;//Hgap size in gridlayout
		final int GRID_WGAP = 10;//Wgap size in gridlayout
		// Setting layout for JPanel character_select to GridBagLayout
		character_select.setLayout(new GridLayout(GRID_ROW,GRID_COL,GRID_HGAP,GRID_WGAP));
		// ImageIcon BaikenIcon = new ImageIcon("Baiken.png");
		// Creating character buttons
		ArrayList<JButton> Char_buttons = new ArrayList<JButton>();
		// Incrementor for while loop
		int d = 0;
		// While loop to add JButtons to JPanel
		while (d < WindowData.size()) {
			Char_buttons.add(new JButton(WindowData.get(d).getName()));// Adding JButton to ArrayList Char_buttons
			character_select.add(Char_buttons.get(d));// Adding JButtons to JPanel
			d++;// Incrementing
		} // End of while loop
		quitButton();// Calls method to create quit button
		mainWindow.add(menu_title, BorderLayout.CENTER);//Adding JPanel
		mainWindow.add(character_select);// Adding JPanel
		mainWindow.revalidate();// Revalidating JFrame
	}// End of MainMenuCreation method
}// End of class Window
