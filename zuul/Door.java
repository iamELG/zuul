
/**
 * This class is part of "Beewick castle" application. 
 * "Beewick castle" is a very simple, text based adventure game.
 * this classe is to stop Player from mooving with some locked door/ trap door.
 * @author Elvin Guilloton
 * @version 1.0 (Jan 2018)
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
