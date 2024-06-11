
public class Battleship {
	protected Boolean hasSunk;
	protected int health;
	protected static int size;
	
	public Battleship(int size) {
		this.hasSunk = false;
		this.health = size;
	}
	
	// removes health and sinks ship if no health left
	public void damage() {
		if(health > 0) {
			this.health--;
		}
		if(health == 0) {
			this.hasSunk = true;
		}

	}
	
	public static int getSize() {
		return size;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public Boolean hasSunk() {
		return this.hasSunk;
	}
}

	