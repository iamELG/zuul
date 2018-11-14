/**
 * This class is part of "Beewick castle" application. 
 * "Beewick castle" is a very simple, text based adventure game.  
 * 
 * This class is the main classe of the game "Beewick castle".
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau & Elvin Guilloton
 * @version 2.0 (Jan 2003)
 */
public class Game{
    private UserInterface gui;
    private GameEngine engine;

    /**
     * Create the game and initialise its internal map.
     */
    public Game(){
        engine = new GameEngine();
        gui = new UserInterface(engine);
        engine.setGUI(gui);
    }
} // Game
