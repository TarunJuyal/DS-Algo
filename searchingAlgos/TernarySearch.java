package searchingAlgos;

public class TernarySearch {

	public static int search(int[] a,int target) {
		int low=0,high=a.length-1;
		while(low<=high) {
			int partitionSize=(high-low)/3;
			int mid1=low+partitionSize;
			int mid2=high-partitionSize;
			if(target==a[mid2])
				return mid2;
			if(target==a[mid1])
				return mid1;
			if(target>a[mid2])
				low=mid2+1;
			if(target<a[mid1])
				high=mid1-1;
			if(target > a[mid1] && target< a[mid2]) {
				low=mid1+1;
				high=mid2-1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {10,20,40,50,70,80};             //only works on sorted array.
		System.out.println(search(a, 80));
	}

}
