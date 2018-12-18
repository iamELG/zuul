import java.util.HashMap;
/**
 * Write a description of class Player here.
 *
 * @author elvin Guilloton
 */
public class Player{
    private HashMap<String,Item> aInventory;
    int aMaxWeight;
    int aCurrentWeight;
    
    /**
     * constructeur naturel
     */
    public Player(int pMaxWeight){
        aInventory=new HashMap<String, Item>();
        aMaxWeight=pMaxWeight;
        aCurrentWeight=0;
    }
    

}
