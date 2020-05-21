package sortUsingRecursion;

//using middle element as pivot.

public class QuickSort01 {
	static void quickSort(int a[],int low,int high) {
		if(low>=high){
			return ;
		}
		int mid=(low+high)/2;
		int pivot=a[mid];
		int left=low;
		int right=high;
		while(left<=right) {
			while(a[left]<pivot) {
				left++;
			}
			while(a[right]>pivot) {
				right--;
			}
			if(left<=right) {
				int temp = a[left];
				a[left] = a[right];
				a[right] = temp;
				left++;
				right--;
			}
		}
		quickSort(a, low, right);
		quickSort(a, left, high);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {40,20,50,30,60,10};
		quickSort(a,0,a.length-1);
		System.out.println("Sorted array: ");
		for(int i:a)
			System.out.print(i+" ");
	}

}
