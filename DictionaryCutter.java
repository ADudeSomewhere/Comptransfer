import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class DictionaryCutter{
	Scanner sc;
	PrintStream thatsalottadamage;
	
	public DictionaryCutter() throws FileNotFoundException{
	sc=new Scanner(new File("dictionary.txt"));
	thatsalottadamage= new PrintStream("WordleDictionary.txt");
	String holder="";
	
	while(sc.hasNextLine()) {
	holder=sc.nextLine();
	if(holder.length()==5) {
	thatsalottadamage.println(holder);}
	}
	}
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException  {
		DictionaryCutter howboutsomemore=new DictionaryCutter();}
	
}