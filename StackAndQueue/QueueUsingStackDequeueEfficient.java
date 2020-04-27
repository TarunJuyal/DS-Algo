package StackAndQueue;

import java.util.Stack;

public class QueueUsingStackDequeueEfficient<T> {
	Stack<T> stack= new Stack<>();
	void dequeue() {
		stack.pop();
	}
	void enqueue(T data) {
		if(stack.size()==0) {
			stack.push(data);
			return;
		}
		else if(stack.size()>0) {
			T current=stack.pop();
			enqueue(data);
			stack.push(current);
		}
	}
	void print() {
		System.out.println(" Current queue is"+stack);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingStackDequeueEfficient<Integer> q=new QueueUsingStackDequeueEfficient<>();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.print();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.enqueue(50);
		q.print();
	}

}
