
/**
 * Décrivez votre classe Item ici.
 *
 * @author Guilloton Elvin
 * @version 1.0
 */
public class Item{
    private int aWeight;
    private String aName;
    private String aDescription;
    private boolean aEdible;
    
    /**
     * Constructeur d'objets de classe Item
     */
    public Item(int pWeight,String pName,String pDescription,boolean pEdible){
         aDescription=pDescription;
         aName=pName;
         aWeight=pWeight;
         aEdible=pEdible;
    }//Item

    /**
     * Constructeur d'objets de classe Item
     */
    public Item(int pWeight,String pDescription){
        this(pWeight,pDescription,pDescription,false);
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
     * geter
     */
    public boolean getEdible(){
        return(this.aEdible);
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
