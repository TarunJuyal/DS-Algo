package StackAndQueue;

import java.util.Stack;

public class QueueUsingStackEnqueueEfficient<T> {
	Stack<T> stack=new Stack<>();
	int elementCount=0;
	void enqueue(T data) {
		stack.push(data);
	}
	void dequeue() {
		if(stack.size()==1) {
			stack.pop();
			return;
		}
		else if(stack.size()>1) {
			T current=stack.pop();
			dequeue();
			stack.push(current);
		}
	}
	int getSize() {
		return stack.size();
	}
	void print() {
		System.out.println(" Current queue is"+stack);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingStackEnqueueEfficient<Integer> q=new QueueUsingStackEnqueueEfficient<>();
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
