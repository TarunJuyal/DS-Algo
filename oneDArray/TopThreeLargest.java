package oneDArray;



public class TopThreeLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,2,3,4,7,17,6,9,8};
		int first=Integer.MIN_VALUE,second=Integer.MIN_VALUE,third=Integer.MIN_VALUE;
		for(int i=1;i<a.length;i++) {
			if(a[i]>first) {
				second=first;
				third=second;
				first=a[i];
				}
			if(a[i]>second && a[i]<first) {
				third=second;
				second=a[i];
			}  
			if(a[i]>third && a[i]<second) {
				third=a[i];
			}
		}
		System.out.println("first largest is: "+first);
		System.out.println("second largest is: "+second);
		System.out.println("third largest is: "+third);
	}

}
