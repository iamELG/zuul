import java.util.HashMap;
import java.util.HashMap;
import java.util.Set;
/**
 * This class is part of "Beewick castle" application. 
 * "Beewick castle" is a very simple, text based adventure game.  
 * 
 * This class is to move move around the map in diferent room.
 * 
 * @author  Michael Kolling and David J. Barnes + D.Bureau & Elvin Guilloton
 * @version (Jan 2018)
 */
public class Room{
    private String aDescription;
    private HashMap<String,Room> aExits;
    private HashMap<String,Door> aDoor;
    private String aImageName;
    private ItemList aItem;

    /**
     * natural constructor of the class Room
     * @param pDescription description of the room
     * @param pImage the destination to the image file of the room
     * @param pItem a item that will be n the room
     */
    public Room(final String pDescription, final String pImage,Item pItem){   
        this.aDescription=pDescription;
        this.aImageName=pImage;
        aExits=new HashMap<String, Room>();
        aDoor=new HashMap<String, Door>();
        aItem=new ItemList();
        if(pItem!=null)
            aItem.addItem(pItem);
    }//Room 
    
    /**
     * constructor of the class Room without any object
     * @param pDescription description of the room
     * @param pImage the destination to the image file of the room
     */
    public Room(final String pDescription, final String pImage){   
        this(pDescription,pImage,null);
    }//Room 
    
    /** 
     * add an Exit to the HashMap aExits
     * @param pDir the direction that lead to the next room
     * @param pRoom the Room you want in the direction
     */
    public void setExits(String pDir,Room pRoom){
        aExits.put(pDir,pRoom);
    }//setExits
   
    /** 
     * add a Door to the HashMap aDoor
     * @param pDir the direction  in wich the Door is 
     * @param pDoor the Door you want in the direction
     */
    public void setDoor(String pDir,Door pDoor){
        aDoor.put(pDir,pDoor);
    }//setExits
    
    /**
     * return the attribute aDescription
     * @return aDescription
     */
    public String getDescription(){
        return(this.aDescription);
    }//getDescription
    
    /**
     * return a Room for the HashMap aExit
     * @param pDirection the direction you want the Exit of. 
     * @return the Room 
     */
    public Room getExit(String pDirection){
        return(aExits.get(pDirection));
    }//getExit
    
    /**
     * return a Door for the HashMap aDoor
     * @param pDirection the direction you want the Door of. 
     * @return the Door 
     */
    public Door getDoor(String pDirection){
        return(aDoor.get(pDirection));
    }//getExit
        
    /**
     * return the attribute ItemList
     * @return the attribute aItem
     */
    public ItemList getItemList(){
        return aItem;
    }//getItemList
    
    /**
     * return the String of all the Exits with a Space inbetween 
     * @return String of all the Exits
     */
    private String getExitString()
    {
        StringBuilder vreturnString = new StringBuilder( "Exits:" );
        for ( String vS : aExits.keySet() )
            vreturnString.append( " " + vS );
        return vreturnString.toString();
    }//getExitString
    
    /**
     * return a String with the long description of the room
     * @return a String with the description of the room
     */
    public String getLongDescription(){
        String vStr="You are in the: " + aDescription+".\n"+getExitString();
        
        if(aItem.isEmpty())
            return (vStr);
           
        return (vStr+"\nItem:"+aItem.getItemString());
    }//getLongDescription

    /**
     * return the name of the Image
     * @return the String of a Image file
     */
    public String getImageName(){
        return aImageName;
    }//getImageName
    
    public Room alea(int pI){
        return null;
    }  
} // Room
