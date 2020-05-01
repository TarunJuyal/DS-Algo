package StackAndQueue;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {2,1,6,5,2,3};
		Stack<Integer> stack=new Stack<>();
		stack.push(-1);                                                          //end of stack
		int maxArea=0;
		for(int i=0;i<a.length;i++) {
			while(stack.peek()!=-1 && a[stack.peek()]>=a[i]) {
				int rightMost=i;
				int top=stack.pop();
				int leftMost=stack.peek();
				maxArea=Math.max(maxArea, a[top]*(rightMost-leftMost-1));
			}
			stack.push(i);
		}
		while(stack.peek()!=-1) {
			maxArea=Math.max(maxArea, a[stack.pop()]*(a.length-stack.peek()));
		}
		System.out.println(maxArea);
	}

}
