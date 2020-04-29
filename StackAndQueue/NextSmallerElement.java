package StackAndQueue;

import java.util.Stack;

public class NextSmallerElement {
	static Stack<Integer> stack =new Stack<>();
	static void printNextSmallerElement(int []a) {
		int i=0;
		stack.push(a[i]);
		for(i=1;i<a.length;i++) {
			while(!stack.isEmpty() && stack.peek()>a[i]) {
				System.out.println("Element "+stack.pop()+" --> NGE "+a[i]);
			}
			stack.push(a[i]);
			if(stack.peek()<a[i])
				stack.push(a[i]);
		}
		while(!stack.isEmpty()) {
			System.out.println("Element "+stack.pop()+" --> NGE -1");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {4, 8, 5, 2, 25};
		printNextSmallerElement(a);
	}
}
