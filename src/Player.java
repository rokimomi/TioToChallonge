
public class Player {

	public String tioId;
	public String name;
	public int seed;
	
	public Player(String id, String n, int s) {
		
		this.tioId = id;
		this.name = n;
		this.seed = s;
		
	}
	
	@Override
	public String toString() {
		//return this.seed + " " + this.tioId + " " + this.name;
		return this.seed + " " + this.name;
	}
	
}
