package StackAndQueue;

import java.util.Stack;

public class NextGreaterElement {
	static Stack<Integer> stack =new Stack<>();
	static void printNextGreaterElement(int []a) {
		int i=0;
		stack.push(a[i]);
		for(i=1;i<a.length;i++) {
			while(!stack.isEmpty() && stack.peek()<a[i]) {
				System.out.println("Element "+stack.pop()+" --> NGE "+a[i]);
			}
			stack.push(a[i]);
			if(stack.peek()>a[i])
				stack.push(a[i]);
		}
		while(!stack.isEmpty()) {
			System.out.println("Element "+stack.pop()+" --> NGE -1");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {4,5,2,25};
		int arr[]= {11,13,21,3};
		printNextGreaterElement(a);
		System.out.println("***********************");
		printNextGreaterElement(arr);
	}

}
