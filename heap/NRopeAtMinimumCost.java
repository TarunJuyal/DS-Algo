package heap;

import java.util.PriorityQueue;

public class NRopeAtMinimumCost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {5,2,3,9,7,8,6};
		PriorityQueue<Integer> heap=new PriorityQueue<>((first,second)->first-second);
		for(int i:a) {
			heap.add(i);
		}
		int totalSum=0;
		while(heap.size()!=1) {
			int currentSum=heap.poll()+heap.poll();
			heap.add(currentSum);
			totalSum+=currentSum;
		}
		System.out.println("Minimum cost is:"+totalSum);
	}

}
