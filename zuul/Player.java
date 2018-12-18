import java.util.HashMap;
/**
 * Write a description of class Player here.
 *
 * @author Elvin Guilloton
 */
public class Player{
    private HashMap<String,Item> aInventory;
    int aMaxWeight;
    int aCurrentWeight;
    
    /**
     * constructeur naturel 
     */
    public Player(int pMaxWeight,int pCurrentWeight){
        aInventory=new HashMap<String, Item>();
        aMaxWeight=pMaxWeight;
        aCurrentWeight=pCurrentWeight;
    }//Player
    
    /**
     * constructeur par default 
     */
    public Player(){
        this(1500,0);
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
    
    /** accesseur
     * 
     */
    public Item getItem(String pName){
        return(aInventory.get(pName));
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
    
    /**  
     * addItem ajoute un item dans la hashmap
     */
    public void addItem(Item pItem){
       aInventory.put(pItem.getName(),pItem);
    }//addItem
    
    /**  
     * removeItem enleve un item dans la hashmap
     */
    public void removeItem(String pStr){
        if(aInventory.containsKey(pStr))
            return;
        aInventory.remove(pStr);
    }//removeItem
    
    /**  
     * itemInInventory renvoi si un item est dans l'inventair
     */
    public boolean itemInInventory(String pStr){
        if(aInventory.containsKey(pStr))
            return false;
        return true;
    }//itemInRoom
    
}//Player
