package linkedList;

import java.util.Arrays;
import java.util.NoSuchElementException;

import javax.management.RuntimeErrorException;

class LinkedList{
	 private  class SingleNode{
			public SingleNode(int item) {
			this.value=item;
		}
			private int value;
			private SingleNode next;
		}
	 private SingleNode first;
	 private SingleNode last;
	 private int size;
	 
	 private boolean isEmpty() {
		 return first==null;
	 }
	 
	 private SingleNode getPrevious(SingleNode node) {
		 SingleNode temp=first;
		 while(temp.next!=null) {
			 if(temp.next==node)
				 return temp;
			 temp=temp.next;
		 }
		 return null;
	 }
	 
	 public void addFirst(int item) {
		 SingleNode node=new SingleNode(item);
		 if(isEmpty()) {
			 first=last=node;
		 }else {
		 node.next=first;
		 first=node;
		 }
		 size++;
	 }
	 
	 public void addLast(int item) {
		 SingleNode node=new SingleNode(item);
		 if(isEmpty()) {
			 first=last=node;
		 }else {
		 last.next=node;
		 last=node;
		 }
		 size++;
	 }
	 
	 public int indexOf(int item) {
		 if(isEmpty())
			 return -1;
		 int index=0;
		 SingleNode temp=first;
		 while(temp!=null) {
			 if(temp.value==item)
				 return index;
			 temp=temp.next;
			 index++;
		 }
		 return -1;
	 }
	 
	 public boolean contains(int item) {
		 return indexOf(item)!=-1;
	 }
	 
	 public void removeFirst() {
		 if(isEmpty())
			 throw new NoSuchElementException();
		 if(first==last) {
			 first=last=null;
		 }else {
		 first=first.next;
		 }
		 size--;
	 }

	public void removeLast() {
		if(isEmpty())
			 throw new NoSuchElementException();
		 if(first==last) {
			 first=last=null;
		 }else {
		 SingleNode prev=getPrevious(last);
		 last=prev;;
		 last.next=null;
		 }
		 size--;
	}
	
	public int size() {
		return size;
	}
	
	public int[] toArray() {
		int array[]=new int[size];
		SingleNode temp=first;
		int index=0;
		while(temp!=null) {
			array[index]=temp.value;
			index++;
			temp=temp.next;
		}
		return array;
	}
	
	public void reverse() {
		if(isEmpty())
			return;
		SingleNode previous=null;
		SingleNode current=first;
		SingleNode next=first.next;
		last=current;
		while(current.next!=null) {
			current.next=previous;
			previous=current;
			current=next;
			next=next.next;
		}
		current.next=previous;
		first=current;
	}
	
	public int getKthFromTheEnd(int k) {
		if(isEmpty())
			throw new RuntimeException("No element in list");
		if(k<=0||k>size)
			throw new IllegalArgumentException();
		SingleNode p1=first,p2=first;
		for(int i=0;i<k;i++)
			p2=p2.next;
		while(p2!=null) {
			p1=p1.next;
			p2=p2.next;
		}
		return p1.value;
	}
	
	public void createLoop() {
		if(isEmpty())
			throw new RuntimeException("Empty linked list");
		last.next=first;
	}
	
	public boolean hasLoop() {
		SingleNode slow=first,fast=first;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
				return true;
		}
		return false;
	}
	
	public void printMiddle() {
		if(isEmpty())
			throw new RuntimeException("Empty linked list");
		System.out.println("Middle Elements are:");
		SingleNode a=first,b=first;
		while(b!=last && b.next!=last) {
			b=b.next.next;
			a=a.next;
		}
		if(b==last)
			System.out.println(a.value);
		else
			System.out.println(a.value+", "+a.next.value);
	}
	 
 }
 
public class SinglyLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list =new LinkedList();
		list.addLast(30);
		list.addLast(40);
		list.addFirst(20);
		list.addFirst(10);
//		list.createLoop();
		System.out.println(list.hasLoop());
		list.printMiddle();
		System.out.println(Arrays.toString(list.toArray()));
		list.reverse();
		System.out.println(Arrays.toString(list.toArray()));
		System.out.println(list.indexOf(20));
		System.out.println(list.contains(60));
		list.removeFirst();
		list.printMiddle();
		list.removeLast();
		System.out.println(list.size());
		System.out.println(list.getKthFromTheEnd(2));
	}

}
