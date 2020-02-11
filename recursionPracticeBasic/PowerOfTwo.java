package recursionPracticeBasic;

public class PowerOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println(calculate(10));
	}
	public static int calculate(int n) {
		if(n==0)
			return 1;
		return 2*calculate(n-1);
	}

}
