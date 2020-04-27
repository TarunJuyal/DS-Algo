package StackAndQueue;

class StackNode<T>{
	T data;
	StackNode<T> next;
	public StackNode(T data) {
		this.data=data;
	}
}
class StackOperations<T>{
	static int size;
	StackNode<T> top;
	public StackOperations() {
		this.top=null;
	}
	void push(StackNode<T> node) {
		if(top==null) {
		top=node;
		return;
		}
		node.next=top;
		top=node;
		size++;
	}
	T pop() {
		if(top==null) {
			throw new RuntimeException("Stack Empty!!");
		}
		T temp=top.data;
		top=top.next;
		size--;
		return temp;
	}
	T peek() {
		if(top==null) {
			throw new RuntimeException("Stack Empty!!");
		}
		return top.data;
	}
	void print() {
		if(top==null)
			throw new RuntimeException("Stack Empty!!");
		StackNode<T> temp=top;
		while(temp!=null) {
			System.out.println(temp.data+" ");
			temp=temp.next;
		}
	}
}
public class StackUsingLinkList{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackOperations<Integer> stack=new StackOperations<>();
		stack.push(new StackNode<Integer>(10));
		stack.push(new StackNode<Integer>(20));
		stack.push(new StackNode<Integer>(30));
		stack.push(new StackNode<Integer>(40));
		stack.print();
		stack.pop();
		System.out.println("top element "+stack.peek());
		stack.pop();
		stack.print();
	}

} 
