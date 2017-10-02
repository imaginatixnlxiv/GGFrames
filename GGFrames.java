/**
 * Class in which jaunt is used for webscrapping purposes
 *
 * @author(ImaginatixnLXIV)
 * @version(8/17/2017)
 */
//Importing Jaunt library
//Webscrapper
import com.jaunt.*;
//Importing java util to use Arraylist and other functions
import java.util.*;

public class GGFrames {
    //Creating instance of jaunt
    UserAgent dustloop;
    //Dustloop GG Wiki home page
    private String home_page="http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Frame_Data";
    //Arraylist of character urls
    ArrayList <Characters> CharList = new ArrayList<Characters>();
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
    /**
     * Checks to see if dustlop is up
     * @param none
     * @return none
     * */
    public void check() {
        try {
            dustloop = new UserAgent();//Creating instance of UserAgent
            //Setting dustloop to visit dustloop wiki frame data page to check status of website
            dustloop.visit(home_page);
        } catch (JauntException e) {
            System.out.println(e);
        }//End of catch
    }//End of check method

    /**
     * Test method for getting title from website
     * @param none
     * @return title websites title
     * */
    public String title() {
        String site_title = "";
        try {
            site_title = dustloop.doc.findFirst("<title>").getText();
        }//End of Try Statement
        catch (JauntException e) {
            System.out.println(e);
        }//End of catch statement
        return site_title;
    }//End of title method
}//End of GGFrames
