/**
 * Class in which jaunt is used for webscrapping purposes
 *
 * @author(ImaginatixnLXIV)
 * @version(8/17/2017)
 */

//Importing JSoup library
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//Importing java util to use Arraylist and other functions
import java.util.*;

//importing File Io for writing and reading purposes
import java.io.*;

public class GGFrames
{
	// Creating instance of Window class
	Window myWindow;
	// Dustloop GG Wiki home page
	private String home_page = "http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Frame_Data";
	// Arraylist of character urls
	ArrayList<Characters> CharList = new ArrayList<Characters>();
	// Arraylist of frame data
	ArrayList<String> FrameData = new ArrayList<String>();
	/**
	 * Constructor
	 * @param none
	 * @return none
	 */
	public GGFrames()
	{
		// Adding characters to arraylist CharList
		CharList.add(new Characters("Answer", "http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Answer/Frame_Data"));
		CharList.add(new Characters("Axl Low", "http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Axl_Low/Frame_Data"));
		CharList.add(new Characters("Baiken", "http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Baiken/Frame_Data"));
		CharList.add(new Characters("Bedman", "http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Bedman/Frame_Data"));
		CharList.add(new Characters("Chipp Zanuff","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Chipp_Zanuff/Frame_Data"));
		CharList.add(new Characters("Dizzy", "http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Dizzy/Frame_Data"));
		CharList.add(new Characters("Elphelt Valentine","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Elphelt_Valentine/Frame_Data"));
		CharList.add(new Characters("Faust", "http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Faust/Frame_Data"));
		CharList.add(new Characters("I-No", "http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/I-No/Frame_Data"));
		CharList.add(new Characters("Jack-O", "http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Jack-O%27/Frame_Data"));
		CharList.add(new Characters("Jam Kuradoberi","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Jam_Kuradoberi/Frame_Data"));
		CharList.add(new Characters("Johnny", "http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Johnny/Frame_Data"));
		CharList.add(new Characters("Kum Haehyun","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Kum_Haehyun/Frame_Data"));
		CharList.add(new Characters("Ky Kiske","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Ky_Kiske/Frame_Data"));
		CharList.add(new Characters("Leo Whitefang","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Leo_Whitefang/Frame_Data"));
		CharList.add(new Characters("May", "http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/May/Frame_Data"));
		CharList.add(new Characters("Millia Rage","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Millia_Rage/Frame_Data"));
		CharList.add(new Characters("Potemkin","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Potemkin/Frame_Data"));
		CharList.add(new Characters("Ramlethal Valentine","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Ramlethal_Valentine/Frame_Data"));
		CharList.add(new Characters("Raven", "http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Raven/Frame_Data"));
		CharList.add(new Characters("Sin Kiske","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Sin_Kiske/Frame_Data"));
		CharList.add(new Characters("Slayer", "http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Slayer/Frame_Data"));
		CharList.add(new Characters("Sol Badguy","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Sol_Badguy/Frame_Data"));
		CharList.add(new Characters("Venom", "http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Venom/Frame_Data"));
		CharList.add(new Characters("Zato-1", "http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Zato-1/Frame_Data"));
		//Creating temporary loading screen while frames are scrapped
		CreateMenu();
		//Scraping Frames
		scrap_frames();
		//Calling MainMenuCreation
		myWindow.MainMenuCreation();
	}//End of constructor

	/**
	 * Creates instance of Window class
	 * @param none
	 * @return none
	 */
	private void CreateMenu()
	{
		myWindow = new Window(CharList);
	}//End of CreateMenu method

	/**
	 * Method that writes frame data to file
	 * @param none
	 * @return none
	 */
	/**
	private void write_frames()
	{
		for (int i = 0; i < CharList.size(); i++)
		{
			String file_name = CharList.get(i).getName() + ".txt";
			File current = new File(file_name);
			if (current.exists())
			{
				CharList.get(i).setFile(file_name);
			} // If file already exists then only reads file
			else
			{
				try
				{
					// Creating instance of FileWriter
					FileWriter currentFile = new FileWriter(current);
					// Writing data to file
				} // End of try
				catch (IOException e)
				{
					System.out.print(e);
				} // End of catch
			} // If file doesn't already exists it writes the file
		} // End of for loop
	}// End of write_frames methods
	**/
	/**
	 * Scraps frame data from dustloop, stores it in a ArrayList and returns it to
	 * write_frames method
	 * 
	 * @param none
	 * @return frame_data stores frame_data from dustloop
	 */
	private void scrap_frames() 
	{
		//Placeholder values for temporary testing
		String char_frames[][] = new String [999][999];
		try
		{
			//First loop used for selecting a url
			for(int i = 0; i < CharList.size(); i++)
			{
				//Selecting a url from array list CharList
				Document current_url = Jsoup.connect(CharList.get(i).getUrl()).get();
				//Getting elements table
				Elements table_counter = current_url.getElementsByTag("table");
				//Traversing tables
				for(int f = 1; f < table_counter.size(); f++)
				{
					//Getting table at index f
					Element table = current_url.select("table").get(f);
					//Selecting all rows in table_rows
					Elements table_rows = table.select("tr");
					//Traversing Columns
					for(int e = 0; e < table_rows.size(); e++)
					{
						//Selecting single row at index e
						Element current_row = table_rows.select("tr").get(e);
						//Selecting all columns in row current_row
						Elements columns = current_row.select("td");
						//Traversing columns
						for(int d = 0; d < columns.size(); d++)
						{
							//Selecting a single column to output
							Element current_col = columns.select("td").get(d);
							//Outputting the single column choosen
							//System.out.print(current_col.wholeText() + "	");
							//Saving frame data
							char_frames[e][d] = current_col.wholeText();
						}//End of for loop
						//Creating at new line
						//System.out.println("");
					}//End of for loop
				}//End of for loop
				//Passing frame data to characters array list
				CharList.get(i).setData(char_frames);
			}//End of for loop
		}/**End of try statement**/catch(IOException t)
		{
			System.err.print(t);
		}//End of catch statement
	}//End of scrap_frames method

}// End of GGFrames
