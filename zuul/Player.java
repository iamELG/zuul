import java.util.Stack;
import java.util.Stack;
/**
 * This class is part of "Beewick castle" application. 
 * "Beewick castle" is a very simple, text based adventure game.k
 * @author Elvin Guilloton
 * @version 1.0 (Jan 2018)
 */
public class Player{
    private ItemList aInventory;
    private int aMaxWeight;
    private int aCurrentWeight;
    private int aNumberOfMove;
    private int aNumberOfMoveMax;
    private Room aCurrentRoom;
    private Stack<Room> aStack;
    
    /**
     * natural constructor of the class Player
     * @param pMaxWeight the maximum weight the player can cary
     * @param pCurrentWeight the weight the player start at
     * @param pNumberOfMoveMax the maximum number of valid move befor losing the game
     * @param pNumberOfMove the number of move did since the begining of the game
     */
    public Player(int pMaxWeight,int pCurrentWeight,int pNumberOfMoveMax,int pNumberOfMove){
        aInventory=new ItemList();
        aMaxWeight=pMaxWeight;
        aCurrentWeight=pCurrentWeight;
        aNumberOfMoveMax=pNumberOfMoveMax;
        aNumberOfMove=pNumberOfMove;
        aStack = new Stack<Room>();
    }//Player
    
    /**
     * default constructor of the class Player
     * the player will have a maximum weight of 500 and a current weight of 0
     * the player will have a number of move set at 0 and a maximum move of 35
     */
    public Player(){
        this(500,0,35,0);
    }//Player
    
    /**
     * set the attribute aCurrentRoom 
     */
    public void setCurrentRoom(Room pCurrentRoom){
        aCurrentRoom=pCurrentRoom;
    }//setCurrentRoom
    
    /**
     * get the attribute aCurrentRoom 
     */
    public Room getCurrentRoom(){
        return aCurrentRoom;
    }//getCurrentRoom
    
    /**
     * get the attribute aStack 
     */
    public Stack<Room> getStack(){
        return aStack;
    }//getStack   
    
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
     * return the attribute aNumberOfMove
     * @return aNumberOfMove 
     */
    public int getNumberOfMove(){
        return aNumberOfMove;
    }//getNumberOfMove
    
    /**
     * return the attribute aNumberOfMoveMax
     * @return aNumberOfMoveMax 
     */
    public int getNumberOfMoveMax(){
        return aNumberOfMoveMax;
    }//getNumberOfMoveMax
    
    /**
     * add 1 to the attribute aNumberOfMove 
     */
    public void addNumberOfMove(){
        ++aNumberOfMove;
    }//addNumberOfMove
    
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
