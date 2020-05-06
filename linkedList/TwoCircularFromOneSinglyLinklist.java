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
	void print() {
		Node<T> temp  = start;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	void delete(T data) {
		Node<T> temp=start;
		if(start==null) {
			System.out.println("Linked List is Empty!!");
			return;
		}
		if(start.data==data) {
			start=start.next;
			return;
		}
		Node<T> previous=start;
		while(temp.next!=null) {
			if(temp.data==data) {	
				previous.next=temp.next;
			}
			previous=temp;
			temp=temp.next;
		}
	}
	int getSize(Node<T> start) {
		int size=0;
		Node<T> temp=start;
		while(temp!=null) {
			temp=temp.next;
			size++;
		}
		return size;
	}
	Node<T> getNodeAtIndex(int index){
		if(getSize(start)==0)
			throw new RuntimeException("Linked List is blank");
		if(index<0 ||index>=getSize(start))
			throw new RuntimeException("Invalid index");
		Node<T> temp=start;
		for(int i=1;i<=index;i++) {
			temp=temp.next;
		}
		return temp;
	}
	Node<T> splitInTwoCircular() {
		int mid=(getSize(start)-1)/2;
		Node<T> node =getNodeAtIndex(mid);
		Node<T>start2=node.next;
		Node<T> temp=start2;
		node.next=start;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=start2;
		return start2;
	}
	void printCircular(Node<T> start) {
		Node<T> temp  = start;
		do{
			System.out.println(temp.data);
			temp = temp.next;
		}while(temp!=start);
	}
}
public class GenericLinkedList {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListOperations<String> ll=new LinkedListOperations<>();
		Node<String> node = new Node<String>("jack");
		ll.insertAtEnd(node);
		ll.insertAtEnd(new Node<String>("john"));
		ll.insertAtEnd(new Node<String>("paul"));
		ll.insertAtEnd(new Node<String>("kim"));
		ll.insertAtBeginning(new Node<String>("timothy"));
		Node<String> newList=ll.splitInTwoCircular();
		System.out.println("first Circular: ");
		ll.printCircular(ll.start);
		System.out.println("second Circular: ");
		ll.printCircular(newList);
		
	}
}
