import java.util.ArrayList;
/**
 * A game class built to play Tic Tac Toe.
 * 
 * @author Aaron Argent 
 * @version 2016/03/31
 */
public class Game
{
    //constants to represent number of tiles and players.
    private static final int NUUMBER_OF_TILES = 9;
    private static final int NUMBER_OF_PLAYERS = 2;
    //variable used to represent the current player.
    private int currentPlayer;
    //list used to iterate over the tiles of the game.
    private ArrayList<Tile> tiles;
    
    /**
     * Creates an instance of the Game and sets it up.
     */
    public Game()
    {
        setupGame();
    }
    
    /**
     * Sets up the game by populating the list and assigning the first player to current player.
     */
    public void setupGame()
    {
        tiles = new ArrayList<>();
        for (int i = 0; i < NUUMBER_OF_TILES; i++) {
            tiles.add(new Tile());
        }
        currentPlayer = 1;
    }
    
    /**
     * Attempts to make a move to the specified tile.
     * @param tile The tile the current player wishes to take.
     * @return True if the move was succesful, false otherwsie.
     */
    public boolean makeMove(int moveTile)
    {
        if (moveTile >= 0 && moveTile < 9) {
            Tile tile = tiles.get(moveTile);
            return tile.takeSpot(currentPlayer);
        }
        else {
            return false;
        }
    }
    
    /**
     * Checks the current board to see if the currentPlayer has won.
     * @return True if the current player has won.
     */
    public boolean checkWin()
    {
        if (checkWin(0,1,2)) {
            return true;
        }
        else if(checkWin(3,4,5)) {
            return true;
        }
        else if(checkWin(6,7,8)) {
            return true;
        }
        else if(checkWin(0,3,6)) {
            return true;
        }
        else if(checkWin(1,4,7)) {
            return true;
        }
        else if(checkWin(2,5,8)) {
            return true;
        }
        else if(checkWin(0,4,8)) {
            return true;
        }
        else if(checkWin(2,4,6)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Checks if the 3 spots' states equal the current player.
     * @param spot1, spot2, spot3 The 3 tiles to check.
     * @return True if the 3 tiles are taken by the current player.
     */
    private boolean checkWin(int spot1, int spot2, int spot3)
    {
        if (tiles.get(spot1).getState() == currentPlayer && tiles.get(spot2).getState() == currentPlayer && tiles.get(spot3).getState() == currentPlayer) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Changes turn and sets currentPlayer to the new player.
     */
    public void changeTurn()
    {
        if (currentPlayer == 1) {
            currentPlayer = 2;
        }
        else if (currentPlayer == 2) {
            currentPlayer = 1;
        }
    }
    
    /**
     * Gets the current value for currentPlayer.
     * @return int relating to whose turn it is.
     */
    public int getCurrentPlayer()
    {
        return currentPlayer;
    }
    
    /**
     * Returns the current player as a String.
     * @return String version of current player.
     */
    public String currentPlayerString()
    {
        switch (currentPlayer)
        {
            case 1: return "X";
            case 2: return "O";
            default: return "";
        }
    }
    
    /**
     * Resets the board and goes to player 1's turn.
     */
    public void resetGame()
    {
        for (Tile tile : tiles) {
            tile.reset();
        }
        currentPlayer = 1;
    }
    
    /**
     * Checks if the board has all been taken.
     * @return True if the board has been filled, False otherwise.
     */
    public boolean checkDraw()
    {
        int i = 0;
        int c = 0;
        while (i < tiles.size()) {
            if (tiles.get(i).isTaken()) {
                c++;
            }
            i++;
        }
        if (c == 9) {
            return true;
        }
        else {
            return false;
        }
    }
}
