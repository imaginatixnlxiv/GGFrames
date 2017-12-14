/**
 * Class that handles creation and returning of urls
 *
 * @author(ImagniatixnLXIV)
 * @version(10/2/17)
 */

public class Characters
{
    //Character Name
    private String char_name;
    //Character Dustloop url
    private String char_url;
    //String that holds filename/path of character frame data file
    private String file_name;
    /**
     * Construtor that takes in arguments and sets them
     * @param name Name of character
     * @param url Dustloop url for given character
     * @param framedata Framedata scrapped from dustloop
     * @return none
     */
    public Characters(String name, String url)
    {
        //Setting passed in arguments to variables in this class
        char_name = name;
        char_url = url;
    }

    /**
     * Returns String char_url
     * @param none
     * @return char_url Character Dustloop Url
     */
    public String getUrl()
    {
        return char_url;
    }//End of method getUrl

    /**
     * Returns String char_name
     * @param none
     * @return char_name Character Name
     */
    public String getName()
    {
        return char_name;
    }//End of method getName
    
    /**
     * sets String file to FName
     * @param FName
     * @return none
     */
    public void setFile(String FName)
    {
    	file_name = FName;
    }//End of setFile method
   
    /**
     * Returns String file_name
     * @param none
     * @return file_name returns character frame data file name
     */
    public String getFile()
    {
    	return file_name;
    }//End of getFile method
}
