
/**
 * Respresentation of a tile in the game Tic Tac Toe.
 * 
 * @author Aaron Argent 
 * @version 2016/03/31
 */
public class Tile
{
    //boolean to store whether the tile is taken
    private boolean isTaken;
    //int to represent what is currently stored in the tile
    private int state;
    
    /**
     * Creates a tile.
     */
    public Tile()
    {
        isTaken = false;
        state = 0;
    }
    
    /**
     * Attempts to take the tile for the given player.
     * @param player The player wanting to take this tile.
     * @return True if the player successfully takes the spot, False otherwise.
     */
    public boolean takeSpot(int player)
    {
        if (isTaken) {
            return false;
        }
        else {
            if (player > 0 && player < 3) {
                state = player;
                isTaken = true;
                return true;
            }
            else {
                return false;
            }
        }   
    }
    
    /**
     * Resets the tile to default.
     */
    public void reset()
    {
        state = 0;
        isTaken = false;
    }
    
    /**
     * Returns the state of the tile.
     * @return int representing state of tile.
     */
    public int getState()
    {
        return state;
    }
    
    /**
     * Returns whether or not the tile is taken.
     * @return True if the tile is taken, False otherwise.
     */
    public boolean isTaken()
    {
        return isTaken;
    }
}
