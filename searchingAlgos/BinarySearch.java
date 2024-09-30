package searchingAlgos;

public class BinarySearch {
	
	public static int searchIterative(int[] a,int target) {
		int low=0,high=a.length-1;
		while(low<=high) {
			int mid=(low+high)/2;
			if(a[mid]==target)
				return mid;
			if(a[mid]<target)
				low=mid+1;
			else
				high=mid-1;
		}
		return -1;
	}
	
	public static int searchRecursive(int[] a,int target) {
		return searchRecursive(a, target,0,a.length-1);
	}
	private static int searchRecursive(int[] a,int target,int low,int high) {
		if(low>high)
			return -1;
		int mid=(low+high)/2;
		if(a[mid]==target)
			return mid;
		if(a[mid]<target)
			return searchRecursive(a, target, mid+1, high);
		else
			return searchRecursive(a, target, low, mid-1);
	}
}
