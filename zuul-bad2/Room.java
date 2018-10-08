
public class Room
{
    private String aDescription;
    private Room aNorthExit;
    private Room aSouthExit;
    private Room aEastExit;
    private Room aWestExit;

    /** constructeur naturel
     * 
     */
    public Room(final String pDescription)
    {
        this.aDescription=pDescription;
    }//Room construteur naturel
    /**
     * accesseur
     */
    public String getDescription(){return(this.aDescription);}
    public String getNorthExit(){return(this.aNorthExit.aDescription);}
    public String getSouthExit(){return(this.aSouthExit.aDescription);}
    public String getEastExit() {return(this.aEastExit.aDescription) ;}
    public String getWesthExit(){return(this.aWestExit.aDescription) ;}
    
    public Room getExit(String pdirection){
        if(pdirection.equals("n") || pdirection.equals("north") || pdirection.equals("North"))
            return this.aNorthExit;
        if(pdirection.equals("s")||pdirection.equals("south")||pdirection.equals("South"))
            return this.aSouthExit;
        if(pdirection.equals("e")||pdirection.equals("east")||pdirection.equals("East"))
            return this.aEastExit;
        if(pdirection.equals("w")||pdirection.equals("west")||pdirection.equals("West"))
            return this.aWestExit;
        return null;
    }

    /**
     * 
     */
    public void setExits(final Room pNorthExit, final Room pSouthExit,
    final Room pEastExit,  final Room pWestExit)
    {
        if(pNorthExit!=null)
            this.aNorthExit=pNorthExit;
        if(pSouthExit!=null)
            this.aSouthExit=pSouthExit;
        if(pEastExit!=null)
            this.aEastExit=pEastExit;
        if(pWestExit!=null)
            this.aWestExit=pWestExit;

    }//setExits

    /**
     * 
     */
    public String getExitString(){
        String vSTR="";
        if(getExit("north")!=null)
            vSTR+= this.aNorthExit.aDescription+" ";
        if(getExit("south")!=null)
            vSTR+= this.aSouthExit.aDescription+" ";
        if(getExit("east")!=null)
            vSTR+= this.aEastExit.aDescription+" ";
        if(getExit("west")!=null)
            vSTR+= this.aWestExit.aDescription;
        return vSTR;

    }//getExitString

} // Room
