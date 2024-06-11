
public class Square {
	private int row;
	private int column;
	private boolean hasShip;
	private Battleship battleship;
	private boolean hasBeenFiredAt;
	
	public Square(int r, int c) {
		this.row = r;
		this.column = c;
		this.hasShip = false;
		this.battleship = null;
		this.hasBeenFiredAt = false;
	}
	
	// sets hasShip to true and which battleship is on square
	public void addShip(Battleship ship) {
		this.hasShip = true;
		battleship = ship;
	}
	
	// fires at square and hits associated ship if there is one 
	public void fireAt() {
		this.hasBeenFiredAt = true;		
	}
	
	// returns hasShip
	public Boolean hasShip() {
		return this.hasShip;
	}
	
	// return battleship
	public Battleship getShip() {
		return this.battleship;
	}
	
	// returns hasBeenFiredAt
	public Boolean hasBeenFiredAt() {
		return this.hasBeenFiredAt;
	}
	
	// returns icon to symbolise status of square
	public String toString() {
	    if (hasBeenFiredAt()) {
	        if (hasShip) {
	            return String.format("%3s", "x");// hit
	        } else {
	            return String.format("%3s", "o");// miss
	        }
	    } else {
	        return String.format("%3s", "-");// not yet targeted
	    }
    }

	
	
}
