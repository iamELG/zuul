import java.util.HashMap;
/**
 * Write a description of class ItemList here.
 *
 * @author Elvin Guilloton
 * @version 1.0
 */
public class ItemList{
    private HashMap<String,Item> aList;
    
    /**
     * constructeur naturel
     */
    public ItemList(Item pItem){
        aList=new HashMap<String,Item>();
        aList.put(pItem.getName(),pItem);
    }
       
    /**
     * constructeur par default
     */
    public ItemList(){
        aList=new HashMap<String,Item>();
    }
    
    /** accesseur
     * 
     */
    public Item getItem(String pName){
        return(aList.get(pName));
    }
    
    /**  
     * addItem ajoute un item dans la hashmap
     */
    public void addItem(Item pItem){
       aList.put(pItem.getName(),pItem);
    }//addItem
    
    /**  
     * removeItem enleve un item dans la hashmap
     */
    public void removeItem(String pStr){
        if(!aList.containsKey(pStr))
            return;
        aList.remove(pStr);
    }//removeItem
    
    /**  
     * itemInInventory renvoi si un item est dans l'inventair
     */
    public boolean itemInList(String pStr){
        if(aList.containsKey(pStr))
            return false;
        return true;
    }//itemInListe    
    
    /**
     * renvoi une String avec tout les Item d'une de l'ItemList
     */
    public String getItemString(){
        StringBuilder vreturnString = new StringBuilder( "" );
        for ( String vS : aList.keySet()){
            vreturnString.append(vS+ " " );
        }
        return vreturnString.toString();
    }//getItemString
    
    /**
     * renvoi si il y  au moin un Item dans l'ItemList
     */
    public boolean isEmpty(){
        return (aList.isEmpty());
    }//isEmpty
    
}
