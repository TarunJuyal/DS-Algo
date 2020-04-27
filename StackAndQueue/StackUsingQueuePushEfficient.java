package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueuePushEfficient<T> {
	int size=0;
	Queue<T> q1=new LinkedList<>();
	Queue<T> q2=new LinkedList<>();
	public StackUsingQueuePushEfficient() {
		this.size=0;
	}
	void push(T data) {
		q1.add(data);
		size++;
	}
	void pop(){
		if(q1.isEmpty())
			return;
		while(q1.size()!=1) {
			q2.add(q1.peek());
			q1.remove();
		}
		q1.remove();
		size--;
		Queue<T> q=q1;
		q1=q2;
		q2=q;
	}
	T peek() {
		if(q1.isEmpty())
			return null;
		while(q1.size()!=1) {
			q2.add(q1.peek());
			q1.remove();
		}
		T temp=q1.peek();
		q1.remove();
		q2.add(temp);
		Queue<T> q=q1;
		q1=q2;
		q2=q;
		return temp;
	}
	void print() {
		System.out.println("Current stack is"+q1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingQueuePushEfficient<Integer> stack=new StackUsingQueuePushEfficient<>();
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
