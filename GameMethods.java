import java.util.Scanner;

public class GameMethods {
	private char[][] gameboard;
	Scanner sc;
	
	public GameMethods() {
		gameboard=new char[8][8];
		for(int i=0;i<gameboard.length;i++) {
		for(int j=0;j<gameboard[i].length;j++) {
			gameboard[i][j]='#';
		}}
		gameboard[3][3]='W';
		gameboard[4][4]='W';
		gameboard[3][4]='B';
		gameboard[4][3]='B';
		sc=new Scanner(System.in);
	}
	public void getState() {
		for(int i=0;i<gameboard.length;i++) {
			System.out.println(gameboard[i]);}
	}
	public char getSquare(int r, int c) {
		return(gameboard[r][c]);
	}
	public void getWinner() {
		int white=0;
		int black=0;
		for(int r=0;r<gameboard.length;r++) {
			for(int c=0;c<gameboard.length;c++) {
				if(gameboard[r][c]=='W')
					white+=1;
				if(gameboard[r][c]=='B')
					black+=1;
			}
		}
		if(white>black)
			System.out.println("White Wins!");
		else if(black>white)
			System.out.println("Black Wins!");
		else if(black==white)
			System.out.println("Draw");
	}
	public void main(String[] args) {
		GameMethods benice= new GameMethods();
		benice.getSquare(4,4);
		benice.getState();
		System.out.println();
		
	}
}