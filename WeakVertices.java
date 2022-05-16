import java.util.HashMap;
import java.util.Scanner;

public class WeakVertices{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=0;
		while(n!=-1) {
		HashMap<Double,Integer> Verts=new HashMap<Double,Integer>();
		n=sc.nextInt();
		if(n<0) {break;}
		int[][] preadmat=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				admat[i][j]=sc.nextInt();
		}
		}
		for(int i=0;i<n;i++) {for(int j=0;j<i;j++) {System.out.print(admat[i][j]);}System.out.println();}
		
		}
}
}