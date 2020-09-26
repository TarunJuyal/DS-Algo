package heap;

import java.util.Arrays;

public class HeapifyOperation {

	private static void swap(int first,int second,int[] a) {
		int temp=a[first];
		a[first]=a[second];
		a[second]=temp;
	}
	
	private static void heapify(int index,int[] a) {
		int largerIndex=index;
		int leftIndex=index*2+1;
		if(leftIndex<a.length && a[leftIndex]>a[largerIndex])
			largerIndex=leftIndex;
		int rightIndex=index*2+2;
		if(rightIndex<a.length && a[rightIndex]>a[largerIndex])
			largerIndex=rightIndex;
		if(index==largerIndex)
			return;
		swap(index, largerIndex, a);
		heapify(largerIndex, a);
	}
	
	//for optimisation heapify only half no need to heapify leaf nodes and start from backwards for fewer recursions.
	public static void heapify(int[] a) {
		for(int i=(a.length-2)/2;i>=0;i--) {
			heapify(i,a);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b[]= {5,3,8,4,1,2};
		heapify(b);
		System.out.println("Max heap from array: "+Arrays.toString(b));
	}

}
