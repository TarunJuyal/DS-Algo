package heap;

import java.util.PriorityQueue;

public class KthLargest {

	private static PriorityQueue<Integer> heap=new PriorityQueue<>((first,second)-> second-first);
	public static int getKthLargest(int[] a,int k) {
		if(k<1||k>a.length)
			throw new IllegalStateException();
		for(int i:a) {
			heap.add(i);
			if(heap.size()>a.length-k+1) {
				heap.poll();
			}
		}
		return heap.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {13,4,7,5,9,8};
		System.out.println(getKthLargest(a, 3));
	}

}
