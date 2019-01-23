
/**
 * Décrivez votre classe Item ici.
 *
 * @author Guilloton Elvin
 * @version 1.0 (Jan 2018)
 */
public class Item{
    private int aWeight;
    private String aName;
    private String aDescription;
    private boolean aEdible;
    
    /**
     * natural constructor of the class Item
     */
    public Item(int pWeight,String pName,String pDescription,boolean pEdible){
         aDescription=pDescription;
         aName=pName;
         aWeight=pWeight;
         aEdible=pEdible;
    }//Item

    /**
     * default constructor of the class Item
     */
    public Item(int pWeight,String pDescription){
        this(pWeight,pDescription,pDescription,false);
    }//Item
    
    /**
     * @return the attribute aWeight
     */
    public int getWeight(){
        return(this.aWeight);
    }//getWeight
    
    /**
     * @return the attribute aDescription
     */
    public String getDescription(){
        return(this.aDescription);
    }//getDescription
    
    /**
     * @return the attribute aName
     */
    public String getName(){
        return(this.aName);
    }//getName
    
    /**
     * @return the attribute aEdible
     */
    public boolean getEdible(){
        return(this.aEdible);
    }//getEdible
    
    /**
     * set the attribut aWeight
     */    
    public void setWeight(int pWeight){
        aWeight=pWeight;
    }//setWeight
    
    /**
     * set the attribut aDescription
     */
    public void setDescription(String pDescription){
        aDescription=pDescription;
    }//setDescription

    /**
     * set the attribut aName
     */
    public void setName(String pName){
        aName=pName;
    }//setName
    
}
