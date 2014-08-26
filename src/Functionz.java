import java.util.ArrayList;
import java.util.List;

// adapted from: http://stackoverflow.com/questions/8355264/tournament-bracket-placement-algorithm

public class Functionz {

	public static List<Integer> seeding(int numPlayers){
		
		int rounds = (int) Math.ceil((Math.log(numPlayers)/Math.log(2)) -1);
		
		List<Integer> pls = new ArrayList<Integer>();
		pls.add(1);
		pls.add(2);
		
		for(int i = 0; i < rounds; i++){
		    pls = nextLayer(pls);
		  }
		
		return pls;
		
	}
	
	private static List<Integer> nextLayer(List<Integer> p) {
		
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
