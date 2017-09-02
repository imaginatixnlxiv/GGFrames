/**
 * Class that JFrame functions will take place in
 *
 * @author(ImaginatixnLXIV)
 * @version(8/25/17)
 * */
import javax.swing.*;//Import JFrame functions

/**
 * Class that handles all JFRame Functions
 * */
public class Window
{
	/**
	 * Method that creates window
	 * @param none
	 * @return none
	 * */
	public void Create(int width, int height)
	{
		//Creating JFrame
    		JFrame mainWindow = new JFrame("GGFrames");//Creates instnace of JFrame and assigns window name
    		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Close operation
    		mainWindow.setSize(width, height);//Determines size of window
		mainWindow.setLocationRelativeTo(null);//Opens window in the center of the screen
    		mainWindow.setVisible(true);//Displays window
	}//End of create method
	/**
	 * Method that creates JLabels
	 * @param none
	 * @return none
	 * */
	public void JLabelCreation(String Title)
	{
		JLabel Site_Title = new JLabel();//Creating instance of JLabel for Site_Title
		Site_Title.setText(Title);//Setting text for Site_Title JLabel
	}//End of JLabelCreation method
}//End of class Window
