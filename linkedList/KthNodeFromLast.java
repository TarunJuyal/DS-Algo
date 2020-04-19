package linkedList;

import java.util.Scanner;

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
	
}
public class GenericSinglyLinkedList {
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
		ll.findKthFromLast(4);
		ll.findKthFromLastAndDelete(3);
		ll.print();
	}
	

}
