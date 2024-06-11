
public class MediumBattleship extends Battleship{
	private static final int size = 2;
	private static final int numberAvailable = 2;
	
	public MediumBattleship() {
		super(size);
	}
	
	public static int getSize() {
		return size;
	}

	public static int getNumberAvailable() {
		return numberAvailable;
	}
}