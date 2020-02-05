package recursionPracticeBasic;

public class pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printRow(5,1);
		}
	public static void printStar(int i) {
		if(i==0)
			return;
		System.out.print("*");
		printStar(i-1);
		}
	public static void printRow(int n, int i) {
		if(n==0)
			return;
		printStar(i);
		System.out.println();
		printRow(n-1,i+1);
		}


}
