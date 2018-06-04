package ctamsbetav2;

import java.awt.*;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 * Start creates an instance or
 * "Starts" the program.
 * 
 * @author Craig White
 * @version 2.0
 * @since 2018-04-13
 */
public class Start
{
    /**
     * This is the main method which creates a new
     * instance of the program.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        CTAMS myCTAMS = new CTAMS();                                            //Create a new CTAMS object
        myCTAMS.setVisible(true);                                               //Set the object's visibility to true
    }
}
