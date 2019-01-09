
/**
 * Write a description of class Door here.
 *
 * @author elvin guilloton
 * @version 1.0
 */
public class Door{
    private boolean aLocked;
    private boolean aGoodDirection;
    
    /** constructeur naturel
     * 
     */
    public Door(boolean pLocked,boolean pGoodDirection){
        aGoodDirection=pGoodDirection;
        aLocked=pLocked;
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
