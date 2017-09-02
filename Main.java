/**
* GG Frame data
* @author(ImaginatixnLXIV)
* @version(8/19/17)
**/

//Imports
import javax.swing.*;//Used for JFrame and JFrame related functions
import java.util.Scanner;//Scanner used for user input
/**
* Main class
**/
public class Main
{
  /**
  * Main method
  * @param args default main argument
  * @return none
  **/
  public static void main(String [] args)
  {
	//Creating instance of Scanner
	Scanner user_input = new Scanner(System.in);
	//Creating instance of Window class
  	Window myWindow = new Window();
	//Input Verification
	boolean flag = false;
	//Width of JFrame window
	int width = 0;
	//Height of JFrame window
	int height = 0;
	//While loop for window dimensions and input verification
	while(flag == false)
	{
		System.out.println("Input desired resolution for window");
		System.out.println("Input width");
	        width = user_input.nextInt();
		System.out.println("Input height");
		height = user_input.nextInt();
		if(height <= 0 || width <= 0)
		{
			System.out.println("ERROR: Height or Width not valid");
			System.out.println("Input again");
		}//Occurs if either height, width or both are invalid
		else
		{
			flag = true;
		}//Occurs if input is valid for both width and height
	}//While loop used for input verfication
	myWindow.Create(width, height);
	//Creating instance of GGFrames
	GGFrames Frames = new GGFrames();
	Frames.check();
	myWindow.JLabelCreation(Frames.title());
  }//End of main method
}//End of main class
