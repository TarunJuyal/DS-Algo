package StackAndQueue;

import java.util.Stack;

public class ReverseStack {
	static Stack<Integer> stack=new Stack<>();
	static void insertInReverse(int current) {
		if(stack.empty())
			stack.push(current);
		else {
			int temp=stack.peek();
			stack.pop();
			insertInReverse(current);
			stack.push(temp);
		}
	}
	static void reverse() {
		if(stack.size()>0) {
			int current=stack.peek();
			stack.pop();
			reverse();
			insertInReverse(current);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println("Input stack: ");
		System.out.println(stack);
		reverse();
		System.out.println("Reversed stack: ");
		System.out.println(stack);
	}

}
