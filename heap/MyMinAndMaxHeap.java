package heap;

//upHeapify while add and downHeapify while delete.

import java.util.ArrayList;

class MaxHeap{
	ArrayList<Integer> data=new ArrayList<>();
	void add(int value) {
		data.add(value);
		upHeapify(data.size()-1);
	}
	void upHeapify(int childIndex) {
		int parentIndex=(childIndex-1)/2;
		if(data.get(childIndex)>data.get(parentIndex)) {
			swap(childIndex,parentIndex);
			upHeapify(parentIndex);
		}
	}
	void swap(int childindex,int parentIndex) {
		int childValue=data.get(childindex);
		int parentValue=data.get(parentIndex);
		data.set(childindex, parentValue);
		data.set(parentIndex, childValue);
	}
	void print() {
		for(int i:data) {
			System.out.print(i+" ");
		}
	}
	void downHeapify(int parentIndex) {
		int leftChildIndex=2*parentIndex+1;
		int rightChildIndex=2*parentIndex+2;	
		if( leftChildIndex<data.size() && data.get(leftChildIndex)>data.get(parentIndex)) {
			swap(leftChildIndex, parentIndex);
			downHeapify(leftChildIndex);
		}
		if(rightChildIndex<data.size() && data.get(rightChildIndex)>data.get(parentIndex)) {
			swap(rightChildIndex, parentIndex);
			downHeapify(rightChildIndex);
		}
	}
	int delete() {
		swap(0,data.size()-1);
		int deleted=data.remove(data.size()-1);
		downHeapify(0);
		return deleted;
	}
	
}
 class MinHeap{
	ArrayList<Integer> data=new ArrayList<>();
	void add(int value) {
		data.add(value);
		upHeapify(data.size()-1);
	}
	void upHeapify(int childIndex) {
		int parentIndex=(childIndex-1)/2;
		if(data.get(childIndex)<data.get(parentIndex)) {
			swap(childIndex,parentIndex);
			upHeapify(parentIndex);
		}
	}
	void swap(int childindex,int parentIndex) {
		int childValue=data.get(childindex);
		int parentValue=data.get(parentIndex);
		data.set(childindex, parentValue);
		data.set(parentIndex, childValue);
	}
	void print() {
		for(int i:data) {
			System.out.print(i+" ");
		}
	}
	void downHeapify(int parentIndex) {
		int leftChildIndex=2*parentIndex+1;
		int rightChildIndex=2*parentIndex+2;	
		if( leftChildIndex<data.size() && data.get(leftChildIndex)<data.get(parentIndex)) {
			swap(leftChildIndex, parentIndex);
			downHeapify(leftChildIndex);
		}
		if(rightChildIndex<data.size() && data.get(rightChildIndex)<data.get(parentIndex)) {
			swap(rightChildIndex, parentIndex);
			downHeapify(rightChildIndex);
		}
	}
	int delete() {
		swap(0,data.size()-1);
		int deleted=data.remove(data.size()-1);
		downHeapify(0);
		return deleted;
	}
}

public class MyMinAndMaxHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinHeap heap = new MinHeap();
		heap.add(10);
		heap.add(20);
		heap.add(30);
		heap.add(5);
		heap.add(15);
		heap.add(25);
		System.out.println("Min Heap:  ");
		heap.print();
		System.out.println("after delete: "+heap.delete());
		heap.print();
		System.out.println();
		MaxHeap heap2=new MaxHeap();
		heap2.add(3);
		heap2.add(1);
		heap2.add(6);
		heap2.add(5);
		heap2.add(2);
		heap2.add(4);
		System.out.println("Max Heap:  ");
		heap2.print();
		System.out.println("After delete: "+heap2.delete());
		System.out.println("After delete: "+heap2.delete());
		heap2.print();
	}

}
