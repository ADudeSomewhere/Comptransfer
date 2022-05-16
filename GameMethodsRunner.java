import java.util.Scanner;

public class GameMethodsRunner{
boolean turn=true;//true==white,black=false
public GameMethodsRunner() {
GameMethods a=new GameMethods();	
Scanner sc=new Scanner(System.in);
		System.out.println("This is the game of Othello. To play, you must place your piece on an empty tile, so that at least one of your opponent's tiles are between your new piece and old piece. "
		+ "\nThis will capture the enemy piece(s), in any and all directions that they're between your newly placed piece and one of your already existing tiles. You must ALWAYS capture an enemy piece. "
		+ "\nTo win, have more pieces than the other player by the time the board's full, or put them in a position they can't capture any more pieces. Remember to have fun(and also go for the corners)!");

while(a.isItOver()==false) {
	char tc;
	if(turn==true) {tc='W';}else{tc='B';}
	System.out.println();
	a.getState();
	System.out.println("Please input your place, in the format of (x y), with x being a CAPITAL letter and y a number. It is player "+tc+"'s turn.");
	char px=sc.next().toUpperCase().toCharArray()[0];
	int py=sc.nextInt();
	while(a.isValidPlacePub(tc, px, py)==false&&a.shouldSkipTurn(tc)==false){
		System.out.println(px+" "+py+" is an illegal move, try again, idiot.");
		px=sc.next().toUpperCase().toCharArray()[0];
		py=sc.nextInt();
	}
	a.placePiece(tc,px,py);
if(a.isItOver()==true) {
	a.getWinner();
	break;}
if(a.shouldSkipTurn(tc)==false) {
if(turn==true) {turn=false;}
else {turn=true;}}
}

}
public static void main(String[] args) {
	GameMethodsRunner run=new GameMethodsRunner();
}
}