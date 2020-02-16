package oneDArray;

//left shift by n 

public class RotateAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int a[]= {1,2,3,4,5,6,7};
       int n=3;
       System.out.print("Given Array ");
		for(int i:a) {
			System.out.print(" "+i);
		}
		System.out.println();
		rotate(a,n);
		System.out.print("Rotated Array ");
		for(int i:a) {
			System.out.print(" "+i);
		}
	}
	static void reverse(int a[], int start, int end){
		int temp = 0;
		while(start<end) {
			temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
		}
	static void rotate(int[] a,int n) {
		reverse(a,0,n-1);
		reverse(a,n,a.length-1);
		reverse(a,0,a.length-1);
	}

}
