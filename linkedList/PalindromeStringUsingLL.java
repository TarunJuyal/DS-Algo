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
	boolean checkIfPalindrome() {
		int left=0;
		int right=getSize(start)-1;
		while(left<right) {
			Node<T> leftNode=getNodeAtIndex(left);
			Node<T> rightNode=getNodeAtIndex(right);
			if(rightNode.data!=leftNode.data) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	void checkPalindrome() {
		if(checkIfPalindrome())
			System.out.println("String is palindrome");
		else 
			System.out.println("Not a palindrome");
	}
}
public class GenericLinkedList {
	public static void main(String[] args) {
		LinkedListOperations<Character> l3=new LinkedListOperations<>();
		String s="abcdcba";
		for(int i=0;i<s.length();i++)
			l3.insertAtEnd(new Node<Character>(s.charAt(i)));
		l3.checkPalindrome();
	}
}
