import java.util.HashMap;
import java.util.Set;
/**
 * This class is part of "Beewick castle" application. 
 * "Beewick castle" is a very simple, text based adventure game.  
 * 
 * This class is to move move around the map in diferent room.
 * 
 * @author  Michael Kolling and David J. Barnes + D.Bureau & Elvin Guilloton
 * @version 2008.03.30 + 2013.09.15
 */
public class Room
{
    private String aDescription;
    private HashMap<String,Room> aExits;
    private HashMap<String,Room> aRoom;
    private String aImageName;
    private HashMap<String,Item> aItem;

    /** constructeur naturel
     * 
     */
    public Room(final String pDescription, final String pImage,Item pItem)
    {   
        this.aDescription=pDescription;
        this.aImageName=pImage;
        aExits=new HashMap<String, Room>();
        aRoom=new HashMap<String, Room>();
        aItem=new HashMap<String, Item>(); 
        aItem.put(pItem.getDescription(),pItem);
    }//Room 
    
    /** constructeur sans objet
     * 
     */
    public Room(final String pDescription, final String pImage)
    {   
        this.aDescription=pDescription;
        this.aImageName=pImage;
        aExits=new HashMap<String, Room>();
        aRoom=new HashMap<String, Room>();
        aItem=new HashMap<String, Item>();
    }//Room 
    
    /** setExits cree les sortie dans l'atribut HashMap
     *
     */
    public void setExits(String pDir,Room pNei){
        aExits.put(pDir,pNei);
    }//setExits
    
    /** accesseur
     * 
     */
    public String getDescription(){return(this.aDescription);}
    
    /** acceseur
     *
     */
    public Room getExit(String direction){return(aExits.get(direction));}

    /** getExitString acceseur des sortie
     *
     */
    private String getExitString()
    {
        StringBuilder vreturnString = new StringBuilder( "Exits:" );
        for ( String vS : aExits.keySet() )
            vreturnString.append( " " + vS );
        return vreturnString.toString();
    }//getExitString
    
    /** getExitString acceseur des sortie
     *
     */
    private String getItemString()
    {
        StringBuilder vreturnString = new StringBuilder( "roger voit:" );
        for ( String vS : aItem.keySet()){
            //System.out.println("1"+aItem);
            //System.out.println("2"+aItem.get(vS).getDescription());
            //System.out.println("1"+aItem);
            vreturnString.append(aItem.get(vS).getDescription() + " " );
        }
        return vreturnString.toString();
    }//getItemString


    /** return a lomg description of this room
     *
     */
    public String getLongDescription(){
        //ELG if pas d'item \n else       
        String vStr="You are in the: " + aDescription+".\n"+getExitString();
        if(aItem.isEmpty())
            return (vStr);
        return (vStr+"\n"+getItemString());
    }

    /**
     * Return a string describing the room's image name
     */
    public String getImageName(){
    return aImageName;
    }//getImageName
    
} // Room
