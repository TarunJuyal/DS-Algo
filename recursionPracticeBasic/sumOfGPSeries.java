package recursionPracticeBasic;

public class sumOfGPSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println(findSum(2,5) );
	}
	public static double findSum(int a, int n) {
		if(n==0)
			return 1;
		return Math.pow((double)a,(double)n)+findSum(a, n-1);
	}

}
