package oneDArray;


public class ReverseArray {

	public static void main(String[] args) {
		int a[]= {1,2,3,4,5,6,7,8,9};
		System.out.print("Given Array ");
		for(int i:a) {
			System.out.print(" "+i);
		}
		revArray(a);
		System.out.println();
		System.out.print("Reverse Array ");
		for(int i:a) {
			System.out.print(" "+i);
		}
	}
	static void revArray(int[] a) {
		int i=0,j=a.length-1;
		while(i<j) {
			int t=a[i];
			a[i]=a[j];
			a[j]=t;
			i++;
			j--;
		}
	}
}
