import java.util.HashMap;
import java.util.Set;

public class Room
{
    private String aDescription;
    private HashMap<String,Room> exits;

    /** constructeur naturel
     * 
     */
    public Room(final String pDescription)
    {   
        this.aDescription=pDescription;
        exits=new HashMap<String, Room>();

    }//Room 
    
    /** accesseur
     * 
     */
    public String getDescription(){return(this.aDescription);}
    
    /** acceseur
     *
     */
    public Room getExit(String direction){return(exits.get(direction));}
 
    /** getExitString acceseur des sortie
     *
     */
    public String getExitString(){
        String vReturnString="Exits: ";
        Set <String> keys= exits.keySet();
        for(String exit : keys){
            vReturnString += " " +exit;
        }
        return vReturnString;

    }//getExitString

    /** setExits cree les sortie dans l'atribut HashMap
     *
     */
    public void setExits(String pDir,Room pNei){
        exits.put(pDir,pNei);
    }//setExits

    /** return a lomg description of this room
     *
     */
    public String getLongDescription(){
        return ("You are in the: " + aDescription+".\n"+getExitString());
    }

} // Room
