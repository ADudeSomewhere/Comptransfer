import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Grinch{

	char[][] mat;
	Scanner sc;
	int n;
	boolean out;
	int nofound;
	int least;
	int time;
	int row;
	int col;
	@SuppressWarnings("serial")
	public Grinch() throws FileNotFoundException {
		sc=new Scanner(new File("grinch.dat"));
		n=sc.nextInt();
		for(int a=0;a<n;a++) {
			least=Integer.MAX_VALUE;
			time=0;
			nofound=0;
			out=false;
			int b=sc.nextInt();
			int l=sc.nextInt();
			int child=sc.nextInt();
						
			mat=new char[b][l];
			sc.nextLine();
			for(int r=0;r<mat.length;r++){
				mat[r]=sc.nextLine().toCharArray();}
			
			for(int r=0;r<mat.length;r++){
			System.out.println(mat[r]);}

			for(int r=0;r<mat.length;r++) {
				for(int c=0;c<mat[r].length;c++){
					if(mat[r][c]=='R') {
					//System.out.println("Starts at "+r+","+c);
					row=r;
					col=c;
					for(int i=0;i<=child;i++) {
					escape(r,c,0);}}
					}}
			System.out.println(nofound+","+time);
			if(nofound==child)
				System.out.println(time);
			else
				System.out.println("Get Grinched lmao");
		}
	}
			public void escape(int r,int c, int steps) {
				if(r>=0&&c>=0&&r<mat.length&&c<mat[r].length&&mat[r][c]!='#'&&out==false&&steps<=least) {
					System.out.println(r+","+c+"["+mat[r][c]+"]");
					if(mat[r][c]=='T') {
						mat[r][c]='.';
						time+=steps;
						least=steps;
						nofound+=1;
						escape(row,col,steps+1);
						return;
					}
					else {
					mat[r][c]='#';
					
					escape(r,c+1,steps+1);
					escape(r-1,c,steps+1);
					escape(r,c-1,steps+1);
					escape(r+1,c,steps+1);}
				}
				return;
			}
			
			public static void main(String[] args) throws FileNotFoundException {
				
				Grinch tat=new Grinch();
		}	
		}