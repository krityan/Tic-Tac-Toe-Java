import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * A simple GUI designed to play the game "Tic Tac Toe", it supports 2 players, the first being X and second being O 
 * and allows for as many games to be played in a row as the players want without restarting the program.
 * 
 * @author Aaron Argent  
 * @version 2016/03/31
 */
public class GUI extends JFrame
{
    //variable to store current version of the program.
    private static final String version = "VERSION 1.0";
    //instance of the game Tic Tac Toe
    private Game game;
    //The inner window of the JFrame
    private Container contentPane;
    //The main menu 
    private JPanel menuPanel;
    //The game window
    private JPanel gamePanel;   
    //List of buttons used for the game board
    private ArrayList<JButton> tiles;
    //The console to provide minor feedback to the players
    private JLabel console;

    /**
     * Constructor for the GUI
     * @param title The title of the window
     * @param width The width in pixels of the window
     * @param height The height in pixels of the window
     */
    public GUI(String title, int width, int height)
    {
        super(title);
        makeFrame();
        menuBar();
        setupUI(width, height);
    }

    /**
     * Sets up the main menu panel with a title and start and quit buttons.
     */
    private void makeFrame()
    {
        contentPane = getContentPane();
        menuPanel = new JPanel();
        contentPane.add(menuPanel);

        menuPanel.setLayout(new GridLayout(3,1));
        JLabel title = new JLabel("Tic Tac Toe");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 72));
        menuPanel.add(title); 

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    switchToGame();
                }
            });
        menuPanel.add(startButton);

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    quit();
                }
            });
        menuPanel.add(quitButton);
    }

    /**
     * Sets up the menuBar for the window with restart, quit, rules and about options.
     */
    private void menuBar()
    {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem restartItem = new JMenuItem("Restart");
        restartItem.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    restart();
                }
            });
        fileMenu.add(restartItem);

        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    quit();
                }
            });
        fileMenu.add(quitItem);
        
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);
        
        JMenuItem rulesItem = new JMenuItem("Rules");
        rulesItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                showRules();
            }
        });
        helpMenu.add(rulesItem);
        
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                showAbout();
            }
        });
        helpMenu.add(aboutItem);
    }

    /**
     * Sets up a new game panel for a new game to start. 
     */
    private void setupGamePanel()
    {
        tiles = new ArrayList<>();
        gamePanel = new JPanel();
        gamePanel.setVisible(false);
        gamePanel.setLayout(new BorderLayout());

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(1,2));
        gamePanel.add(menuPanel, BorderLayout.SOUTH);
        JButton menuButton = new JButton("Main Menu");
        menuButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    restart();
                }
            });
        menuPanel.add(menuButton);
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    resetGame();
                }
            });
        menuPanel.add(resetButton);

        JPanel board = new JPanel();
        gamePanel.add(board, BorderLayout.CENTER);
        board.setLayout(new GridLayout(3,3));
        for (int i = 0; i < 9; i++){
            tiles.add(new JButton(""));
            board.add(tiles.get(i));
            tiles.get(i).setFont(new Font("Arial", Font.BOLD, 72));
        }
        tiles.get(0).addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    makeMove(0);
                }
            });
        tiles.get(1).addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    makeMove(1);
                }
            });  
        tiles.get(2).addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    makeMove(2);
                }
            });
        tiles.get(3).addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    makeMove(3);
                }
            });
        tiles.get(4).addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    makeMove(4);
                }
            });
        tiles.get(5).addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    makeMove(5);
                }
            });
        tiles.get(6).addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    makeMove(6);
                }
            });
        tiles.get(7).addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    makeMove(7);
                }
            });
        tiles.get(8).addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    makeMove(8);
                }
            });
           
        JPanel gamePanelNorth = new JPanel();
        JPanel gamePanelNorthUpper = new JPanel();
        gamePanelNorth.setLayout(new GridLayout(2,1));
        gamePanelNorthUpper.setLayout(new GridLayout(1,2));
        JLabel player1Label = new JLabel("Player 1: X");
        player1Label.setHorizontalAlignment(JLabel.CENTER);
        JLabel player2Label = new JLabel("Player 2: O");
        player2Label.setHorizontalAlignment(JLabel.CENTER);
        gamePanelNorthUpper.add(player1Label);
        gamePanelNorthUpper.add(player2Label);
        gamePanelNorth.add(gamePanelNorthUpper);
        console = new JLabel("Player 1's Turn");
        console.setHorizontalAlignment(JLabel.CENTER);
        gamePanelNorth.add(console);
        gamePanel.add(gamePanelNorth, BorderLayout.NORTH);
        startGame();
    }
    
    /**
     * Creates a fresh instance of the Tic Tac Toe game.
     */
    private void startGame()
    {
        game = new Game();       
    }

    /**
     * Sends a request to game to make a move and adjusts the UI accordingly.
     * @param tile The tile the current player is trying to take.
     */
    private void makeMove(int tile)
    {
        if(game.makeMove(tile)) {
            JButton button = tiles.get(tile);
            updateButton(button);
            if(game.checkWin()) {
                winnerFound(); 
            }
            else{
                if(game.checkDraw()) {
                    gameDraw();
                }
                else {
                    game.changeTurn();
                    console.setText("Player " + game.getCurrentPlayer() +"'s Turn");
                }
            }
        }
        else {
            console.setText("Tile already taken");
        }
    }
    
    /**
     * Updates the button to the current player's icon. Called when a move is sucessfully made.
     * @param button The button to be updated.
     */
    private void updateButton(JButton button)
    {
        switch(game.getCurrentPlayer()) {
            case 1: button.setText("X"); break;
            case 2: button.setText("O"); break;
            default: button.setText(""); break;
        }
    }
    
    /**
     * Called when a winner is found and displays a confirm dialog displaying who won and asking if the players wish to play again.
     */
    private void winnerFound()
    {
        int reply = JOptionPane.showConfirmDialog(this, "Player " + game.getCurrentPlayer() + " has won,\nWould you like to play again?", "Winner", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            resetGame();
        }
        else if (reply == JOptionPane.NO_OPTION) {
            restart();
        }
    }
    
    /**
     * Called when the board is full with no winner, displays a confirm dialog explaining this and asks if the players wish to play again.
     */
    private void gameDraw()
    {
        int reply = JOptionPane.showConfirmDialog(this, "Game was a draw,\nWould you like to play again?", "Draw", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            resetGame();
        }
        else if (reply == JOptionPane.NO_OPTION) {
            restart();
        }
    }
    
    /**
     * Method used to set properties of the frame.
     * @param width The width of the frame in pixels.
     * @param height The height of the frame in pixels.
     */
    private void setupUI(int width, int height)
    {
        setSize(new Dimension(width, height));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Switches the contentPane to display a fresh version of the game.
     */
    private void switchToGame()
    {
        setupGamePanel();
        menuPanel.setVisible(false);
        contentPane.removeAll();
        contentPane.add(gamePanel);
        gamePanel.setVisible(true);
    }
    
    /**
     * Resets the state of the game and the relevant parts of the UI.
     */
    private void resetGame()
    {
        game.resetGame();
        for (JButton button : tiles) {
            button.setText("");
        }
        console.setText("Player 1's Turn");
    }

    /**
     * Restarts the UI back to the main menu.
     */
    private void restart()
    {
        gamePanel.setVisible(false);
        contentPane.removeAll();
        contentPane.add(menuPanel);
        menuPanel.setVisible(true);
    }

    /**
     * Displays an information message showing the name and version of the program.
     */
    private void showAbout()
    {
        JOptionPane.showMessageDialog(this, "Tic Tac Toe\n" + version, "About", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Displays an informationg message with the rules for the game Tic Tac Toe.
     */
    private void showRules()
    {
        JOptionPane.showMessageDialog(this, "Rules of Tic Tac Toe:\nThere are 2 players.\nPlayer 1 is X and Player 2 is O.\nPlayers alternate turns placing their icon in the grid.\nTo win a player must get 3 in a row, either horizontally, vertically or diagonally.\nIf the board fills with no winner then it is a draw.", "Rules", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Exits the program.
     */
    private void quit()
    {
        System.exit(0);
    }
}
