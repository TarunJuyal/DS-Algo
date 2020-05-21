package heap;

import java.util.PriorityQueue;

public class MinToMaxHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> heap=new PriorityQueue<>((first,second)->second-first);
		int a[]= {5,10,25,20,15,30};                        //given min heap
		for(int i:a) {
			heap.add(i);
		}
		System.out.println("Max Heap is: "+heap);
	}

}
