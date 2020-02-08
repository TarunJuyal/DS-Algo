package recursionPracticeBasic;

public class checkIfSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int a[]= {0,1,3,4,7,8,5};
	    System.out.println(check(a,0));
	}
	public static boolean check(int a[],int i) {
		if(i==a.length-1)
			return true;
		if(a[i]>a[i+1])
			return false;
		return check(a,i+1);
	}

}
