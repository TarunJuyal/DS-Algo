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
				previous.next = temp.next;
			}
			previous=temp;
			temp=temp.next;
		}
	}
	void intersectionBtwTwoLinkedList(Node<T> l1,Node<T> l2) {
		Node<T> start=l1;
		Node<T> start2=l2;
		int difference=0;
		if(l1==null||l2==null)
			return;
		if(l1.next==null||l2.next==null)
			return;
		int n=getSize(start);
		int m=getSize(start2);
		if(n<m) {
			difference=m-n;
			start=l2;
			start2=l1;
		}else {
			difference=n-m;
			start=l1;
			start2=l2;
		}
		Node<T> temp=start;
		Node<T> temp2=start2;		
		for(int i=1;i<=difference;i++)
			temp=temp.next;
		while(temp!=null || temp2!=null) {
			if(temp==temp2) {
				System.out.println("Intersection point value "+temp.data);
				return;
			}
			temp=temp.next;
			temp2=temp2.next;
		}
	}
}
public class GenericLinkedList {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListOperations<String> ll=new LinkedListOperations<>();
		LinkedListOperations<String> ll2=new LinkedListOperations<>();
		Node<String> node = new Node<String>("jack");
		ll.insertAtEnd(node);
		ll.insertAtEnd(new Node<String>("john"));
		ll.insertAtEnd(new Node<String>("paul"));
		ll.insertAtEnd(new Node<String>("kim"));
		ll.insertAtBeginning(new Node<String>("timothy"));
		int pos = 2;
		ll.insertAtPosition(new Node<String>("howard"), pos -1);
		System.out.println("LinkList 1:");
		ll.print();
		System.out.println("********************************");
		System.out.println("Linklist 2: ");
		ll2.insertAtEnd(new Node<String>("jill"));
		ll2.insertAtEnd(new Node<String>("jacob"));
		ll2.print();
		ll2.start.next.next=ll.start.next.next.next;          //to check intersection 
		ll.intersectionBtwTwoLinkedList(ll.start, ll2.start);
		
	}
}
