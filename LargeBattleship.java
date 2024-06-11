
public class LargeBattleship extends Battleship{
	private static final int size = 3;
	private static final int numberAvailable = 1;
	
	public LargeBattleship() {
		super(size);
	}
	
	public static int getSize() {
		return size;
	}

	public static int getNumberAvailable() {
		return numberAvailable;
	}
}