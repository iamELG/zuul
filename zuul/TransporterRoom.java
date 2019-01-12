import java.util.ArrayList;
/**
 * Write a description of class TransporterRoom here.
 *
 * @author Elvin Guilloton
 * @version v1.0
 */
public class TransporterRoom extends Room{
    private ArrayList<Room> aListe;
    
    public TransporterRoom(String pDescription,String pImage,ArrayList<Room> pListe){
        super(pDescription,pImage);
        aListe=pListe;        
    }
    
    @Override
    public Room getExit(String pE){
        int vI=(int)(Math.random()*aListe.size());
        return aListe.get(vI);        
    }
}
