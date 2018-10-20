
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

    /** creat all room's
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
        Room vCrypt=            new Room("the crypt");
        
        //set exits
        vEntrance.setExits("north",vOutside);
        vEntrance.setExits("south",vEmptyRoom);
        vEntrance.setExits("east",vCoridor);
        vOutside.setExits("south",vEntrance);
        vCoridor.setExits("east",vDeadEnd);
        vCoridor.setExits("west",vEntrance);
        vDeadEnd.setExits("west",vCoridor);
        vTavern.setExits("north",vTavern);
        vTavern.setExits("south",vTavern);
        vTavern.setExits("east",vEmptyRoom);
        vTavern.setExits("west",vTavern);
        vEmptyRoom.setExits("north",vEntrance);
        vEmptyRoom.setExits("south",vDiningRoom);
        vEmptyRoom.setExits("east",vGuardRoom);
        vEmptyRoom.setExits("west",vTavern);
        vGuardRoom.setExits("north",vArmory);
        vGuardRoom.setExits("west",vEmptyRoom);
        vArmory.setExits("south",vGuardRoom);
        vThrone.setExits("south",vBedRoom);
        vThrone.setExits("east",vDiningRoom);
        vBedRoom.setExits("north",vThrone);
        vDiningRoom.setExits("north",vEmptyRoom);
        vDiningRoom.setExits("south",vTreasureRoom);
        vDiningRoom.setExits("east",vEntranceToTheMine);
        vDiningRoom.setExits("west",vThrone);
        vTreasureRoom.setExits("north",vDiningRoom);
        vTreasureRoom.setExits("down",vCrypt);
        vCrypt.setExits("up",vTreasureRoom);
        vEntranceToTheMine.setExits("west",vDiningRoom);
        
        //this current room
        this.aCurrentRoom=vEntrance;
    }//createRooms

    /** change room
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

        if(vNextRoom==null){
            System.out.println("There is no door !");
            return;   
        }

        this.aCurrentRoom=vNextRoom;
        printLocationInfo();
    }//goRoom
        
    /** end message
     *  
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
        
        printLocationInfo();
    }//printWelcome
    
    /** printLocationInfo affiche la description de la piece
     * 
     */
    private void printLocationInfo(){
        System.out.println(aCurrentRoom.getLongDescription());        
    }//printExits
    
    /** printHelp procedur d'affichage d'aide
     * 
     */
    private void printHelp()
    {
        CommandWords vTmp=new CommandWords();
        System.out.println("Your command words are: " +vTmp.getCommandListe());
    }//printHelp
    
    /** quit prmet d'afficher un message de fin et de quiter
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
    
    /** processCommand permet de traiter une command return true si la
     *  command est quit sinon return false
     */
    private boolean processCommand(final Command pCommand)
    {
        String vCommand=pCommand.getCommandWord();
        switch(vCommand){
            case "go"  :goRoom(pCommand); return false;
            case "help":printHelp()     ; return false;
            case "look":look()          ; return false;
            case "eat" :eat()           ; return false;
            case "quit":return(quit(pCommand)); 
        }
               
        System.out.println("I don't know what you mean...\n");
        return false;
    }//processCommand

    /**look
     *
     */
    private void look(){
        System.out.println(aCurrentRoom.getLongDescription());
    }//look
    
    /**eat
     *
     */
    private void eat(){
        System.out.println("you ate a cookie");
    }//eat

    /** play procedure permetant de jouer
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
