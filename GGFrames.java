/**
 * Class in which jaunt is used for webscrapping purposes
 *
 * @author(ImaginatixnLXIV)
 * @version(8/17/2017)
 */
//Importing Jaunt library

import com.jaunt.*;

public class GGFrames {
    //Creating instance of jaunt
    UserAgent dustloop;

    /**
     * Checks to see if dustlop is up
     * @param none
     * @return none
     * */
    public void check() {
        try {
            dustloop = new UserAgent();//Creating instance of UserAgent
            //Setting dustloop to visit dustloop wiki frame data page to check status of website
            dustloop.visit("http://www.dustloop.com/wiki/index.php?title=GGXRD-R2/Frame_Data");
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
