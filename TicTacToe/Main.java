
/**
 * Main class to start the GUI.
 * 
 * @author Aaron Argent 
 * @version 2016/03/31
 */
public class Main
{
    //instance of the GUI
    private static GUI gui;
    
    /**
     * Creates the GUI for Tic Tac Toe.
     */
    public static void main(String args[])
    {
        gui = new GUI("Tic Tac Toe", 640, 480);
    }
}