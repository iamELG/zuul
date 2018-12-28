/**
 * Write a description of class Player here.
 *
 * @author Elvin Guilloton
 */
public class Player{
    private ItemList aInventory;
    int aMaxWeight;
    int aCurrentWeight;
    
    /**
     * constructeur naturel 
     */
    public Player(int pMaxWeight,int pCurrentWeight){
        aInventory=new ItemList();
        aMaxWeight=pMaxWeight;
        aCurrentWeight=pCurrentWeight;
    }//Player
    
    /**
     * constructeur par default 
     */
    public Player(){
        this(500,0);
    }//Player
    
    /**
     * geter
     */
    public int getMaxWeight(){
        return aMaxWeight;
    }//getMaxWeight
    
    /**
     * geter
     */
    public int getCurrentWeight(){
        return aCurrentWeight;
    }//getCurrentWeight
    
    /**geter
     * 
     */
    public ItemList getInventory(){
        return aInventory;
    }
    
    /**
     * seter
     */
    public void setMaxWeight(int pMaxWeight){
       aMaxWeight=pMaxWeight;
    }//setMaxWeight
    
    /**
     * seter
     */
    public void setCurrentWeight(int pCurrentWeight){
       aCurrentWeight=pCurrentWeight;
    }//setCurrentWeight
    
}//Player
