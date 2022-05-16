import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordMethods{
	
	private ArrayList<Character> wordWord; // zee wordWord
	private static Scanner dict;
	public WordMethods(String s) {
		s=s.toLowerCase();
		wordWord = convert(s);
		try {dict=new Scanner(new File("WordleDictionary.txt"));} catch (FileNotFoundException e) {e.printStackTrace();}
	}
	public WordMethods() {
		try {dict=new Scanner(new File("WordleDictionary.txt"));} catch (FileNotFoundException e) {e.printStackTrace();}
		wordWord = convert(getWord());

	}
	
	public boolean[] check(char let, int pos) { // let = letter to check, pos = position of letter in word
		boolean[] pain = {false, false};
		if (wordWord.indexOf(let) != -1) {
			pain[0] = true;
			if (wordWord.indexOf(let) == pos) {
				pain[1] = true;
			}
		}
		return pain; // {0, 1} 0 = is letter a part of wordWord, 1 = is letter's position in word the same as the letter's position in wordWord
	}
	 public ArrayList<Character> convert(String word){
		 	word=word.toLowerCase();
			ArrayList<Character> pain = new ArrayList<Character>();
			for (int x = 0; x < word.length(); x++) {
				pain.add(word.charAt(x));
			}
			return pain;
		}
	 public boolean isWord(String a) {
		 a=a.toLowerCase();
		 boolean hasit=false;
		 String d="";
		 while(dict.hasNext()) {
			 if(a.equals(d)) {
				 hasit=true;
				 break;
			 	} 
			 d=dict.next();
		 	}
		 try {dict=new Scanner(new File("WordleDictionary.txt"));} catch (FileNotFoundException e) {e.printStackTrace();}
		 return hasit;
	 	}
	 public String getWord() {
		 int numpick=(int) ((Math.random()*8548)+1);
		 String a="";
		 for (int i=1;i<=8548&&i<=numpick;i++) {
			 a=dict.next();
			 if(numpick==i) {
				 break;
			 }
		 }
		 return a;
	 }
	 
	public static void main( String args[] )
	{
		ArrayList<Character> e=new ArrayList<Character>();
		e.add('A');
		e.add('P');
		e.add('P');
		e.add('L');
		e.add('E');
		WordMethods run = new WordMethods("BROWN");
		System.out.println(run.check('b', 2)[0]+" "+run.check('b', 2)[1]);
		System.out.println(run.check('b', 0)[0]+" "+run.check('b', 0)[1]);
		System.out.println(run.check('a', 0)[0]+" "+run.check('a', 0)[1]);
		System.out.println(run.check('a', 2)[0]+" "+run.check('a', 2)[1]);
		System.out.println("is browg a word?"+run.isWord("browg"));
		System.out.println("is brown a word?"+run.isWord("brown"));
		System.out.println(run.getWord());

		
	}
}

//char[] ye=w.toCharArray();
//int i=0;
//while(wordWord.size()!=ye.length) {
//	wordWord.add(ye[i]);
//	i+=1;
//}