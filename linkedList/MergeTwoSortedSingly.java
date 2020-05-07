package linkedList;

class NewNode{
	int data;
	NewNode next;
	NewNode(int data){
		this.data=data;
	}
}
class LinkedListFunctions{
	NewNode start;
	void insertAtBeginning(NewNode node) {
		if(start==null) {
			start=node;
			return;
		}
		node.next=start;
		start=node;
	}
	void insertAtEnd(NewNode node) {
		if(start==null) {
			start=node;
			return;
		}
		NewNode temp=start;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=node;
	}
	void insertAtPosition(NewNode node,int position) {
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
			NewNode temp = start;
			int i = 1;
			while(i<position) {
				temp = temp.next;
				i++;
			}
			node.next = temp.next;
			temp.next  = node;
		}
	}
	void print(NewNode start) {
		NewNode temp  = start;
		while(temp!=null) {
			System.out.print(temp.data+" --> ");
			temp = temp.next;
		}
		System.out.println();
	}
	void delete(int data) {
		NewNode temp=start;
		if(start==null) {
			System.out.println("Linked List is Empty!!");
			return;
		}
		if(start.data==data) {
			start=start.next;
			return;
		}
		NewNode previous=start;
		while(temp.next!=null) {
			if(temp.data==data) {	
				previous.next=temp.next;
			}
			previous=temp;
			temp=temp.next;
		}
	}
	NewNode mergeTwoSortedSinglyLinlklist(NewNode start2){
		NewNode mergeStart=null;
		NewNode temp=null;
		if(start==null)
			return start2;
		if(start2==null)
			return start; 
		if(start.data<start2.data) {
			temp=start;
			start=temp.next;
		}
		else {
			temp=start2;
			start2=temp.next;
		}
		mergeStart=temp;                                  //allocated head pointer of final merged linklist.
		while(start!=null && start2!=null) {
			if(start.data<start2.data) {
				temp.next=start;
				temp=start;
				start=temp.next;
			}
			else {
				temp.next=start2;
				temp=start2;
				start2=temp.next;
			}
		}
		if(start==null)
			temp.next=start2;
		if(start2==null)
			temp.next=start;
		return mergeStart;
	}
	NewNode mergeTwoSortedSinglyLinlklistUsingRecursion(NewNode start,NewNode start2) {
		if(start == null) 
			return start2; 
        if(start2 == null) 
        	return start; 
          
        if(start.data <= start2.data)  
        { 
            start.next = mergeTwoSortedSinglyLinlklistUsingRecursion(start.next, start2); 
            return start; 
        } 
        else 
        { 
            start2.next = mergeTwoSortedSinglyLinlklistUsingRecursion(start, start2.next); 
            return start2; 
        } 
	}
}

public class MergeTwoSortedSingly {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListFunctions l=new LinkedListFunctions();
		l.insertAtEnd(new NewNode(1));
		l.insertAtEnd(new NewNode(5));
		l.insertAtEnd(new NewNode(7));
		l.insertAtEnd(new NewNode(9));
		l.insertAtEnd(new NewNode(10));
		System.out.println("Linklist 1: ");
		l.print(l.start);
		LinkedListFunctions l2=new LinkedListFunctions();
		l2.insertAtEnd(new NewNode(2));
		l2.insertAtEnd(new NewNode(3));
		l2.insertAtEnd(new NewNode(4));
		l2.insertAtEnd(new NewNode(6));
		l2.insertAtEnd(new NewNode(8));
		System.out.println("Linklist 2:");
		l2.print(l2.start);
		System.out.println("Merged linklist is: ");
		l.print(l.mergeTwoSortedSinglyLinlklist(l2.start));
		//using recursion
//		System.out.println("Merged linklist using recursion is: ");
//		l.print(l.mergeTwoSortedSinglyLinlklistUsingRecursion(l.start,l2.start));
	}

}
