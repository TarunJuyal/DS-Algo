package searchingAlgos;

public class ExponentialSearch {

	public static int search(int []a,int target) {
		int bound=1;
		while(bound<a.length && a[bound]<target)
			bound*=2;
		int left=bound/2;
		int right=Math.min(bound, a.length-1);
		return BinarySearch(a, target,left,right);
	}
	
	private static int BinarySearch(int[] a,int target,int low,int high) {
		if(low>high)
			return -1;
		int mid=(low+high)/2;
		if(a[mid]==target)
			return mid;
		if(a[mid]<target)
			return BinarySearch(a, target, mid+1, high);
		else
			return BinarySearch(a, target, low, mid-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {10,20,40,50,70,80};             //only works on sorted array.
		System.out.println(search(a, 10));
	}

}
