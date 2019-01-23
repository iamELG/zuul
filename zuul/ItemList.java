import java.util.HashMap;
/**
 * Write a description of class ItemList here.
 *
 * @author Elvin Guilloton
 * @version 1.0 (Jan 2018)
 */
public class ItemList{
    private HashMap<String,Item> aList;
    
    /**
     * natural constructor of the class Player
     */
    public ItemList(Item pItem){
        aList=new HashMap<String,Item>();
        aList.put(pItem.getName(),pItem);
    }
       
    /**
     * default constructor of the class Player
     */
    public ItemList(){
        aList=new HashMap<String,Item>();
    }
    
    /** 
     * return an item of the aList
     */
    public Item getItem(String pName){
        return(aList.get(pName));
    }
    
    /**  
     * addItem add an item to the HashMap
     */
    public void addItem(Item pItem){
       aList.put(pItem.getName(),pItem);
    }//addItem
    
    /**  
     * removeItem remove an item to the HashMap
     */
    public void removeItem(String pStr){
        if(!aList.containsKey(pStr))
            return;
        aList.remove(pStr);
    }//removeItem
    
    /**  
     * return if the item is in the liste
     */
    public boolean itemInList(String pStr){
        if(aList.containsKey(pStr))
            return false;
        return true;
    }//itemInListe    
    
    /**
     * renvoi a String with all the item in the HashMap
     */
    public String getItemString(){
        StringBuilder vreturnString = new StringBuilder( "" );
        for ( String vS : aList.keySet()){
            vreturnString.append(vS+ " " );
        }
        return vreturnString.toString();
    }//getItemString
    
    /**
     * return if theyr is at least one item in the hashMap
     */
    public boolean isEmpty(){
        return (aList.isEmpty());
    }//isEmpty
    
}
