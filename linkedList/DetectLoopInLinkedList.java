package linkedList;

class Node<T>{
	T data;
	Node<T> next;
	Node(T data){
		this.data=data;
	}
}
class LinkedListOperations<T>{
	Node<T> start;
	void insertAtBeginning(Node<T> node) {
		if(start==null) {
			start=node;
			return;
		}
		node.next=start;
		start=node;
	}
	void insertAtEnd(Node<T> node) {
		if(start==null) {
			start=node;
			return;
		}
		Node<T> temp=start;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=node;
	}
	void insertAtPosition(Node<T> node,int position) {
		if(start==null) {
			start=node;
			return;
		}
		if(position==0) {
			node.next = start;
			start = node;
			return ;
		}
		if(position>0) {
			Node<T> temp = start;
			int i = 1;
			while(i<position) {
				temp = temp.next;
				i++;
			}
			node.next = temp.next;
			temp.next  = node;
		}
	}
	//Floyd Cycle Detection Algo or Hare and tortoise
	void detectLoop() {
		Node<T> slow;
		Node<T> fast;
		slow=fast=start;
		boolean flag=false;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				System.out.println("Loop in LinkedList detected");
				flag=true;
				break;
			}
		}
		if(!flag)
			System.out.println("No loop in LinkedList");
	}
}
public class DetectLoopInLinkedList {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListOperations<String> ll=new LinkedListOperations<>();
		Node<String> node = new Node<String>("jack");
		ll.insertAtEnd(node);
		ll.insertAtEnd(new Node<String>("john"));
		ll.insertAtEnd(new Node<String>("paul"));
		ll.insertAtEnd(new Node<String>("kim"));
		ll.insertAtBeginning(new Node<String>("timothy"));
		int pos = 2;
		ll.insertAtPosition(new Node<String>("howard"), pos -1);
		ll.start.next.next.next.next.next.next=ll.start;   //to check loop
		ll.detectLoop();
	}
	

}
