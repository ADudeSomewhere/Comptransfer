import java.util.*;

public class Wordle{
	public static void main(String args[]) {
		String closeWord = "_____";
		String keyboard = "q w e r t y u i o p\n"
				+ " a s d f g h j k l\n"
				+ "  z x c v b n m\n";
		
		Scanner kb = new Scanner(System.in);
		WordMethods bill= new WordMethods();

		/* get zee random ward somehow
		 * 
		 * put zee ward in va variable
		 */
		
		System.out.println("It is time to play a game, a game which we call wordle\n"
				+ "You will have 6 chances to guess the 5 letter word we are thinking\n"
				+ "We will tell you which letters are in the word when you guess them\n"
				+ "We will also tell you if the letters are in the correct place\n"
				+ "Good luck. We'll see if you make it.");
		
		System.out.print("\nPrint your word, plebian:");
		
		String word = kb.next();
		
		while(word.length()!=5||bill.isWord(word)==false) {
			System.out.print("Try again, fool:");
			word = kb.next();
		}
		//System.out.print(word);
		
		ArrayList<Character> guess = new ArrayList<Character>();
		guess = bill.convert(word);
		
		// remember, closeWord and keyboard is string.
		
		for (int x = 0; x < 5; x++) {
			boolean[] stat = null;
			char let = guess.get(x);
			stat = bill.check(let, x);
			if (stat[0]) {
				if (keyboard.indexOf(let) != -1) {
					keyboard = keyboard.substring(0,keyboard.indexOf(let)) + (let - 32) + keyboard.substring(keyboard.indexOf(let)+1);
				}
			}
			else if (!stat[0]) {
				if (keyboard.indexOf(let) != -1) {
					keyboard = keyboard.substring(0,keyboard.indexOf(let)) + "_" + keyboard.substring(keyboard.indexOf(let)+1);
				}
			}
			if (stat[1]) {
				closeWord = closeWord.substring(0,x) + let + closeWord.substring(x+1);
			}
		}
		
		/*
		 * then die (again)
		 * 
		 * then loop this hell that we are in
		 */
	}
}