import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;
/**
 * This class is part of "Beewick castle" application. 
 * "Beewick castle" is a very simple, text based adventure game.  
 * 
 * This class is the main classe of the game "Beewick castle".
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau & Elvin Guilloton
 * @version 1.00
 */
public class GameEngine
{
    private Parser parser;
    private Room aCurrentRoom;
    private UserInterface gui;
    private Stack<Room> aStack;
    private Player aPlayer;
    private int  aNumberOfMove;
    private int  aNumberOfMoveMax;

    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine(){
        parser = new Parser();
        aStack = new Stack<Room>();
        aPlayer= new Player();
        aNumberOfMove=0;
        aNumberOfMove=35;
        createRooms();
    }

    /**
     * fait un interface
     */
    public void setGUI(UserInterface userInterface){
        gui = userInterface;
        printWelcome();
    }

    /** 
     *  affiche le message de debut
     */
    private void printWelcome(){
        gui.println("Welcome to Beewick castle!\n Beewick castle is a new, incredibly boring adventure game.\nType \'help\' if you need help.\n ");
        printLocationInfo();
        gui.showImage(aCurrentRoom.getImageName());
    }//printWelcome

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms(){
        //all rooms
        //Room vEntrance=         new Room("main Entrance","./Images/main_entrance.jpg",new Item(110,"cube"));
        Room vEntrance=         new Room("main Entrance","./Images/main_entrance.jpg");
        Room vOutside=          new Room("outside the main entrance","./Images/outside_the_castel.jpg");  
        Room vCoridor=          new Room("coridor","./Images/coridor.jpg");                         
        Room vDeadEnd=          new Room("DeadEnd","./Images/deadend.png");
        Room vTavern=           new Room("tavern","./Images/tavern.jpg");
        Room vEmptyRoom=        new Room("empty room","./Images/empty_room.jpg");                            
        Room vGuardRoom=        new Room("guard room","./Images/guard_room.jpg");
        Room vArmory=           new Room("armory","./Images/armoury.jpg");
        Room vThrone=           new Room("throne","./Images/thrones.JPG");
        Room vBedRoom=          new Room("bed room","./Images/royal_bed_room.JPG");
        Room vDiningRoom=       new Room("dining room","./Images/dining_room.jpg");
        Room vTreasureRoom=     new Room("treasure room","./Images/treasur_room.jpg");
        Room vEntranceToTheMine=new Room("entrance to the mine","./Images/mine.jpg");
        Room vCrypt=            new Room("the crypt","./Images/treasur_room.jpg");
      
        // initialise room exits
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
        
        //initialisation des Item
        vEntrance.getItemList().addItem(new Item(110,"cube","a cube with some color on it",false));
        vDeadEnd.getItemList().addItem(new Item(20,"cape","a red cape",false));
        vDeadEnd.getItemList().addItem(new Item(35,"hat"," a cowboy hat",false));
        vDeadEnd.getItemList().addItem(new Item(55,"key","an old and rusty key",false));
        vDeadEnd.getItemList().addItem(new Item(5500,"heavy","realy heavy",false));
        vTavern.getItemList().addItem(new Item(20,"cookie","chocolate cookie",false));
        vArmory.getItemList().addItem(new Beamer());
        
        //initialisation des door
        Door tavern_emptyroom  = new Door(false,true,false);
        Door emptyroom_tavern  = new Door(false,true,true);
        Door treasureroom_crypt= new Door(true,false,true);
        Door crypt_treasureroom= new Door(true,false,true);
        
        vTavern.setDoor("east",tavern_emptyroom);
        vEmptyRoom.setDoor("west",emptyroom_tavern);
        vTreasureRoom.setDoor("down",treasureroom_crypt);
        vCrypt.setDoor("up",crypt_treasureroom);
                
        aCurrentRoom = vEntrance;  // start game outside
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public void interpretCommand(Command pCommand){
        
        CommandWord vCommandWord = pCommand.getCommandWord();
        //Command vCommand = parser.getCommand(commandLine);
        
        if(vCommandWord== CommandWord.UNKNOWN) {
            gui.println("I don't know what you mean...");
            return;
        }
        
        //String vCommandSTR = vCommand.getCommandWord();
        switch(vCommandWord){
            case GO  :goRoom(pCommand); break;
            case EAT :eat(pCommand)   ; break;
            case TEST:test(pCommand)  ; break;
            case TAKE:take(pCommand)  ; break;
            case DROP:drop(pCommand)  ; break;
            case HELP:printHelp()     ; break;
            case LOOK:look()          ; break;
            case BACK:back()          ; break;
            case ITEMS:items()        ; break;
            case CHARGE:charge()      ; break;
            case FIRE:fire()          ; break;
            case QUIT:endGame()       ; break;
        }
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() {
        gui.println("You are lost in Beewick castle?\nYou are alone. You wander");
        gui.println("Your command words are: " + parser.showCommands());
    }

    /** printLocationInfo affiche la description de la piece
     * 
     */
    private void printLocationInfo(){
        gui.println(aCurrentRoom.getLongDescription());
    }//printLocationInfo

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command pCommand){
        if(!pCommand.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            gui.println("Go where?");
            return;
        }

        String vDirection = pCommand.getSecondWord();

        // Try to leave current room.
        Room nextRoom = aCurrentRoom.getExit(vDirection);

        if (nextRoom == null){
            gui.println("There is no door!");
            return ;
        }
        boolean pStack=true;
        if(aCurrentRoom.getDoor(vDirection)!=null){
            if(aCurrentRoom.getDoor(vDirection).isTrapDoor()){
                if(!aCurrentRoom.getDoor(vDirection).canGo()){
                    gui.println("you can go through this door\nat least not in this direction!");
                    return;
                }
                if(aCurrentRoom.getDoor(vDirection).canGo()){
                    pStack=false;
                    aStack.clear();
                }            
            }
            else if(aCurrentRoom.getDoor(vDirection).isLocked()){
                if(!aPlayer.getInventory().itemInList("key"))
                    gui.println("this door is locked, but you open it with your key");
                else{
                    gui.println("this door seems to be locked, you will need a key");
                    return;
                }
            }
        }             
        if(pStack)
            aStack.push(aCurrentRoom);
        aCurrentRoom = nextRoom;
        gui.println(aCurrentRoom.getLongDescription());
        if(aCurrentRoom.getImageName() != null)
            gui.showImage(aCurrentRoom.getImageName());
        
    }
    
    private void addAMove(){
        if(aNumberOfMove>aNumberOfMoveMax)
            youLose();
        ++aNumberOfMove;
    }

    /** permet de retourner dans la room precedente
     * 
     */
    private void back(){
        if(aStack.empty()){
            gui.println("you can go back any further\n");
            return;
        }
        Room vRoom=aStack.pop();
        aCurrentRoom = vRoom;
        gui.println(aCurrentRoom.getLongDescription());
        if(aCurrentRoom.getImageName() != null)
            gui.showImage(aCurrentRoom.getImageName());
    }
    
    /**
     *  affiche le message de defaite
     */
    private void youLose(){
        gui.println("You lost, you can trye again later.");
        endGame();
    }    
    
    /**
     * quit le jeux
     */
    private void endGame(){
        gui.println("Thank you for playing.  Good bye.");
        gui.enable(false);
    }
    
    /**look
     *
     */
    private void look(){
        gui.println(aCurrentRoom.getLongDescription());
    }//look
    
    /**eat
     *
     */
    private void eat(Command pCommand){
        if(!pCommand.hasSecondWord()){
            gui.println("what do you want to eat?");
            return;
        }
        String vName = pCommand.getSecondWord();
        if(aPlayer.getInventory().itemInList(vName)){
            gui.println("you dont have any "+vName);
            return;
        }
        if(aPlayer.getInventory().getItem(vName).getEdible()){
            gui.println("this item is not food, you can't eat it");
            return;
        }
        
        aPlayer.setMaxWeight(aPlayer.getMaxWeight()*2);
        aPlayer.getInventory().removeItem(vName);
        gui.println("you ate a cookie, you can now carry more loot");
    }//eat

    /**test
     * 
     * 
     */
    private void test(Command pCommand){
        if(!pCommand.hasSecondWord()){
            gui.println("you didn't specify the file");
            return;
        }  
        Scanner vSc;
        try { // pour "essayer" les instructions suivantes
            String pNomFichier= pCommand.getSecondWord();
            vSc = new Scanner( new File( pNomFichier ) );
            while ( vSc.hasNextLine() ) {
                String vLigne = vSc.nextLine();
                interpretCommand(parser.getCommand( vLigne ));
                // traitement de la ligne lue
            } // while
        } // try
        catch ( final FileNotFoundException pFNFE ) {
            gui.println("no such file or directory:"+pCommand.getSecondWord());
        } // catch
    }//teste
    
    /**
     *  take
     */
    private void take(Command pCommand){
        if(!pCommand.hasSecondWord()) {
            gui.println("which object do you want too take?");
            return;
        }
        String vName = pCommand.getSecondWord();
        
        if(aCurrentRoom.getItemList().itemInList(vName)){
            gui.println("this item is not in the room!");
            look();   
            return;
        }
        
        if(aPlayer.getCurrentWeight()+aCurrentRoom.getItemList().getItem(vName).getWeight() > aPlayer.getMaxWeight()){
            gui.println("this item is too heavy for you!");
            look();   
            return;
        }
        aPlayer.setCurrentWeight( aPlayer.getCurrentWeight() + aCurrentRoom.getItemList().getItem(vName).getWeight() );
        aPlayer.getInventory().addItem(aCurrentRoom.getItemList().getItem(vName));
        aCurrentRoom.getItemList().removeItem(vName);
        look();    
    }//take
    
    /**
     *  drop
     */
    private void drop(Command pCommand){
        if(!pCommand.hasSecondWord()) {
            gui.println("which object do you want too drop?");
            return;
        }
        String vName = pCommand.getSecondWord();
        if(aPlayer.getInventory().itemInList(vName)){
            gui.println("this item is not in your inventory");
            look();
            return;
        }
        aPlayer.setCurrentWeight( aPlayer.getCurrentWeight() - aPlayer.getInventory().getItem(vName).getWeight());
        aCurrentRoom.getItemList().addItem(aPlayer.getInventory().getItem(vName));
        aPlayer.getInventory().removeItem(vName);
        look();
    }//drop
    
    /**
     * items
     */
    private void items(){
        if(aPlayer.getInventory().isEmpty()){
            gui.println("no Item in you bag");
            return;        
        }            
        gui.println("Inventory: "+ aPlayer.getInventory().getItemString());   
    }
    
    /**
     *  charge
     */
    private void charge(){
        if(aPlayer.getInventory().itemInList("beamer")){
            gui.println("you don't have any beamer, so you can't charge it");
            return;
        }
        gui.println("you charged your beamer");
        Item vItem=aPlayer.getInventory().getItem("beamer");
        Beamer vBeamer=(Beamer)vItem;
        
        vBeamer.charge(aCurrentRoom);
    }
    
    /**
     * fire
     */
    private void fire(){
        if(aPlayer.getInventory().itemInList("beamer")){
            gui.println("you don't have any beamer, so you can't fire it");
            return;
        }
        //Room vRoom=aPlayer.getInventory().itemInList("beamer").get("beamer").fire();
        
        Item vItem=aPlayer.getInventory().getItem("beamer");
        Beamer vBeamer=(Beamer)vItem;
        if(!vBeamer.isCharged()){
            gui.println("your beamer isn't charged, so you can't fire it");
            return;
        }
        
        aCurrentRoom = vBeamer.fire();
        aStack.clear();
        gui.println(aCurrentRoom.getLongDescription());
        if(aCurrentRoom.getImageName() != null)
            gui.showImage(aCurrentRoom.getImageName());
        
       
    }
}
