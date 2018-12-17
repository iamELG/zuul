/**
 * This class is part of "Beewick castle" application. 
 * "Beewick castle" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau & Elvin Guilloton
 * @version 2008.03.30 + 2013.09.15
 */
public class CommandWords
{
    // tableau constant qui contient tous les mots de commande valides
    private static final String[] sValidCommands = {
        "go","quit","help","look","eat","back","test"
    };

    /**
     * Constructeur par defaut
     */
    public CommandWords()
    {
        // rien a faire pour le moment...
    } // CommandWords()

    /**
     * Verifie si une String donnee fait partie des commandes valides. 
     * @param pString la String a tester
     * @return true si pString est une comande valide, false sinon
     */
    public boolean isCommand( final String pString )
    {
        // pour chacune des commandes valides (du tableau constant)
        for ( int i=0; i<sValidCommands.length; ++i ) {
            // si elle est egale a pString
            if ( sValidCommands[i].equals( pString ) )
                return true;
        } // for
        // si nous arrivons la, c'est que la commande
        // n'a pas ete trouvee dans le tableau
        return false;
    } // isCommand()
    
    /**print all valid commands to System.out
     * 
     */
    public static void showAll(){
        for(String vCommand: sValidCommands){
            System.out.print(vCommand+" ");
        }
        System.out.println();
    }//showAll

    /** renvoi un string avec tout les commande posible
     * 
     */
    public String getCommandList(){
        String vCommande="";
        for (String vTmp:this.sValidCommands) {
            vCommande+=vTmp+" ";            
        }
        return vCommande;
    }//getCommandList

} // CommandWords