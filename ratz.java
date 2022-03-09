import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ratz{
	char[][] mat;
	Scanner sc;
	int n;
	boolean out;
	
	@SuppressWarnings("serial")
	public ratz() throws FileNotFoundException {
		sc=new Scanner(new File("rats.dat"));
		n=sc.nextInt();
		for(int a=0;a<n;a++) {
			out=false;
			int b=sc.nextInt();
			mat=new char[b][0];
			sc.nextLine();
			for(int r=0;r<mat.length;r++){
				mat[r]=sc.nextLine().toCharArray();}
			
			for(int r=0;r<mat.length;r++) {
			String hold="";
			for(int c=0;c<mat[r].length;c++){
				if(mat[r][c]!=' ')
				hold+=mat[r][c];}
			mat[r]=hold.toCharArray();}
			
			for(int r=0;r<mat.length;r++){
			System.out.println(mat[r]);}

			for(int r=0;r<mat.length;r++) {
				for(int c=0;c<mat[r].length;c++){
					if(mat[r][c]=='M') {
					//System.out.println("Starts at "+r+","+c);
					escape(r,c);}
					}}
			if(out==true)
				System.out.println("The Giant Rat that makes all of da rulez");
			else
				System.out.println("Rat In Pepperonis");

			
		}
	}
	public void escape(int r,int c) {
		if(r>=0&&c>=0&&r<mat.length&&c<mat[r].length&&mat[r][c]!='#'&&out==false) {
			//System.out.println(r+","+c+mat[r][c]);
			if(mat[r][c]=='C') {
				out=true;
				return;
			}
			mat[r][c]='#';
			escape(r,c+1);
			escape(r-1,c);
			escape(r,c-1);
			escape(r+1,c);
		}
		return;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		ratz tat=new ratz();
}	
}

