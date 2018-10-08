
public class Game
{
    private Room aCurrentRoom;
    private Parser aParser;

    /** constructeur naturel
     *
     */
    public Game()
    {
        this.createRooms();
        this.aParser=new Parser();
    }//game contructeur naturel

    /**
     * 
     */
    private void createRooms()
    {
        this.aParser=new Parser();
        //all rooms
        Room vEntrance=         new Room("main Entrance");
        Room vOutside=          new Room("outside the main entrance");  
        Room vCoridor=          new Room("coridor");                         
        Room vDeadEnd=          new Room("DeadEnd");
        Room vTavern=           new Room("tavern");
        Room vEmptyRoom=        new Room("empty room");                            
        Room vGuardRoom=        new Room("guard room");
        Room vArmory=           new Room("armory");
        Room vThrone=           new Room("throne");
        Room vBedRoom=          new Room("bed room");
        Room vDiningRoom=       new Room("dining room");
        Room vTreasureRoom=     new Room("treasure room");
        Room vEntranceToTheMine=new Room("entrance to the mine");
        
        //set exits
        vEntrance.setExits(vOutside, vEmptyRoom, vCoridor,null);
        vOutside.setExits(null,vEntrance,null,null);
        vCoridor.setExits(null,null,vDeadEnd,vEntrance);
        vDeadEnd.setExits(null,null,null,vCoridor);
        vTavern.setExits(vTavern,vTavern,vEmptyRoom,vTavern);
        vEmptyRoom.setExits(vEntrance,vDiningRoom,vGuardRoom,vTavern);
        vGuardRoom.setExits(vArmory,null,null,vEmptyRoom);
        vArmory.setExits(null,vGuardRoom,null,null);
        vThrone.setExits(null,vBedRoom,vDiningRoom,null);
        vBedRoom.setExits(vThrone,null,null,null);
        vDiningRoom.setExits(vEmptyRoom,vTreasureRoom,vEntranceToTheMine,vThrone);
        vTreasureRoom.setExits(vDiningRoom,null,null,null);
        vEntranceToTheMine.setExits(null,null,null,vDiningRoom);
        
        //this current room
        this.aCurrentRoom=vEntrance;
    }//createRooms

    /**change room
     * 
     */
    private void goRoom(final Command pCommand)
    {
        if(pCommand.equals("go"))
            return;
        if(!pCommand.hasSecondWord()){
            System.out.println("Go where ?");
            return;
        }   
        Room vNextRoom=null;
        String vSecondWord=pCommand.getSecondWord();
        vNextRoom=aCurrentRoom.getExit(vSecondWord);
        /*
        switch(vSecondWord){
            case "n"    :vNextRoom=this.aCurrentRoom.aNorthExit;break;
            case "north":vNextRoom=this.aCurrentRoom.aNorthExit;break;
            case "North":vNextRoom=this.aCurrentRoom.aNorthExit;break;
            case "s"    :vNextRoom=this.aCurrentRoom.aSouthExit;break;
            case "south":vNextRoom=this.aCurrentRoom.aSouthExit;break;
            case "South":vNextRoom=this.aCurrentRoom.aSouthExit;break;
            case "e"    :vNextRoom=this.aCurrentRoom.aEastExit ;break;
            case "east" :vNextRoom=this.aCurrentRoom.aEastExit ;break;
            case "East" :vNextRoom=this.aCurrentRoom.aEastExit ;break;
            case "w"    :vNextRoom=this.aCurrentRoom.aWestExit ;break;
            case "west" :vNextRoom=this.aCurrentRoom.aWestExit ;break;
            case "West" :vNextRoom=this.aCurrentRoom.aWestExit ;break;
            default:      System.out.println("Unknown direction !");return;
        }
        */

        if(vNextRoom==null){
            System.out.println("There is no door !");
            return;   
        }

        this.aCurrentRoom=vNextRoom;
        printLocationInfo();
    }//goRoom
        
    /**
     *  end message
     */
    private void printEnd()
    {
        System.out.println("Thank you for playing.\nGood bye.");
    }//printEnd
    
    
    /** affiche le message de debut
     * 
     */
    private void printWelcome()
    {
        System.out.println("Welcome to the World of Zuul!\nWorld of Zuul is a new, incredibly boring adventure game.\nType \'help\' if you need help.\n ");        
        System.out.println("You are"+this.aCurrentRoom.getDescription());
        
        printLocationInfo();
    }//printWelcome
    
    /**
     * 
     */
    private void printLocationInfo(){
        
        System.out.println("you are:"+this.aCurrentRoom.getDescription());        
        
        if(this.aCurrentRoom.getExit("north")==null && this.aCurrentRoom.getExit("south")==null && this.aCurrentRoom.getExit("east")==null && this.aCurrentRoom.getExit("west")==null){
            System.out.print("no exits.... this must be a trap\n");
            return;
        }
        System.out.print("Exits:"+this.aCurrentRoom.getExitString());
        
        System.out.print("\n");    
    }//printExits
    
    /**
     * 
     */
    private void printHelp()
    {
        System.out.println("You are lost. You are alone.\nYou wander around at the university.");
        
        System.out.println("\nYour command words are: \ngo quit help\n");
    }//printHelp
    
    /**
     * 
     */
    private boolean quit(final Command pCommand)
    {
        if(pCommand.hasSecondWord()){
            System.out.println("quit what ?\n");
            return false;
        }
        return true;
    }//quit
    
    /**
     * 
     */
    private boolean processCommand(final Command pCommand)
    {
        String vCommand=pCommand.getCommandWord();
        switch(vCommand){
            case "go"  :goRoom(pCommand); return false;
            case "help":printHelp()     ; return false;
            case "quit":return(quit(pCommand)); 
        }
               
        System.out.println("I don't know what you mean...\n");
        return false;
    }//processCommand
    
    /**
     * 
     */
    public void play()
    {
        printWelcome(); 
        boolean vFinished=false;
        Command vCommand;
        while(!vFinished){
            vCommand=aParser.getCommand(); 
            vFinished=processCommand(vCommand);            
        
        }
        printEnd();
    }//play 
    

    
} // Game
