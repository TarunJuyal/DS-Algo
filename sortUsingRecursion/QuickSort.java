package sortUsingRecursion;

/*select last element as pivot element of array.The idea is to place pivot element to its correct position 
 * and then repeating same process for left and right sub arrays.
 */

public class QuickSort {
	static int partition(int []a,int low,int high) {
		int pivot=a[high];
		int i=low-1;											//this variable store position of element in array currently traversed less than pivot.
		for(int j=low;j<high;j++) {
			if(a[j]<pivot) {
				i++;											//first increase position and then swap for correct operation.
				int temp=a[j];
				a[j]=a[i];
				a[i]=temp;
			}
		}
		int temp=a[i+1];
		a[i+1]=a[high];
		a[high]=temp;
		return i+1;
	}
	static void quickSort(int a[],int low,int high) {
		if(low<high) {
			int p=partition(a,low,high);
			quickSort(a, low, p-1);
			quickSort(a, p+1, high);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {4,2,5,3,6,1};
		quickSort(a,0,a.length-1);
		System.out.println("Sorted array: ");
		for(int i:a)
			System.out.print(i+" ");
	}

}
