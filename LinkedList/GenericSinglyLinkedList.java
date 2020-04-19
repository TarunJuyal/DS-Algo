package LinkedList;

import java.util.Scanner;

class Node<T>{
	T data;
	Node<T> next;
	Node(T data){
		this.data=data;
	}
	//@Override
	//public String toString() {
		//return "Node"+data+"Ref"+next;
	//}
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
				previous.next = temp.next;
			}
			previous=temp;
			temp=temp.next;
		}
	}
	
}
public class GenericSinglyLinkedList {
	static Scanner s =new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListOperations<String> ll=new LinkedListOperations<>();
		Node<String> node = new Node<String>("amit");
		ll.insertAtEnd(node);
		ll.insertAtEnd(new Node<String>("ram"));
		ll.insertAtEnd(new Node<String>("shyam"));
		ll.insertAtEnd(new Node<String>("sohan"));
		ll.insertAtBeginning(new Node<String>("tim"));
		int pos = 2;
		ll.insertAtPosition(new Node<String>("rim"), pos -1);
		ll.print();
		System.out.println("********************************");
		ll.delete("shyam");
		ll.print();
		//		int choice,pos;
//		do {
//			System.out.println("Enter data of node: ");
//			Node<String> node = new Node<String>(s.next());
//			System.out.println("Where do u want to enter data (beginning:1/position:2/end:3): ");
//			choice=s.nextInt();
//			switch(choice) {
//			case 1:ll.insertAtBeginning(node);
//			       break;
//			case 2:System.out.println("Enter position: ");
//			       pos=s.nextInt();
//			       ll.insertAtPosition(node, pos-1);
//			       break;
//			case 3:ll.insertAtEnd(node);
//			       break;
//			default:System.out.println("Invalid choice!!!");
//			}
//			System.out.println("Want to enter more (1 for yes / -1 for no): ");
//		    choice=s.nextInt();
//		}while(choice==1); 
//		ll.print();
//		do {
//			System.out.println("Enter data to be deleted: ");
//			ll.delete(s.next());
//			System.out.println("Want to delete more (1 for yes / -1 for no): ");
//		    choice=s.nextInt();
//		}while(choice==1); 
//		ll.print();
	}
	

}
