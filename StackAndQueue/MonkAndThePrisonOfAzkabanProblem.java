package StackAndQueue;

/*The problem is given an array A having N integers, for each i(1≤i≤N), find x+y, where x is the largest number less than i such that A[x]>A[i] and y is the 
 * smallest number greater than i such that A[y]>A[i]. If there is no x<i such that A[x]>A[i], then take x=−1. Similarly, if there is no y>i such that A[y]>A[i], then 
 * take y=−1.
 */

import java.util.Arrays;
import java.util.Stack;

public class MonkAndThePrisonOfAzkabanProblem {
	static void solution(int[] arr) {
		Stack<Integer> stack=new Stack<>();
		int[] xOutput=new int[arr.length];
		Arrays.fill(xOutput, -1);
		for(int i=arr.length-1;i>=0;i--) {
			while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) {                                     //for nearest left greatest.
				xOutput[stack.peek()]=i+1;
				stack.pop();
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			stack.pop();
		}
		System.out.println("X array:");
		for (int i:xOutput) {
			System.out.print(i+" ");
		}
		System.out.println();
		Stack<Integer> stack2=new Stack<>();
		int[] yOutput=new int[arr.length];
		Arrays.fill(yOutput, -1);
		for(int i=0;i<arr.length;i++) {
			while(!stack2.isEmpty() && arr[stack2.peek()]<arr[i]) {                                     //for nearest right smallest.
				yOutput[stack2.peek()]=i+1;
				stack2.pop();
			}
			stack2.push(i);
		}
		while(!stack2.isEmpty()) {
			stack2.pop();
		}
		System.out.println("Y array:");
		for (int i:yOutput) {
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i=0;i<arr.length;i++) {
			System.out.print(xOutput[i]+yOutput[i]+" ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {5,4,1,3,2};
		solution(arr);
	}

}
