
/**
 * Décrivez votre classe Item ici.
 *
 * @author Guilloton Elvin
 * @version 1.0
 */
public class Item
{
    private int aWeight;
    private String aDescription;

    /**
     * Constructeur d'objets de classe Item
     */
    public Item(int pWeight,String pDescription){
         aDescription=pDescription;
         aWeight=pWeight;
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
     * fonction qui renvoi la descricption d'un Item et le poids
     */
    @Override
    public String toString(){
        return("look at this object! it is a "+aDescription+" and it is "+aWeight+"Kg");
    }
}
