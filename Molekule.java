import java.util.Scanner;

public class Molekule{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<sc.nextInt();i++) {
		int junc=sc.nextInt();
		int swich=sc.nextInt();
		if(junc>=0&&swich%2==0)
			System.out.println("possible");
		else
			System.out.println("impossible");
		}
		
	}
}