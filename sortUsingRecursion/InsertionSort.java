package sortUsingRecursion;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,4,3,7,5,6,8,2};
		System.out.println("Given unsorted array ");
		for(int i=0;i<a.length;i++) {
            System.out.print(a[i]+" ");		
		}
		a=insertionSort(a,1,0);
		System.out.println();
		System.out.println("sorted array ");
		for(int i=0;i<a.length;i++) {
           System.out.print(a[i]+" ");		
		}
	}
	public static int[] insertionSort(int[] a,int i,int j) {
		if(i==a.length)
			return a;
		int temp=a[i];
		while(j>=0 && a[j]>temp) {
			a[j+1]=a[j];
			j--;
		}
		a[j+1]=temp;
		return insertionSort(a, i+1, i);
	}

}
