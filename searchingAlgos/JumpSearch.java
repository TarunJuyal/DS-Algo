package searchingAlgos;

public class JumpSearch {

	public static int search(int[] a, int target) {
		int blocksize=(int)Math.sqrt(a.length);
		int start=0,next=blocksize;
		while(start<a.length && a[next-1]<target) {
			start=next;
			next+=blocksize;
			if(next>a.length)
				next=a.length;
		}
		return  LinearSearch(a, target, start,next);
	}
	
	private static int LinearSearch( int[] a, int target,int start,int end) {
		for(int i=start;i<end;i++)
			if(a[i]==target)
				return i;
		return -1;
	}
}
