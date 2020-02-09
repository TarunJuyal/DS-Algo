package recursionPracticeBasic;

public class sumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(findSumDigits(2345));
	}
	public static int findSumDigits(int n) {
		if(n==0)
			return 0;
		int d=n%10;
		return d+findSumDigits(n/10);
	}

}
