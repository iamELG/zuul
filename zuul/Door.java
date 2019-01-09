
/**
 * Write a description of class Door here.
 *
 * @author elvin guilloton
 * @version 1.0
 */
public class Door{
    private boolean aLocked;
    private boolean aIsTrapDoor;
    private boolean aGoodDirection;
    
    /** constructeur naturel
     * 
     */
    public Door(boolean pLocked,boolean pIsTrapDoor,boolean pGoodDirection){
        aGoodDirection=pGoodDirection;
        aIsTrapDoor=pIsTrapDoor;
        aLocked=pLocked;
    }
    
    public boolean isTrapDoor(){
        return aIsTrapDoor;
    }
    
    public boolean isLocked(){
        return aLocked;        
    }
    
    public boolean canGo(){
        return aGoodDirection;
    }
    
    public void setLocked(boolean pLocked){
        aLocked=pLocked;
    }
    
    public void setCanGo(boolean pGoodDirection){
         aGoodDirection=pGoodDirection;
    }
}
