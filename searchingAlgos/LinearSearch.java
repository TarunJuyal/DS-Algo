package searchingAlgos;

public class LinearSearch {

	public static int search( int[] a, int target) {
		for(int i=0;i<a.length;i++)
			if(a[i]==target)
				return i;
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {7,1,3,6,5};
		System.out.println(search(a, 6));
	}

}
