import java.util.HashMap;
/**
 * This class is part of "Beewick castle" application. 
 * "Beewick castle" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau & Elvin Guilloton
 * @version 2008.03.30 + 2013.09.15
 */
public class CommandWords
{
    // tableau constant qui contient tous les mots de commande valides
    private HashMap<String, CommandWord> validCommands;

    /**
     * Constructeur par defaut
     */
    public CommandWords(){
        validCommands = new HashMap<String, CommandWord>();
        validCommands.put("go", CommandWord.GO);
        validCommands.put("help", CommandWord.HELP);
        validCommands.put("quit", CommandWord.QUIT);
        validCommands.put("look", CommandWord.LOOK);
        validCommands.put("eat",  CommandWord.EAT );
        validCommands.put("back", CommandWord.BACK);
        validCommands.put("test", CommandWord.TEST);
        validCommands.put("take", CommandWord.TAKE);
        validCommands.put("drop", CommandWord.DROP);
        validCommands.put("items",CommandWord.ITEMS);
    } // CommandWords()

    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString){
        return validCommands.containsKey(aString);
    }
    
    /**
     * return all valid commands
     */
    public String getCommandList() {
        String vString="";
        for(String command : validCommands.keySet()) {
            vString+=command + "  ";
        }        
        return vString;
    }
    
    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
} // CommandWords