/**
 * This class is part of "Beewick castle" application. 
 * "Beewick castle" is a very simple, text based adventure game.  
 * 
 * this class use the user inpute and do action in the game.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau & Elvin Guilloton
 * @version 2008.03.30 + 2013.09.15
 */
public class Command
{
    private String aCommandWord;
    private String aSecondWord;
    
    /** constructeur naturel 
     * 
     */
    public Command(final String pCommandWord,final String pSecondWord)
    {
        this.aCommandWord=pCommandWord;
        this.aSecondWord=pSecondWord;
    }//Command constructeur naturel
    
    /** accesseurs CommandWord
     * 
     */
    public String getCommandWord(){
        return(this.aCommandWord);
    }//getCommandWord
    
    /** accesseurs SecondWord
     * 
     */
    public String getSecondWord()
    {
        return(this.aSecondWord);
    }//getSecondWord
    
    /** renvoi si il y a un deuxiem mot 
     * 
     */
    public boolean hasSecondWord(){
        return(this.aSecondWord!=null);   
    }//hasSecondWord
    
    /** verifi que la commande fait partie des commande connue
     * 
     */
    public boolean isUnknown()
    {
        return(this.aCommandWord==null);   
    }//isUnknown
    
} // Command
