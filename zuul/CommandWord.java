/**
 * This class is part of "Beewick castle" application. 
 * "Beewick castle" is a very simple, text based adventure game.
 * Representations for all the valid command words for the game.
 * 
 * @author Michael Kolling and David J. Barnes & Elvin Guiloton
 * @version (Jan 2018)
 */
public enum CommandWord{
    // A value for each command word, plus one for unrecognised
    // commands.
    GO("go"), QUIT("quit"), HELP("help"), LOOK("look"), EAT("eat"), BACK("back"), TEST("test"), TAKE("take"), DROP("drop"), ITEMS("items"),CHARGE("charge"),FIRE("fire"), UNKNOWN("?");
    // The command string.
    private String commandString;
    
    /**
     * Initialise with the corresponding command word.
     * @param commandWord The command string.
     */
    CommandWord(String commandString){
        this.commandString = commandString;
    }//CommandWord
    
    /**
     * @return The command word as a string.
     */
    public String toString(){
        return commandString;
    }//toString
}//CommandWord