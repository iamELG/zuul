import java.util.ArrayList;
/**
 * this Class is an extends of Class Room.
 * it is a Room, but when you exit it you are transported somewhere random.
 *
 * @author Elvin Guilloton
 * @version v1.0 (Jan 2018)
 */
public class TransporterRoom extends Room{
    private ArrayList<Room> aListe;
    /**
     * natural constructor of the class TransporterRoom
     * @param pDescription description of the room
     * @param pImage the destination to the image file of the room
     * @param pListe a Liste of all the room that you can be transported too
     */
    public TransporterRoom(String pDescription,String pImage,ArrayList<Room> pListe){
        super(pDescription,pImage);
        aListe=pListe;        
    }//TransporterRoom
    
    /**
     * return a random room
     * @param pE a String that is unused in this methode
     * @return a random room
     */
    @Override
    public Room getExit(String pE){
        int vI=(int)(Math.random()*aListe.size());
        return aListe.get(vI);        
    }//getExit
}//TransporterRoom
