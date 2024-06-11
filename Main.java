import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		
		
		// creates board
		Board board1 = new Board(10,10);
		
		// gets player names
		System.out.print("Welcome to Battleships\nPlayer 1 enter name: ");
		String p1Input = scan.nextLine();		
		System.out.print("Player 2 enter name: ");
		String p2Input = scan.nextLine();
		
		// creates player instances
		Player player1 = new Player(p1Input, board1);
		Player player2 = new Player(p2Input, board1);	
		
		Player currentPlayer = player1;
		Player otherPlayer = player2;
		
		System.out.println(board1); // print board so players know how to use co-ordinates
		
		Boolean end = false;	
		
		while(!end) {		
			// player takes their turn and then board gets printed
			end = currentPlayer.takeTurn(scan);
			System.out.println(currentPlayer.getBoard());
			
			// un-comment this to get updates on number of ships remaining on the board and player scores every round
			//System.out.println("battleships left: " + board1.getBattleshipsRemaining());
			//System.out.println(String.format("%s's score is %d and %s's score is %d", player1.getName(), player1.getScore(), player2.getName(), player2.getScore()));

			
			// swaps the current player
			Player temp = currentPlayer;
			currentPlayer = otherPlayer;
			otherPlayer = temp;
		}
		
		// prints score and decides who wins
		System.out.println(String.format("%s's score is %d and %s's score is %d", player1.getName(), player1.getScore(), player2.getName(), player2.getScore()));
		if(player1.getScore() > player2.getScore()) {
			System.out.println(player1.getName() + " won, congratulations!");
		} else if(player1.getScore() < player2.getScore()) {
			System.out.println(player2.getName() + " won, congratulations!");
		} else {
			System.out.println("It's a draw");
		}
		
		scan.close(); 
	}

}
