package sorting;

//pick a element and put it in its correct position in the already traversed part of array by shifting.

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {2,4,3,7,6,9,5,8};
		for(int i=1;i<a.length;i++) {
			int temp=a[i];
			int j=i-1;
			while(j>=0 && a[j]>temp) {
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=temp;;
		}
		System.out.println("Sorted array: ");
		for(int i:a)
			System.out.print(i+" ");
	}

}
