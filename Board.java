import java.util.Random;

public class Board {
	private Square[][] board;
	private int battleshipsRemaining;
	
	public Board(int row, int col) {
		this.board = new Square[row][col];
		battleshipsRemaining = SmallBattleship.getNumberAvailable() + 
								MediumBattleship.getNumberAvailable() + 
								LargeBattleship.getNumberAvailable();		
		createBoard();
		generateAllShips();
	}
	
	// fills board with square objects
	public void createBoard() {
		for(int i = 0; i<board.length;i++) {
			for(int j = 0; j<board.length;j++) {
				board[i][j] = new Square(i, j);
			}
		}
	}	

	public int getBattleshipsRemaining() {
		return battleshipsRemaining;
	}
		
	public Square getSquare(int row, int col) {
		return board[row][col];
	}
	
	// decrements number of ships on the game board
	public void sinkShip() {
		this.battleshipsRemaining--;
	}

	// prints board to console
	public String toString() {
		String output = "";
		
		// print column number
		output += "    ";
		for(int i = 0; i < board.length; i++) {
			output += String.format("%3s", i);
		}
		output += "\n";
		
		// print row number and square status
		for(int i = 0; i<board.length;i++) {
			output += String.format("%4s", i);
			for(int j = 0; j<board.length;j++) {
				output += board[i][j];
			}
			output += "\n";
		}
		return output;
	}
	
	// generates several sub-classes of Battleship using static variables
	public void generateAllShips() {
		generateBattleships(SmallBattleship.getSize(), SmallBattleship.getNumberAvailable());
		generateBattleships(MediumBattleship.getSize(), MediumBattleship.getNumberAvailable());
		generateBattleships(LargeBattleship.getSize(), LargeBattleship.getNumberAvailable());
	}
	
	// fills board with ships of random orientation
	public void generateBattleships(int size, int count) {
		Random r = new Random();
		
		int numberOfShips = count;// how many ships we want to place on board
		int shipSize = size;
		
		while(numberOfShips > 0) {
			Boolean horizontal = r.nextBoolean();// random vertical or horizontal
			
			int row = 0; int col = 0;// initialise row and column
				
			do {
				row = r.nextInt(board.length);// generate random co-ordinates
				col = r.nextInt(board.length);								
			} while(!okToPlace(row, col, shipSize, horizontal)); //checks if co-ords are ok
			
			placeShip(row, col, shipSize, horizontal); // places ship on board
			numberOfShips--;			
		}
	}
	
	// places a single ship on the board
	public void placeShip(int row, int col, int size, Boolean horizontal) {
		Battleship battleship = new Battleship(size);
		
		for(int i = 0; i < size; i++) {
			board[row][col].addShip(battleship);
			if (horizontal) {
				col++;
			} else {
				row++;
			}
		}
	}
	
	// checks if co-ordinates are valid
	public Boolean okToPlace(int row, int col, int size, Boolean horizontal) {		
		if(horizontal) {
			if(col > board.length-size) {
				return false;
			}
			for(int i = 0; i < size; i++) {
				if(board[row][col + i].hasShip()) {
					return false;
				}
			}
		}else {
			if(row > board.length-size) {
				return false;
			}
			for(int i = 0; i<size; i++) {
				if(board[row + i][col].hasShip()) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
