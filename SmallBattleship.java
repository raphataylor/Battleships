
public class SmallBattleship extends Battleship{
	private static final int size = 1;
	private static final int numberAvailable = 3;
	
	public SmallBattleship() {
		super(size);
	}
	
	public static int getSize() {
		return size;
	}
	
	public static int getNumberAvailable() {
		return numberAvailable;
	}
}
