
/**
 * Décrivez votre classe Item ici.
 *
 * @author Guilloton Elvin
 * @version 1.0
 */
public class Item
{
    private int aWeight;
    private String aName;
    private String aDescription;
    
    /**
     * Constructeur d'objets de classe Item
     */
    public Item(int pWeight,String pName,String pDescription){
         aDescription=pDescription;
         aName=pName;
         aWeight=pWeight;
    }//Item

    /**
     * Constructeur d'objets de classe Item
     */
    public Item(int pWeight,String pDescription){
        this(pWeight,pDescription,pDescription);
    }//Item
    
    /**
     * geter
     */
    public int getWeight(){
        return(this.aWeight);
    }
    
    /**
     * geter
     */
    public String getDescription(){
        return(this.aDescription);
    }
    
    /**
     * geter
     */
    public String getName(){
        return(this.aName);
    }
    
    /**
     * seter
     */    
    public void setWeight(int pWeight){
        this.aWeight=pWeight;
    }
    
    /**
     * seter
     */
    public void setDescription(String pDescription){
        aDescription=pDescription;
    }

    /**
     * seter
     */
    public void setName(String pName){
        aName=pName;
    }
    
    /**
     * fonction qui renvoi la descricption d'un Item et le poids
     */
    @Override
    public String toString(){
        return("name:"+aName+"\ndescription:"+aDescription+"\nweight"+aWeight);
    }
}
