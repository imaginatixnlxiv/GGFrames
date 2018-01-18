/**
 * Class in which jaunt is used for webscrapping purposes
 *
 * @author(ImaginatixnLXIV)
 * @version(8/17/2017)
 */
//Importing Jaunt library
//Webscrapper
import com.jaunt.*;
import com.jaunt.component.Table;

//Importing java util to use Arraylist and other functions
import java.util.*;
//importing File Io for writing and reading purposes
import java.io.*;

public class GGFrames
{
    //Creating instance of Window class
    Window myWindow;
    //Creating instance of jaunt
    UserAgent dustloop;
    //Dustloop GG Wiki home page
    private String home_page="http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Frame_Data";
    //Arraylist of character urls
    ArrayList <Characters> CharList = new ArrayList<Characters>();
    //Arraylist of frame data
    ArrayList <String> FrameData = new ArrayList<String>();
    //Probably unneeded and declarations will be left in the constructor
    /**
     * Assigns urls to ArrayList characters
     * @param none
     * @return none
     */
   
    public void Char_Assign()
    {
        //Adding characters to arraylist CharList
        CharList.add(new Characters("Answer", "http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Answer/Frame_Data"));
        CharList.add(new Characters("Axl Low","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Axl_Low/Frame_Data"));
        CharList.add(new Characters("Baiken","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Baiken/Frame_Data"));
        CharList.add(new Characters("Bedman","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Bedman/Frame_Data"));
        CharList.add(new Characters("Chipp Zanuff","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Chipp_Zanuff/Frame_Data"));
        CharList.add(new Characters("Dizzy","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Dizzy/Frame_Data"));
        CharList.add(new Characters("Elphelt Valentine","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Elphelt_Valentine/Frame_Data"));
        CharList.add(new Characters("Faust","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Faust/Frame_Data"));
        CharList.add(new Characters("I-No","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/I-No/Frame_Data"));
        CharList.add(new Characters("Jack-O","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Jack-O%27/Frame_Data"));
        CharList.add(new Characters("Jam Kuradoberi","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Jam_Kuradoberi/Frame_Data"));
        CharList.add(new Characters("Johnny","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Johnny/Frame_Data"));
        CharList.add(new Characters("Kum Haehyun","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Kum_Haehyun/Frame_Data"));
        CharList.add(new Characters("Ky Kiske","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Ky_Kiske/Frame_Data"));
        CharList.add(new Characters("Leo Whitefang","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Leo_Whitefang/Frame_Data"));
        CharList.add(new Characters("May","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/May/Frame_Data"));
        CharList.add(new Characters("Millia Rage","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Millia_Rage/Frame_Data"));
        CharList.add(new Characters("Potemkin","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Potemkin/Frame_Data"));
        CharList.add(new Characters("Ramlethal Valentine","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Ramlethal_Valentine/Frame_Data"));
        CharList.add(new Characters("Raven","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Raven/Frame_Data"));
        CharList.add(new Characters("Sin Kiske","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Sin_Kiske/Frame_Data"));
        CharList.add(new Characters("Slayer","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Slayer/Frame_Data"));
        CharList.add(new Characters("Sol Badguy","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Sol_Badguy/Frame_Data"));
        CharList.add(new Characters("Venom","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Venom/Frame_Data"));
        CharList.add(new Characters("Zato-1","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Zato-1/Frame_Data"));
    }//End of Char_Assign method
    public GGFrames()
    {
        //Adding characters to arraylist CharList
        CharList.add(new Characters("Answer", "http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Answer/Frame_Data"));
        CharList.add(new Characters("Axl Low","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Axl_Low/Frame_Data"));
        CharList.add(new Characters("Baiken","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Baiken/Frame_Data"));
        CharList.add(new Characters("Bedman","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Bedman/Frame_Data"));
        CharList.add(new Characters("Chipp Zanuff","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Chipp_Zanuff/Frame_Data"));
        CharList.add(new Characters("Dizzy","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Dizzy/Frame_Data"));
        CharList.add(new Characters("Elphelt Valentine","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Elphelt_Valentine/Frame_Data"));
        CharList.add(new Characters("Faust","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Faust/Frame_Data"));
        CharList.add(new Characters("I-No","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/I-No/Frame_Data"));
        CharList.add(new Characters("Jack-O","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Jack-O%27/Frame_Data"));
        CharList.add(new Characters("Jam Kuradoberi","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Jam_Kuradoberi/Frame_Data"));
        CharList.add(new Characters("Johnny","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Johnny/Frame_Data"));
        CharList.add(new Characters("Kum Haehyun","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Kum_Haehyun/Frame_Data"));
        CharList.add(new Characters("Ky Kiske","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Ky_Kiske/Frame_Data"));
        CharList.add(new Characters("Leo Whitefang","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Leo_Whitefang/Frame_Data"));
        CharList.add(new Characters("May","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/May/Frame_Data"));
        CharList.add(new Characters("Millia Rage","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Millia_Rage/Frame_Data"));
        CharList.add(new Characters("Potemkin","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Potemkin/Frame_Data"));
        CharList.add(new Characters("Ramlethal Valentine","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Ramlethal_Valentine/Frame_Data"));
        CharList.add(new Characters("Raven","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Raven/Frame_Data"));
        CharList.add(new Characters("Sin Kiske","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Sin_Kiske/Frame_Data"));
        CharList.add(new Characters("Slayer","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Slayer/Frame_Data"));
        CharList.add(new Characters("Sol Badguy","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Sol_Badguy/Frame_Data"));
        CharList.add(new Characters("Venom","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Venom/Frame_Data"));
        CharList.add(new Characters("Zato-1","http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Zato-1/Frame_Data"));
        //Calling CreateMenu method
        CreateMenu();
        scrap_frames();
    }
    /**
     * Creates instance of Window class
     * @param none
     * @return none
     */
    private void CreateMenu()
    {
        myWindow = new Window(CharList);
    }
    /**
     * Checks to see if dustloop is up
     * @param none
     * @return none
     * */
    public void check() {
        try {
            dustloop = new UserAgent();//Creating instance of UserAgent
            //Setting dustloop to visit dustloop wiki frame data page to check status of website
            dustloop.visit(home_page);
            System.out.println(home_page);
        } catch (JauntException e) {
            System.out.println(e);
        }//End of catch
    }//End of check method
    /**
     * Method that writes frame data to file
     * @param none
     * @return none
     */
    private void write_frames()
    {
    	for(int i = 0; i < CharList.size(); i++)
    	{ 
    		String file_name = CharList.get(i).getName() + ".txt";
    		File current = new File(file_name);
    		if(current.exists())
    		{
    			CharList.get(i).setFile(file_name);
    		}//If file already exists then only reads file
    		
    		else
    		{
    			try
    			{
    				//Creating instance of FileWriter
    				FileWriter currentFile = new FileWriter(current);
    				//Writing data to file
    				
    			}//End of try
    			catch(IOException e)
    			{
    				System.out.print(e);
    			}//End of catch
    		}//If file doesn't already exists it writes the file
    	}//End of for loop
    }//End of write_frames methods
    /**
     * Scraps frame data from dustloop, stores it 
     * in a ArrayList and returns it to write_frames method
     * @param none
     * @return frame_data stores frame_data from dustloop 
     */
    private void scrap_frames()
    {
    	ArrayList <String> frame_data = new ArrayList <String>();
    	//Temporary solution is oversizing the array
    	String char_data[][] = new String[999][999];//2D array that will store all table data and will be passed on to Characters.java
    	try
    	{
    		for(int i = 0; i < CharList.size();i++)
    		{
    			//Visiting current character's url
    			UserAgent char_site = new UserAgent();
    			char_site.visit(CharList.get(i).getUrl());//Setting url to user agent
    			Elements tables = char_site.doc.findEach("<table>");//Getting all tables in a webpage
    			Elements table_heading = char_site.doc.findEach("<h2>");//Getting all table headings
    			//Creating a for loop to access each table in a webpage
    			for(int f = 0; f < tables.size(); f++)
    			{
    				Table frames = char_site.doc.getTable(f);
    				
    				//Traversing table through nested for loops
    				//Traversing the column
    				for(int d = 0; d < 9999; d++)//Currently testing to see how to stop loop once all tables have been accessed
    				{
    					//Traversing the rows
    					for(int e = 0; e < 9999; e++)
    					{
    						if(frames.getCell(d, e) != null)
    						{
    							//Setting frames element at column d and row e to char_data 2d array
    							char_data[d][e] = frames.getCell(d, e).getText();
    							System.out.println(frames.getCell(d,e).getText());
    						}//End of if statement
    						else
    						{
    							//Breaking for loop once frames == null because there is no more content to scrap
    							break;
    						}//End of else statement
    					}//End of for loop(row)
    				}//End of for loop(column)
    			}//End of for loop(main)
    			//Passing all table data into 
    			CharList.get(i).setData(char_data);
    		}//End of for loop
        //End of try statement
    	}catch(JauntException e)
    	{
    		System.out.println(e);
    	}//End of catch statement
    }
}//End of GGFrames
