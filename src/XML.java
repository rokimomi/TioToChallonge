import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JTextArea;


public class XML {

	
	JTextArea log;	
	File tioFile;
	String xmlString;
	
	public XML(File file, JTextArea l) {
		
		log = l;
		Utility.logMessage(log, "A message from inside XML");
		
		tioFile = file;
		
		xmlString = "";

	}

	public void generate() {
		
		Utility.logMessage(log, "Begin");
		
		Utility.logMessage(log, "Reading tio file...");
		xmlString = readFile();
		
		// now its in xml file is in string form

		// edit xml string by replacing all instances of <player1> and <player2> with <bracketplayer>
		// perform xpath search for all <bracketplayer> where round = 1
		// insert them into a list of "Player"'s
		
		// now we have top down ordered list of bracket players 
		
		// determine size of bracket
		// update size in the GUI
		// run the seeding functions on that size and save the list
		// forloop through the list and merge the two lists by index (seed from the seed list goes into the seed value from the )

		// now we have a list of players with seeds that should feed correctly into a challonge bracket via api calls
		
		// establish rest connection with api key details from GUI
		// create new tournament using tournament name from GUI (can even specify single or double elim if needed)
			// make sure tourney is specified where it's singles or doubles
			// also make it private
		
		// now we have a fresh tournament we can add players to
		
		// iterate through the players list and begin calling a challonge url to input the players and seeds into the tournament
		// for each bye (they all have the same "bye" string id), keep a running count of the "byes" players and add a player who's name is BYE#XX
		// if possible, advance the players who have to face bye's somehow
		
		// print out link to tournament
		// inform user of program that tournament is currently private and they need to make it public
		
		
	}
	
	private String readFile() {
		String content = "";
		try {
			content = new Scanner(tioFile).next();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}
	
	private List<Integer> seeding(int numPlayers){
		
		int rounds = (int) Math.ceil((Math.log(numPlayers)/Math.log(2)) -1);
		
		List<Integer> pls = new ArrayList<Integer>();
		pls.add(1);
		pls.add(2);
		
		for(int i = 0; i < rounds; i++){
		    pls = nextLayer(pls);
		  }
		
		return pls;
		
	}
	
	private List<Integer> nextLayer(List<Integer> p) {
		
		List<Integer> out = new ArrayList<Integer>();
		
		int length = ( p.size() * 2 ) + 1;
		
		for (int i = 0; i < p.size(); i++) {
		    int d = p.get(i);
		    out.add(d);
		    out.add(length - d);
		}
		
		return out;
		
	}
		
	
}
