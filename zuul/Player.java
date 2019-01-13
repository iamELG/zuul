/**
 * This class is part of "Beewick castle" application. 
 * "Beewick castle" is a very simple, text based adventure game.k
 * @author Elvin Guilloton
 * @version 1.0 (Jan 2018)
 */
public class Player{
    private ItemList aInventory;
    int aMaxWeight;
    int aCurrentWeight;
    
    /**
     * natural constructor of the class Player
     * @param pMaxWeight the maximum weight the player can cary
     * @param pCurrentWeight the weight the player start at
     */
    public Player(int pMaxWeight,int pCurrentWeight){
        aInventory=new ItemList();
        aMaxWeight=pMaxWeight;
        aCurrentWeight=pCurrentWeight;
    }//Player
    
    /**
     * default constructor of the class Player
     * the player will have a maximum weight of 500 and a current weight of 0
     */
    public Player(){
        this(500,0);
    }//Player
    
    /**
     * return the attribute aMaxWeight
     * @return aMaxWeight 
     */
    public int getMaxWeight(){
        return aMaxWeight;
    }//getMaxWeight
    
    /**
     * return the attribute aCurrentWeight
     * @return aCurrentWeight 
     */
    public int getCurrentWeight(){
        return aCurrentWeight;
    }//getCurrentWeight
    
    /**
     * return the attribute ItemList aInventory
     * @return aInventory 
     */
    public ItemList getInventory(){
        return aInventory;
    }//getInventory
    
    /**
     * set the attribute aMaxWeight
     * @param pMaxWeight the MaxWeight of the Player
     */
    public void setMaxWeight(int pMaxWeight){
       aMaxWeight=pMaxWeight;
    }//setMaxWeight
    
    /**
     * set the attribute aCurrentWeight
     * @param pCurrentWeight the CurrentWeight of the Player
     */
    public void setCurrentWeight(int pCurrentWeight){
       aCurrentWeight=pCurrentWeight;
    }//setCurrentWeight
    
}//Player
