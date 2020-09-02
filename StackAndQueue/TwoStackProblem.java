package StackAndQueue;

import java.util.Arrays;
import java.util.Collections;

class TwoStack{
	private int top1,top2;
	private int[] items;
	
	public TwoStack(int length) {
		items=new int[length];
		top1=-1;
		top2=length;
	}
	
	//For Stack 1
	
	public int size1() {
		return top1+1;
	}
	
	public boolean isEmpty1() {
		return size1()==0;
	}

	
	public void push1(int item) {
		if(top1==top2-1) {
			throw new RuntimeException("Stack 1 Overflow");
		}
		top1++;
		items[top1]=item;
	}
	
	public int peek1() {
		if(isEmpty1())
			throw new RuntimeException("Stack 2 Underflow");
		return items[top1];
	}
	
	public int pop1() {
		if(isEmpty1())
			throw new RuntimeException("Stack 2 Underflow");
		int topMost=items[top1];
		top1--;
		return topMost; 
	}
	
	public void print1() {
		System.out.println("Stack 1:");
		System.out.print("[");
		for(int i=0;i<=top1;i++) {
			System.out.print(items[i]+", ");
		}
		System.out.println("]");
	}
	
	//For Stack 2
	
	public int size2() {
		return items.length-top2;
	}
	
	public boolean isEmpty2() {
		return size2()==items.length;
	}

	
	public void push2(int item) {
		if(top1==top2-1) {
			throw new RuntimeException("Stack 2 Overflow");
		}
		top2--;
		items[top2]=item;
	}
	
	public int peek2() {
		if(isEmpty2())
			throw new RuntimeException("Stack 2 Underflow");
		return items[top2];
	}
	
	public int pop2() {
		if(isEmpty2())
			throw new RuntimeException("Stack 2 Underflow");
		int topMost=items[top2];
		top2++;
		return topMost; 
	}
	
	public void print2() {
		System.out.println("Stack 2:");
		System.out.print("[");
		for(int i=items.length-1;i>=top2;i--) {
			System.out.print(items[i]+", ");
		}
		System.out.println("]");
	}

}

public class TwoStackProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoStack stack=new TwoStack(5);
		stack.push1(1);
		stack.push1(2);
		stack.push2(5);
		stack.push2(4);
		stack.push2(3);
		stack.print1();
		stack.print2();
		System.out.println(stack.pop1());
		System.out.println(stack.pop2());
		System.out.println(stack.peek1());
		System.out.println(stack.peek2());
		System.out.println(stack.size1());
		System.out.println(stack.size2());
		System.out.println(stack.isEmpty1());
		System.out.println(stack.isEmpty2());
	}

}
