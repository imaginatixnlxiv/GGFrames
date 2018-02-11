
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
		CreateMainWindow(true);
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
	private void CreateMainWindow(boolean start) {
		// Creating JFrame
		mainWindow = new JFrame("GGFrames");// Creates instnace of JFrame and assigns window name
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Close operation
		mainWindow.setSize(1280, 800);// Determines size of window
		mainWindow.setLayout(new BorderLayout());
		mainWindow.setLocationRelativeTo(null);// Opens window in the center of the screen
		mainWindow.setVisible(true);// Displays window
		mainWindow.getContentPane().setBackground(Color.black);
		if(start == true)
		{
			LoadingScreen();
		}
	}// End of create method
	
	
	/**
	 * Creates loading screen while data is scraped online
	 * @param none
	 * @return
	 */
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
	private void ClearScreen(boolean mode,  String char_selected) {
		// Clearing screen
		mainWindow.removeAll();
		mainWindow.revalidate();
		System.out.println("cls");
		// Calling either CreateFrameData or CreateMainWindow method
		String character = char_selected;
		if (mode == false) {
			CreateFrameData(character);
		} // Creates FrameData table
		else {
			CreateMainWindow(false);
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
		bot_menu.setBackground(Color.BLACK);
		mainWindow.add(bot_menu, BorderLayout.SOUTH);
	}// End of method quitButton

	
	/**
	 * Creates buttons
	 * 
	 * @param none
	 * @return none
	 */
	public void MainMenuCreation() {
		// Creating JPanel character_select
		JPanel character_select = new JPanel();
		character_select.setBackground(Color.black);
		//Grid dimensions
		final int GRID_ROW = 5;//Number of rows in gridlayout
		final int GRID_COL = 5;//Number of columns in gridlayout
		final int GRID_HGAP = 10;//Hgap size in gridlayout
		final int GRID_WGAP = 10;//Wgap size in gridlayout
		// Setting layout for JPanel character_select to GridBagLayout
		character_select.setLayout(new GridBagLayout());
		//GridBag Constraits
		GridBagConstraints Constraints = new GridBagConstraints();
		Constraints.gridheight = 1;
		Constraints.gridwidth = 1;
		Constraints.weightx = .0000001;
		Constraints.weighty = .0000001;
		// ImageIcon BaikenIcon = new ImageIcon("Baiken.png");
		// Creating character buttons
		ArrayList<JButton> Char_buttons = new ArrayList<JButton>();
		// Incrementor for while loop
		int d = 0;
		// While loop to adding JButtons to arraylist Char_buttons
		while (d < WindowData.size()) {
			Char_buttons.add(new JButton(WindowData.get(d).getName()));// Adding JButton to ArrayList Char_buttons
			Char_buttons.get(d).setPreferredSize(new Dimension(200,100));
			d++;// Incrementing
		} // End of while loop
		//For loop for adding ArrayList of JButtons to JPanel
		int inc = 0;//Incrementor for arraylist
		for(int col = 0; col < GRID_COL; col++)
		{
			Constraints.gridy = col;//Setting Column
			for(int row = 0; row < GRID_ROW; row++)
			{
				Constraints.gridx = row;//Setting row
				character_select.add(Char_buttons.get(inc), Constraints);//Adding button to specified column and row in JPanel
				inc++;//Incrementing Button ArrayList
			}//End of inner for loop
		}//End of outer for loop
		//For loop for setting color for buttons
		for(JButton colorize : Char_buttons)
		{
			colorize.setBackground(Color.decode("#1ca2db"));//Setting color to buttons as grey
		}//End of For each loop to decorate buttons
		//Adding action events
		ActionListener button_events = new ButtonClick();
		for(JButton button : Char_buttons)
		{
			button.addActionListener(button_events);
		}
		quitButton();// Calls method to create quit button
		mainWindow.add(character_select);// Adding JPanel
		mainWindow.revalidate();// Revalidating JFrame
	}// End of MainMenuCreation method
	
	
	/**
	 * Events for button click
	 * @return none
	 * @param none
	 */
	class ButtonClick implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String clicked = e.getActionCommand();
			if(clicked == "main menu")
			{
				ClearScreen(true, "none");//Creates new main menu
			} //End of if statement
			else
			{
				ClearScreen(false, clicked);//Creates character window
			}//End of else statement
			System.out.println(clicked);//Debug
			
		}//End of method actionPerformed
	}//End of ButtonClick
	
	
	/**
	 * Creates frame data table based on was selected
	 * @param char_selected
	 * @return none
	 */
	private void CreateFrameData(String char_selected)
	{
		System.out.println(name_searcher(char_selected));
	}//End of method CreateFrameData
	/**
	 * Searches for which index name is stored in 
	 * @param name Character selected
	 * @return index Index in which the character is stored in 
	 */
	private int name_searcher(String name)
	{
		int index = 0;//Stores location of name in arraylist WindowData
		//For loop to traverse WindowData in search of String name
		for(int i = 0; i < WindowData.size(); i++)
		{
			if(name == WindowData.get(i).getName())
			{
				index = i;
				break;
			}
		}//End of for loop
		return index;
	}
}// End of class Window
