package oneDArray;



public class TopThreeLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,2,3,4,7,17,6,9,8};
		int first=Integer.MIN_VALUE,second=Integer.MIN_VALUE,third=Integer.MIN_VALUE;
		for(int i=1;i<a.length;i++) {
			if(a[i]>third) {
				third=a[i];
			}
			else if(a[i]>second) {
				third=second;
				second=a[i];
			}
			else if(a[i]>first) {
				third=second;
				second=first;
				first=a[i];
			}  
		}
		System.out.println("first largest is: "+first);
		System.out.println("second largest is: "+second);
		System.out.println("third largest is: "+third);
	}

}
