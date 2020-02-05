package recursionPracticeBasic;

public class factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(factorialCount(6));
	}
	public static int factorialCount(int n) {
		if(n==0)
			return 1;
		return n*factorialCount(n-1);
	}

}
