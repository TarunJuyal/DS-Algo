package StackAndQueue;

//To make self generic stack with basic stack functions.

public class Stack<T> {

	private int size;
	private T arr[];
	private int top=-1;;
	
	@SuppressWarnings("unchecked")
	public Stack(int size) {
		this.size=size;
		arr=(T[]) new Object[size];
	}
	public boolean isEmpty() {
		if(top==-1)
			return true;
		return false;
	}
	public boolean isFull() {
		if(top==size-1)
			return true;
		return false;
	}
	public int size() {
		return top+1;
	}
	public void push(T value) {
		if(isFull())
			throw new RuntimeException("Stack Overflow!!!");
		top++;
		arr[top]=value;
	}
	public void pop() {
		if(isEmpty())
			throw new RuntimeException("Stack Underflow!!");
		--top;
	}
	public T peek() {
		if(isEmpty())
			throw new RuntimeException("Stack Underflow!!");
		return arr[top];
	}
	public void print() {
		for(int i=top;i>=0;i--) {
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> myStack=new Stack<>(5);
		myStack.push("ram");
		myStack.push("shyam");
		myStack.push("tim");
		System.out.println(myStack.peek());
		myStack.pop();  
		myStack.push("Bharat");
		myStack.print();
		myStack.pop();
		myStack.pop();
		myStack.print();
		}

}
