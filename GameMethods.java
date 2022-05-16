import java.util.Scanner;

public class GameMethods {
	private static char[][] gameboard;
	private boolean atleastone;
	public GameMethods() {//functional
		gameboard=new char[8][8];
		for(int i=0;i<gameboard.length;i++) {
		for(int j=0;j<gameboard[i].length;j++) {
			gameboard[i][j]='#';
		}}
		gameboard[3][3]='W';
		gameboard[4][4]='W';
		gameboard[3][4]='B';
		gameboard[4][3]='B';
		atleastone=false;
	}
	public void getState() {//functional
		for(int i=0;i<gameboard.length;i++) {
			for(int j=0;j<gameboard.length;j++) {
			System.out.print(gameboard[i][j]+" ");}
			System.out.println();
			}
		System.out.println();
	}	
	public char getSquare(char x, int y) {//functional
		int tc=0;
		if((x=='A'||x=='B'||x=='C'||x=='D'||x=='E'||x=='F'||x=='G'||x=='H')&&(y>=1&&y<=8)) {
			if(x=='A') {tc=0;}
			if(x=='B') {tc=1;}
			if(x=='C') {tc=2;}
			if(x=='D') {tc=3;}
			if(x=='E') {tc=4;}
			if(x=='F') {tc=5;}
			if(x=='G') {tc=6;}
			if(x=='H') {tc=7;}
	}
		if(y<=0) {y=1;}
		return(getSquare(y-1,tc));

	}
	private char getSquare(int x, int y) {
			return gameboard[x][y];
	}
		
	public void getWinner() {//functional
		if(isItOver()==true) {
			if(getWhite()>getBlack()) {
				System.out.println("White Wins with "+getWhite()+" points!");
			}
			else if(getWhite()<getBlack()) {
				System.out.println("Black Wins with "+getBlack()+" points!");
			}
			else {
				System.out.println("It's a draw.");
			}
		}
	}
	public boolean shouldSkipTurn(char color) {
		boolean skip=true;
		for(int r=0;r<gameboard.length;r++) {
			for(int c=0;c<gameboard.length;c++) {
				if(isValidPlace(color,c,r)==true) {skip=false;}
			}
		}
		return skip;
	}
	public boolean isItOver() {
		if((getEmpty()==0||getWhite()==0||getBlack()==0)||(shouldSkipTurn('W')==false&&shouldSkipTurn('B')==false)) {return true;} else {return false;}
	}
	public int getWhite() {
		int white=0;
		for(int r=0;r<gameboard.length;r++) {
			for(int c=0;c<gameboard[r].length;c++) {
				if(gameboard[r][c]=='W')
					white+=1;}}
		return white;
	}
	public int getBlack() {
		int black=0;	
		for(int r=0;r<gameboard.length;r++) {
			for(int c=0;c<gameboard[r].length;c++) {
				if(gameboard[r][c]=='B')
					black+=1;
			}
		}
		return black;
	}
	private int getEmpty() {
		int empty=0;	
		for(int r=0;r<gameboard.length;r++) {
			for(int c=0;c<gameboard[r].length;c++) {
				if(gameboard[r][c]=='#')
					empty+=1;
			}
		}
		return empty;
	}
	public void placePiece(char color,char x,int y) {
		if((x=='A'||x=='B'||x=='C'||x=='D'||x=='E'||x=='F'||x=='G'||x=='H')&&(y>=1&&y<=8)) {
		int tc=0;
		if(x=='A') {tc=0;}
		if(x=='B') {tc=1;}
		if(x=='C') {tc=2;}
		if(x=='D') {tc=3;}
		if(x=='E') {tc=4;}
		if(x=='F') {tc=5;}
		if(x=='G') {tc=6;}
		if(x=='H') {tc=7;}
		placePiece(color,y-1,tc);
		}
		//else {throw new IllegalArgumentException("That's not an actual position");}			
	}
	private void placePiece(char color,int r,int c) {
		if(color=='W'||color=='B') {
		if(isValidPlace(color,r,c)==true) {
			gameboard[r][c]=color;
			capture(color,r,c);}
		else {//throw new IllegalArgumentException("Illegal position");
		System.out.println("Illegal position");}
		}
		//else {throw new IllegalArgumentException("That's not one of the colors, you fool");}
	}
	private void capture(char color, int r,int c){//remember, down is +, up is -. right is +, left is -
		atleastone=false;
		int holdr=r;
		int holdc=c;
		if(checkUp(color,r-1,c)==true) {//
			r-=1;
			while(r<gameboard.length&&r>=0&&c<gameboard[r].length&&c>=0&&gameboard[r][c]!='#'&&gameboard[r][c]!=color) {
				gameboard[r][c]=color;
				r-=1;}
			atleastone=false;r=holdr;c=holdc;}
		if(checkDown(color,r+1,c)==true) {//
			r+=1;
			while(r<gameboard.length&&r>=0&&c<gameboard[r].length&&c>=0&&gameboard[r][c]!='#'&&gameboard[r][c]!=color) {
				gameboard[r][c]=color;
				r+=1;}
			atleastone=false;r=holdr;c=holdc;}
		if(checkLeft(color,r,c-1)==true) {//
			c-=1;
			while(r<gameboard.length&&r>=0&&c<gameboard[r].length&&c>=0&&gameboard[r][c]!='#'&&gameboard[r][c]!=color) {
				gameboard[r][c]=color;
				c-=1;}
			atleastone=false;r=holdr;c=holdc;}
		if(checkRight(color,r,c+1)==true) {//
			c+=1;
			while(r<gameboard.length&&r>=0&&c<gameboard[r].length&&c>=0&&gameboard[r][c]!='#'&&gameboard[r][c]!=color) {
				gameboard[r][c]=color;
				c+=1;}
			atleastone=false;r=holdr;c=holdc;}
		if(checkUR(color,r-1,c+1)==true) {//
			r-=1;
			c+=1;
			while(r<gameboard.length&&r>=0&&c<gameboard[r].length&&c>=0&&gameboard[r][c]!='#'&&gameboard[r][c]!=color) {
				gameboard[r][c]=color;
				r-=1;
				c+=1;}
			atleastone=false;r=holdr;c=holdc;}
		if(checkUL(color,r-1,c-1)==true) {//
			r-=1;
			c-=1;
			while(r<gameboard.length&&r>=0&&c<gameboard[r].length&&c>=0&&gameboard[r][c]!='#'&&gameboard[r][c]!=color) {
				gameboard[r][c]=color;
				r-=1;
				c-=1;}
			atleastone=false;r=holdr;c=holdc;}
		if(checkDR(color,r+1,c+1)==true) {
			r+=1;
			c+=1;
			while(r<gameboard.length&&r>=0&&c<gameboard[r].length&&c>=0&&gameboard[r][c]!='#'&&gameboard[r][c]!=color) {
				gameboard[r][c]=color;
				r+=1;
				c+=1;}
			atleastone=false;r=holdr;c=holdc;}
		if(checkDL(color,r+1,c-1)==true) {
			r+=1;
			c-=1;
			while(r<gameboard.length&&r>=0&&c<gameboard[r].length&&c>=0&&gameboard[r][c]!='#'&&gameboard[r][c]!=color) {
				gameboard[r][c]=color;
				r+=1;
				c-=1;}
			atleastone=false;r=holdr;c=holdc;}
	}
	public boolean isValidPlacePub(char color,char x,int y) {
		if((x=='A'||x=='B'||x=='C'||x=='D'||x=='E'||x=='F'||x=='G'||x=='H')&&(y>=1&&y<=8)) {
		int tc=0;
		if(x=='A') {tc=0;}
		if(x=='B') {tc=1;}
		if(x=='C') {tc=2;}
		if(x=='D') {tc=3;}
		if(x=='E') {tc=4;}
		if(x=='F') {tc=5;}
		if(x=='G') {tc=6;}
		if(x=='H') {tc=7;}
		return isValidPlace(color,y-1,tc);
		}
		return false;
	}
	
	private boolean isValidPlace(char color, int r,int c){//remember, down is +, up is -. right is +, left is - WORKS, I THINK
		if(gameboard[r][c]=='#'&&r<gameboard.length&&r>=0&&c<gameboard[r].length&&c>=0) {
			atleastone=false;
			return (checkUp(color,r-1,c)||checkDown(color,r+1,c)||checkLeft(color,r,c-1)||checkRight(color,r,c+1)||checkUR(color,r-1,c+1)||checkUL(color,r-1,c-1)||checkDR(color,r+1,c+1)||checkDL(color,r+1,c-1));
		}
		else {
		return false;}
	}
	private boolean checkUp(char color, int r,int c){
		if(r<gameboard.length&&r>=0&&c<gameboard[r].length&&c>=0&&gameboard[r][c]!='#') {
			if(gameboard[r][c]==color&&atleastone==true) {
				return true;}
			if(gameboard[r][c]!=color) {
				atleastone=true;
			}
			return checkUp(color,r-1,c);}
		return false;
	}
	private boolean checkDown(char color, int r,int c){
		if(r<gameboard.length&&r>=0&&c<gameboard[r].length&&c>=0&&gameboard[r][c]!='#') {
			if(gameboard[r][c]==color&&atleastone==true) {
				return true;}
			if(gameboard[r][c]!=color) {
				atleastone=true;
			}
			return checkDown(color,r+1,c);}
		return false;
	}
	private boolean checkLeft(char color, int r,int c){
		if(r<gameboard.length&&r>=0&&c<gameboard[r].length&&c>=0&&gameboard[r][c]!='#') {
			if(gameboard[r][c]==color&&atleastone==true) {
				return true;}
			if(gameboard[r][c]!=color) {
				atleastone=true;
			}
			return checkLeft(color,r,c-1);}
		return false;
	}
	private boolean checkRight(char color, int r,int c){
		if(r<gameboard.length&&r>=0&&c<gameboard[r].length&&c>=0&&gameboard[r][c]!='#') {
			if(gameboard[r][c]==color&&atleastone==true) {
				return true;}
			if(gameboard[r][c]!=color) {
				atleastone=true;
			}
			return checkRight(color,r,c+1);}
		return false;
	}
	private boolean checkUR(char color, int r,int c){
		if(r<gameboard.length&&r>=0&&c<gameboard[r].length&&c>=0&&gameboard[r][c]!='#') {
			if(gameboard[r][c]==color&&atleastone==true) {
				return true;}
			if(gameboard[r][c]!=color) {
				atleastone=true;
			}
			return checkUR(color,r-1,c+1);}
		return false;
	}
	private boolean checkUL(char color, int r,int c){
		if(r<gameboard.length&&r>=0&&c<gameboard[r].length&&c>=0&&gameboard[r][c]!='#') {
			if(gameboard[r][c]==color&&atleastone==true) {
				return true;}
			if(gameboard[r][c]!=color) {
				atleastone=true;
			}
			return checkUL(color,r-1,c-1);}
		return false;
	}
	private boolean checkDR(char color, int r,int c){
		if(r<gameboard.length&&r>=0&&c<gameboard[r].length&&c>=0&&gameboard[r][c]!='#') {
			if(gameboard[r][c]==color&&atleastone==true) {
				return true;}
			if(gameboard[r][c]!=color) {
				atleastone=true;
			}
			return checkDR(color,r+1,c+1);}
		return false;
	}	
	private boolean checkDL(char color, int r,int c){
		if(r<gameboard.length&&r>=0&&c<gameboard[r].length&&c>=0&&gameboard[r][c]!='#') {
			if(gameboard[r][c]==color&&atleastone==true) {
				return true;}
			if(gameboard[r][c]!=color) {
				atleastone=true;
			}
			return checkDL(color,r+1,c-1);}
		return false;
	}

	public static void main(String[] args) {
		GameMethods benice= new GameMethods();
		benice.placePiece('W','D',6);
		benice.getState();
		benice.placePiece('B','C',6);		
		benice.getState();

	}
}