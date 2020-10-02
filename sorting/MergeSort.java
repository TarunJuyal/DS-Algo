package sorting;

public class MergeSort {

	public static void sort(int[] a) {
		
		if(a.length<2)
			return;
		
		int mid=a.length/2;
		
		int[] left=new int[mid];
		for(int i=0;i<mid;i++) {
			left[i]=a[i];
		}
		int[] right=new int[a.length-mid];
		for(int i=mid;i<a.length;i++) {
			right[i-mid]=a[i];
		}
		
		sort(left);
		sort(right);
		
		merge(left,right,a);
	}
	
	private static void merge(int[] left,int[] right,int[] result) {
		int i=0,j=0,k=0;
		while(i<left.length && j<right.length) {
			if(left[i] <=right[j])
				result[k++]=left[i++];
			else
				result[k++]=right[j++];
		}
		
		while(i < left.length)
			result[k++]=left[i++];
		
		while(j < right.length)
			result[k++]=right[j++];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {7,3,5,2,3,1,5,8};
		sort(a);
		System.out.println("Sorted array: ");
		for(int i:a)
			System.out.print(i+" ");
	}

}
