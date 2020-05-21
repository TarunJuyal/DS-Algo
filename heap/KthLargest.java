package heap;

import java.util.PriorityQueue;

public class KthLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> heap=new PriorityQueue<>((first,second)-> second-first);
		int a[]= {13,4,7,5,9,8};
		int k = 3;
		for(int i:a) {
			heap.add(i);
			if(heap.size()>a.length-k+1) {
				heap.poll();
			}
		}
		System.out.println(k+"th largest from end is: "+heap.peek());
	}

}
