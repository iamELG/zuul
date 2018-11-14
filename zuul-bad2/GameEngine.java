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

    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine()
    {
        parser = new Parser();
        createRooms();
    }

    public void setGUI(UserInterface userInterface)
    {
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
    private void createRooms()
    {
        //all rooms
        Room vEntrance=         new Room("main Entrance","main_entrance.jpg");
        Room vOutside=          new Room("outside the main entrance","outside_the_castel.jpg");  
        Room vCoridor=          new Room("coridor","coridor.jpg");                         
        Room vDeadEnd=          new Room("DeadEnd","deadend.png");
        Room vTavern=           new Room("tavern","tavern.jpg");
        Room vEmptyRoom=        new Room("empty room","empty_room.jpg");                            
        Room vGuardRoom=        new Room("guard room","guard_room.jpg");
        Room vArmory=           new Room("armory","armoury.jpg");
        Room vThrone=           new Room("throne","thrones.JPG");
        Room vBedRoom=          new Room("bed room","royal_bed_room.JPG");
        Room vDiningRoom=       new Room("dining room","dining_room.jpg");
        Room vTreasureRoom=     new Room("treasure room","treasur_room.jpg");
        Room vEntranceToTheMine=new Room("entrance to the mine","mine.jpg");
        Room vCrypt=            new Room("the crypt","treasur_room.jpg");
        
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

        aCurrentRoom = vEntrance;  // start game outside
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public void interpretCommand(String commandLine) 
    {
        gui.println(commandLine);
        Command command = parser.getCommand(commandLine);

        if(command.isUnknown()) {
            gui.println("I don't know what you mean...");
            return;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("quit")) {
            if(command.hasSecondWord())
                gui.println("Quit what?");
            else
                endGame();
        }
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        gui.println("You are lost in Beewick castle?\nYou are alone. You wander");
        gui.print("Your command words are: " + parser.showCommands());
    }

    /** printLocationInfo affiche la description de la piece
     * 
     */
    private void printLocationInfo(){
        System.out.println(aCurrentRoom.getLongDescription());        
    }//printLocationInfo

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            gui.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = aCurrentRoom.getExit(direction);

        if (nextRoom == null)
            gui.println("There is no door!");
        else {
            aCurrentRoom = nextRoom;
            gui.println(aCurrentRoom.getLongDescription());
            if(aCurrentRoom.getImageName() != null)
                gui.showImage(aCurrentRoom.getImageName());
        }
    }

    private void endGame()
    {
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
    private void eat(){
        gui.println("you ate a cookie");
    }//eat

}
