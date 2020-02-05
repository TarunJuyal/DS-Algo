package recursionPracticeBasic;

//even no btw 5 to 1 and odd between 1 to 5

public class stackBuildingAndFalling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       printCount(5);
	}
	public static void printCount(int n) {
		if(n==0)
			return;
		if(n%2==0)
		System.out.print(n+" ");
		printCount(n-1);
		if(n%2!=0)
		System.out.print(n+" ");
	}

}
