import java.util.Scanner;

public class Player {
	private String name;
	private int score;
	private Board board;
	
	public Player(String name, Board board) {
		this.name = name;
		this.board = board;
		this.score = 0;
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public String getName() {
		return this.name;
	}
	
	// takes players turn
	public Boolean takeTurn(Scanner scanner) {
		
		// get player co-ordinates
		System.out.print("Captain " + this.name + "! what are your target co-ordinates: ");
		int row = scanner.nextInt();
		int col = scanner.nextInt();
		
		Square square = board.getSquare(row, col);		
		
		// already been targeted
		if(square.hasBeenFiredAt()) {
			System.out.println("We've already targeted this location Captain!");
			return false;
		}
			
		square.fireAt(); 
		
		if(!square.hasShip()){
			System.out.println("There was nothing there Captain!");
			return false;		
		} else {
			Battleship ship = square.getShip();
			
			System.out.println("You've hit a Battleship Captain!");			
			ship.damage();	// health - 1 and sink if no health left

			// if battleship sinks, decrease number of ships on the board and increment player score by 1
			if(ship.hasSunk()) {
				System.out.println("You've sunk it Captain! She's going down!");
				board.sinkShip();
				this.score++;
			}
		}
		// win condition: no more ships remaining on board.
		if(board.getBattleshipsRemaining() == 0) {
			return true;
		}
		
		return false;
		
	}
}
