package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueuePopEfficient<T> {
	int size=0;
	Queue<T> q1=new LinkedList<>();
	Queue<T> q2=new LinkedList<>();
	public StackUsingQueuePopEfficient() {
		this.size=0;
	}
	void push(T data) {
		if(q1.isEmpty()) {
			q1.add(data);
			size++;
			return;
		}
		while(q1.size()!=0) {
			q2.add(q1.peek());
			q1.remove();
		}
		q1.add(data);
		while(q2.size()!=0) {
			q1.add(q2.peek());
			q2.remove();
		}
		size++;
	}
	void pop(){
		q1.remove();
		size--;
	}
	T peek() {
		if(q1.isEmpty())
			return null;
		else
			return q1.peek();
	}
	void print() {
		System.out.println("Current stack is"+q1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingQueuePopEfficient<Integer> stack=new StackUsingQueuePopEfficient<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.print();
		stack.pop();
		stack.pop();
		stack.print();
		System.out.println("top element is: "+stack.peek());
	}

}
