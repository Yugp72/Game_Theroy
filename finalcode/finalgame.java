import java.util.Scanner;
import java.util.Arrays;
public class finalgame
{

	private static String[] allwords = {"Ant-Man","captionMarval","Avengers","doctorstrange","captionAmerica","spiderman","Ironman","BlackWidow", };
	private static String word = allwords[(int) (Math.random() * allwords.length)];
	private static String words = new String(new char[word.length()]).replace("\0", "*");
	private static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Game number to play the Game: ");
		System.out.println("1. HangMan");
		System.out.println("2. Tic Tac Toe");
		int num=sc.nextInt();
		switch(num){
			case 1:
				while (count < 7 && words.contains("*")) {
					System.out.println("Guess any letter in the word for Marval serice");
					System.out.println(words);
					String guess = sc.next();
					hang(guess);
				}
				break;
			case 2:
				board = new String[9];
				next = "X";
				String win = null;
		
				for (int a = 0; a < 9; a++) {
					board[a] = String.valueOf(a + 1);
				}
		
				System.out.println("Welcome to Tic Tac Toe.");
				printBoard();
		
				System.out.println("X's turn. Enter a slot number to place X in:");
		
				while (win == null) {
					int numInput;
					try {
						numInput = sc.nextInt();
						if (!(numInput > 0 && numInput <= 9)) {
							System.out.println("Invalid input; re-enter number:");
							continue;
						}
					}
					catch (Exception e) {
						System.out.println("Invalid input; re-enter number:");
						continue;
					}
					if (board[numInput - 1].equals(
							String.valueOf(numInput))) {
						board[numInput - 1] = next;
		
						if (next.equals("X")) {
							next = "0";
						}
						else {
							next = "X";
						}
		
						printBoard();
						win = win();
					}
					else {
						System.out.println("Slot already taken; re-enter	 number:");
					}
				}
				if (win.equalsIgnoreCase("draw")) {
					System.out.println("It's a draw! Thanks for playing.");
				}
				else {
					System.out.println("Congratulations! " + win + "'s have won! Thanks for playing.");
				}
				break;
			}

			


				
	}

	public static void hang(String guess) {
		String newword = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {
				newword += guess.charAt(0);
			} else if (words.charAt(i) != '*') {
				newword += word.charAt(i);
			} else {
				newword += "*";
			}
		}

		if (words.equals(newword)) {
			count++;
			hangmanImage();
		} else {
			words = newword;
		}
		if (words.equals(word)) {
			System.out.println("Correct, You guess the right word, The word was " + word);
		}
	}

	public static void hangmanImage() {
		if (count == 1) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (count == 2) {
			System.out.println("Wrong guess, try again");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 3) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (count == 4) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 5) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 6) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (count == 7) {
			System.out.println("GAME OVER!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("GAME OVER! The word was " + word);
		}
	}


	
	static String[] board;
	static String next;
	static String win()
	{
		for (int a = 0; a < 8; a++) {
			String solve = null;

			switch (a) {
			case 0:
				solve = board[0] + board[1] + board[2];
				break;
			case 1:
				solve = board[6] + board[7] + board[8];
				
				break;
			case 2:
				solve = board[2] + board[5] + board[8];
				break;
			case 3:
				solve = board[0] + board[3] + board[6];
				break;
			case 4:
				solve = board[1] + board[4] + board[7];
				break;
			case 5:
				solve = board[3] + board[4] + board[5];	
				break;
			case 6:
				solve = board[2] + board[4] + board[6];
				
				break;
			case 7:
				solve = board[0] + board[4] + board[8];
				break;
            }
			if (solve.equals("XXX")) {
				return "X";
			}
			else if (solve.equals("000")) {
				return "0";
			}
		}
		
		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
				break;
			}
			else if (a == 8) {
				return "draw";
			}
		}

		System.out.println(next + "'s turn; enter a slot number to place "+ next + " in:");
		return null;
	}
	
	
	// To print out the board.
    /* 
	  1 | 2 | 3  
	 ---|---|--- 
	  4 | 5 | 6  
	 ---|---|--- 
	  7 | 8 | 9  */
	
	static void printBoard()
	{
		System.out.println("  " + board[0] + " | "+ board[1] + " | " + board[2] );
		System.out.println(" ---|---|---");
		System.out.println("  " + board[3] + " | "+ board[4] + " | " + board[5] );
		System.out.println(" ---|---|---");
		System.out.println("  " + board[6] + " | "+ board[7] + " | " + board[8]);
	}
}

