package searchingAlgos;

//time complexity : root of n

public class JumpSearch {

	public static int search(int[] a, int target) {
		int blocksize=(int)Math.sqrt(target);
		int start=0,next=blocksize;
		while(start<a.length && a[next-1]<target) {
			start=next;
			next+=blocksize;
			if(next>a.length)
				next=a.length;
		}
		return  LinearSearch(a, target, start,next);
	}
	
	public static int LinearSearch( int[] a, int target,int start,int end) {
		for(int i=start;i<end;i++)
			if(a[i]==target)
				return i;
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {10,20,40,50,70,80};             //only works on sorted array.
		System.out.println(search(a, 80));
	}

}
