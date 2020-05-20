package sorting;

//find minimum element index in sub array and put it at the first position of sub array.

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {2,4,3,7,6,9,5,8};
		for(int i=0;i<a.length;i++) {
			int min=i;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]<a[min]) {
					min=j;
				}
			}
			int temp=a[i];
			a[i]=a[min];
			a[min]=temp;
		}
		System.out.println("Sorted array: ");
		for(int i:a)
			System.out.print(i+" ");
	}

}
