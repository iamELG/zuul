/**
 * This class is part of "Beewick castle" application. 
 * "Beewick castle" is a very simple, text based adventure game.  
 * 
 * this class use the user inpute and do action in the game.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau & Elvin Guilloton
 * @version (Jan 2018)
 */
public class Command{
    private CommandWord aCommandWord;
    private String aSecondWord;
    
    /**
     * natural constructor of the class Command
     * @param pCommandWord a Command word
     * @param pSecondWord the second word
     */
    public Command(final CommandWord pCommandWord,final String pSecondWord){
        this.aCommandWord=pCommandWord;
        this.aSecondWord=pSecondWord;
    }//Command constructeur naturel
    
    /**
     * return the attribute aCommandWord
     * @return aCommandWord 
     */
    public CommandWord getCommandWord(){
        return(this.aCommandWord);
    }//getCommandWord
    
    /**
     * return the attribute aSecondWord
     * @return aSecondWord 
     */
    public String getSecondWord(){
        return(this.aSecondWord);
    }//getSecondWord
    
    /**
     * return a boolean 
     * @return  if there is a second word
     */
    public boolean hasSecondWord(){
        return(this.aSecondWord!=null);   
    }//hasSecondWord
    
    /**
     * return a boolean
     * @return if the command is known 
     */
    public boolean isUnknown(){
        return (aCommandWord == CommandWord.UNKNOWN);   
    }//isUnknown
    
} // Command
