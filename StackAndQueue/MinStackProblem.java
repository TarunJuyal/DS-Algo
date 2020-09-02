package StackAndQueue;

import java.util.Arrays;


//The idea is to make it push,pop and minimum operation efficient the stack doesn't store real values
//while push if input less than minimum element than change minimum element to input and insert (2*input-minimum element) in stack.
//while pop if output less than minimum element than change minimum element to (2*minimum element-output) and perform pop in stack.

class MinStack{
	private int top=-1,minElement;
	private int[] items=new int[5];
	
	public int size() {
		return top+1;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}

	
	public void push(int item) {
		if(items.length==size()) {
			int[] newArray=new int[size()*2];
			for(int i=0;i<size();i++)
				newArray[i]=items[i];
			items=newArray;
		}
		if(isEmpty()) {
			minElement=item;
			top++;
			items[top]=item;
		}else if(item<minElement) {
			top++;
			items[top]=2*item-minElement;
			minElement=item;
		}else {
			top++;
			items[top]=item;
		}
		
	}
	
	public int peek() {
		if(isEmpty())
			throw new RuntimeException("Stack Underflow");
		return items[top];
	}
	
	public int min() {
		if(isEmpty())
			throw new RuntimeException("Stack Underflow");
		return minElement;
	}
	
	public int pop() {
		if(isEmpty())
			throw new RuntimeException("Stack Underflow");
		int topMost=items[top];
		if(topMost<minElement) {
			minElement=2*minElement-topMost;
			top--;
		}else
			top--;
		
		return topMost; 
	}
	
	@Override
	public String toString() {
		int[] content=Arrays.copyOfRange(items, 0, size());
		return Arrays.toString(content);
	}
	
}

public class MinStackProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack stack = new MinStack();
		stack.push(5);
		stack.push(2);
		stack.push(10);
		stack.push(1);
		System.out.println(stack);
		System.out.println("Min is: "+stack.min());
		stack.pop();
		System.out.println("Min is: "+stack.min());
	}

}
