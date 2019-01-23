
/**
 * Write a description of class Beamer here.
 *
 * @author Elvin Guilloton
 * @version 1.0
 */
public class Beamer extends Item{
    public Room aRoom;
    
    public Beamer(){
        super(80,"beamer","once you charge it, you can go back to the point where you charge it!!",false);        
    }
    
    public boolean isCharged(){
        return aRoom!=null;
    }
    
    public void charge(Room pRoom){
        aRoom=pRoom;
    }

    public Room fire(){
        Room pRoom=aRoom;
        aRoom=null;
        return pRoom;
    }
    
}
