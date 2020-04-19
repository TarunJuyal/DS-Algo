package linkedList;

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
	void findKthFromLast(int k) {
		Node<T> p=start;
		Node<T> q=start.next;
		for(int i=1;i<=k;i++) {
			q=q.next;
		}
		while(q!=null) {
			p=p.next;
			q=q.next;
		}
		System.out.println(k+"th node from last is: "+p.next.data);
	}
	void findKthFromLastAndDelete(int k) {
		Node<T> p=start;
		Node<T> q=start.next;
		for(int i=1;i<=k;i++) {
			q=q.next;
		}
		while(q!=null) {
			p=p.next;
			q=q.next;
		}
		System.out.println(k+"th node deleted from last is: "+p.next.data);
		p.next=p.next.next;
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
	static Scanner s =new Scanner(System.in);
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
		ll.print();
		System.out.println("********************************");
		//ll.delete("shyam");
		//ll.print();
		//ll.findKthFromLast(4);
		//ll.findKthFromLastAndDelete(3);
		//ll.print();
		ll.start.next.next.next.next.next.next=ll.start;
		ll.detectLoop();
		
		
		
		
		
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
