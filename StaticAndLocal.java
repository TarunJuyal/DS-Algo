// Local variable clones with every call but static variable just updates its value.

public class StaticAndLocal {
	
	static int x=0;
	public static int fun(int n) {
		//int x=0;
		if(n>0) {
			x++;
			return fun(n-1)+x;
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fun(5));
	}

}
