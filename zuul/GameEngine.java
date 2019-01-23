import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * This class is part of "Beewick castle" application. 
 * "Beewick castle" is a very simple, text based adventure game.  
 * 
 * This class is the main classe of the game "Beewick castle".
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau & Elvin Guilloton
 * @version 1.00 (Jan 2018)
 */
public class GameEngine{
    private Parser parser;
    private UserInterface gui;
    private Player aPlayer;

    /**
     * natural constructor of the class GameEngine
     */
    public GameEngine(){
        parser = new Parser();
        aPlayer= new Player();
        createRooms();
    }//GameEngine

    /**
     * create a GUI and print a welcome message
     */
    public void setGUI(UserInterface userInterface){
        gui = userInterface;
        printWelcome();
    }//setGUI

    /** 
     *  print a welcome message
     */
    private void printWelcome(){
        gui.println("Welcome to Beewick castle!\n Beewick castle is a new, incredibly boring adventure game.\nType \'help\' if you need help.\n ");
        printLocationInfo();
        gui.showImage(aPlayer.getCurrentRoom().getImageName());
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
        Room vCrypt=            new Room("the crypt","./Images/treasur_room.jpg");
        
        //add Rooms to list for transporterRoom
        ArrayList<Room> vListe = new ArrayList<Room>(9);        
        vListe.add(vEntrance);
        vListe.add(vOutside);
        vListe.add(vCoridor);
        vListe.add(vDeadEnd);
        vListe.add(vTavern);
        vListe.add(vEmptyRoom);
        vListe.add(vGuardRoom);
        vListe.add(vArmory);
        vListe.add(vThrone);
        vListe.add(vBedRoom);
        vListe.add(vDiningRoom);
        Room vEntranceToTheMine=new TransporterRoom("entrance to the mine","./Images/mine.jpg",vListe);
               
        // initialise room exits
        vEntrance.setExits("north",vOutside);
        vEntrance.setExits("south",vEmptyRoom);
        vEntrance.setExits("east",vCoridor);
        vOutside.setExits("south",vEntrance);
        vCoridor.setExits("east",vDeadEnd);
        vCoridor.setExits("west",vEntrance);
        vDeadEnd.setExits("west",vCoridor);
        vTavern.setExits("north",vEntrance);
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
        vDeadEnd.getItemList().addItem(new Item(30,"key","an old and rusty key",false));
        vDeadEnd.getItemList().addItem(new Item(5500,"heavy","realy heavy",false));
        vTavern.getItemList().addItem(new Item(20,"cookie","chocolate cookie",false));
        vArmory.getItemList().addItem(new Beamer());
        vCrypt.getItemList().addItem(new Item(400,"treasure","the beewick treasure",false));
        
        //initialisation des door
        Door tavern_emptyroom  = new Door(false,true,false);
        Door emptyroom_tavern  = new Door(false,true,true);
        Door treasureroom_crypt= new Door(true,false,true);
        
        vTavern.setDoor("east",tavern_emptyroom);
        vEmptyRoom.setDoor("west",emptyroom_tavern);
        vTreasureRoom.setDoor("down",treasureroom_crypt);
                
        aPlayer.setCurrentRoom(vEntrance);  // start game outside
    }//createRooms

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public boolean interpretCommand(Command pCommand){
        
        CommandWord vCommandWord = pCommand.getCommandWord();
        
        if(vCommandWord== CommandWord.UNKNOWN) {
            gui.println("I don't know what you mean...");
            return false;
        }
        
        switch(vCommandWord){
            case GO  :goRoom(pCommand); return true;
            case EAT :eat(pCommand)   ; return true;
            case TEST:test(pCommand)  ; return true;
            case TAKE:take(pCommand)  ; return true;
            case DROP:drop(pCommand)  ; return true;
            case HELP:printHelp()     ; return true;
            case LOOK:look()          ; return true;
            case BACK:back()          ; return true;
            case ITEMS:items()        ; return true;
            case CHARGE:charge()      ; return true;
            case FIRE:fire()          ; return true;
            case QUIT:endGame()       ; return true;
        }
        return false;       
    }//interpretCommand

    // implementations of user commands:
    /**
     * win will look if you did exit the Beewick castle with the treasure
     */
    private void win(){
        if((!aPlayer.getInventory().itemInList("treasure")) && aPlayer.getCurrentRoom().getDescription().equals("outside the main entrance")){
            gui.println("\n\nYou won well done you escape Beewick castle with the treasure");
            endGame();
        }
    }//win
    
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() {
        gui.println("You are lost in Beewick castle?\nYou are alone. You wander");
        gui.println("Your command words are: " + parser.showCommands());
    }//printHelp

    /** 
     *  print the descrition of the currentroom
     */
    private void printLocationInfo(){
        gui.println(aPlayer.getCurrentRoom().getLongDescription());
    }//printLocationInfo

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command pCommand){
        gui.println("");
        if(!pCommand.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            gui.println("Go where?");
            return;
        }

        String vDirection = pCommand.getSecondWord();

        // Try to leave current room.
        Room nextRoom = aPlayer.getCurrentRoom().getExit(vDirection);

        if (nextRoom == null){
            gui.println("There is no door!");
            return ;
        }
        boolean pStack=true;
        if(aPlayer.getCurrentRoom().getDoor(vDirection)!=null){
            if(aPlayer.getCurrentRoom().getDoor(vDirection).isTrapDoor()){
                if(!aPlayer.getCurrentRoom().getDoor(vDirection).canGo()){
                    gui.println("you can go through this door\nat least not in this direction!");
                    return;
                }
                if(aPlayer.getCurrentRoom().getDoor(vDirection).canGo()){
                    pStack=false;
                    aPlayer.getStack().clear();
                }            
            }
            else if(aPlayer.getCurrentRoom().getDoor(vDirection).isLocked()){
                if(!aPlayer.getInventory().itemInList("key")){
                    gui.println("this door is locked, but you open it with your key");
                    aPlayer.getCurrentRoom().getDoor(vDirection).setLocked(false);
                }
                else{
                    gui.println("this door seems to be locked, you will need a key");
                    return;
                }
            }
        }             
        if(pStack)
            aPlayer.getStack().push(aPlayer.getCurrentRoom());
            
        if(aPlayer.getCurrentRoom().isTransportRoom())
            aPlayer.getStack().clear();
            
        aPlayer.setCurrentRoom(nextRoom);
        gui.println(aPlayer.getCurrentRoom().getLongDescription());
        if(aPlayer.getCurrentRoom().getImageName() != null)
            gui.showImage(aPlayer.getCurrentRoom().getImageName());   
        win();
        addAMove();
    }//goRoom
    
    /**
     * this methode verify that the player haven't made more than the limit number of move
     */
    private void addAMove(){
        if(aPlayer.getNumberOfMove()>aPlayer.getNumberOfMoveMax())
            youLose();
        aPlayer.addNumberOfMove();
    }//addAMove

    /** 
     * let you do the last move you did backward 
     */
    private void back(){
        if(aPlayer.getStack().empty()){
            gui.println("you can go back any further\n");
            return;
        }
        Room vRoom=aPlayer.getStack().pop();
        aPlayer.setCurrentRoom(vRoom);
        gui.println(aPlayer.getCurrentRoom().getLongDescription());
        if(aPlayer.getCurrentRoom().getImageName() != null)
            gui.showImage(aPlayer.getCurrentRoom().getImageName());
    }
    
    /**
     *  print a th defeat message
     */
    private void youLose(){
        gui.println("\nYou lost, you can trye again later.");
        endGame();
    }//back    
    
    /**
     * quit the game
     */
    private void endGame(){
        gui.println("Thank you for playing.  Good bye.");
        gui.enable(false);
    }//endGame
    
    /**
     * print the current rom descriction
     */
    private void look(){
        gui.println(aPlayer.getCurrentRoom().getLongDescription());
    }//look
    
    /**
     * eat let you item edible item, edible item double you maximum weight you can carry
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

    /**test this comand let you meke test easyli by reading command from a .txt file
     * the command test can't use the command test (otherwise infinit loop)
     * the command test can use the command alea to do a sudo random move from a transporterroom
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
            
                String vWord1;
                String vWord2;
        
                StringTokenizer tokenizer = new StringTokenizer( vLigne );
        
                if ( tokenizer.hasMoreTokens() )
                    vWord1 = tokenizer.nextToken();      // get first word
                else
                    vWord1 = null;
                if ( tokenizer.hasMoreTokens() )
                    vWord2 = tokenizer.nextToken();      // get second word
                else
                    vWord2 = null;
                        
                    
                if((!vWord1.equals("test"))&&!(interpretCommand(parser.getCommand( vLigne)))){
                    if(vWord1.equals("alea")&& aPlayer.getCurrentRoom().getDescription().equals("entrance to the mine") && vWord2 != null){
                        aPlayer.setCurrentRoom(aPlayer.getCurrentRoom().alea(Integer.valueOf(vWord2)));
                        aPlayer.getStack().clear();
                        gui.println(aPlayer.getCurrentRoom().getLongDescription());
                        if(aPlayer.getCurrentRoom().getImageName() != null)
                            gui.showImage(aPlayer.getCurrentRoom().getImageName());   

                    }                            
                }
                // traitement de la ligne lue
            } // while
        } // try
        catch ( final FileNotFoundException pFNFE ) {
            gui.println("no such file or directory:"+pCommand.getSecondWord());
        } // catch
    }//teste
    
    
    /**
     *  take an item put it from the room to the player inventory
     */
    private void take(Command pCommand){
        if(!pCommand.hasSecondWord()) {
            gui.println("which object do you want too take?");
            return;
        }
        String vName = pCommand.getSecondWord();
        
        if(aPlayer.getCurrentRoom().getItemList().itemInList(vName)){
            gui.println("this item is not in the room!");
            look();   
            return;
        }
        
        if(aPlayer.getCurrentWeight()+aPlayer.getCurrentRoom().getItemList().getItem(vName).getWeight() > aPlayer.getMaxWeight()){
            gui.println("this item is too heavy for you!");
            look();   
            return;
        }
        aPlayer.setCurrentWeight( aPlayer.getCurrentWeight() + aPlayer.getCurrentRoom().getItemList().getItem(vName).getWeight() );
        aPlayer.getInventory().addItem(aPlayer.getCurrentRoom().getItemList().getItem(vName));
        aPlayer.getCurrentRoom().getItemList().removeItem(vName);
        look();    
    }//take
    
    /**
     *  drop an item n the room form the player inventory
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
        aPlayer.getCurrentRoom().getItemList().addItem(aPlayer.getInventory().getItem(vName));
        aPlayer.getInventory().removeItem(vName);
        look();
    }//drop
    
    /**
     * show all item the player carry in his enventori
     */
    private void items(){
        if(aPlayer.getInventory().isEmpty()){
            gui.println("no Item in you bag");
            return;        
        }            
        gui.println("Inventory: "+ aPlayer.getInventory().getItemString());   
    }//items
    
    /**
     * charge the beamer, the player can fire it lat to go back toot the room the beamer was charged in
     */
    private void charge(){
        if(aPlayer.getInventory().itemInList("beamer")){
            gui.println("you don't have any beamer, so you can't charge it");
            return;
        }
        gui.println("you charged your beamer");
        Item vItem=aPlayer.getInventory().getItem("beamer");
        Beamer vBeamer=(Beamer)vItem;
        
        vBeamer.charge(aPlayer.getCurrentRoom());
    }//charge
    
    /**
     * fire the beamer and move the player to the room the beamer was charged in
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
        
        aPlayer.setCurrentRoom(vBeamer.fire());
        aPlayer.getStack().clear();
        gui.println(aPlayer.getCurrentRoom().getLongDescription());
        if(aPlayer.getCurrentRoom().getImageName() != null)
            gui.showImage(aPlayer.getCurrentRoom().getImageName());
        
       
    }//fire
}//GameEngine
