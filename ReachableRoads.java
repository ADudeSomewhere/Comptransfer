import java.util.Scanner;

public class ReachableRoads{
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for (int a=0;a<n;a++) {
		int towns=sc.nextInt();
		int roads=sc.nextInt();
		//System.out.println(towns+" this is towns"+"\n"+roads+" this is roads");
		for (int b=0;b<=roads;b++) {
			sc.nextLine();
		}
				System.out.println(((towns-1)-roads));
		}
		

		
	}
}