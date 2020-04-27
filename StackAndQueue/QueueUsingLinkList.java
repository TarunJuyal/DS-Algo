package StackAndQueue;
class QNode<T>{
	T data;
	QNode<T> next;
	QNode(T data){
		this.data=data;
}
}
class QOperations<T>{
	static int size=0;
	QNode<T> front,rear;
	void enqueue(QNode<T> node) {
		if(	rear==null) {
			front=rear=node;
			return;
		}
		rear.next=node;
		rear=node;
	}
	T dequeue() {
		if(front==null) 
			throw new RuntimeException("queue empty");
		T temp=front.data;
		front=front.next;
		if(front==null)
			rear=null;
		return temp;
	}
	void print() {
		QNode<T> temp=front;
		while(temp!=null) {
			System.out.println(temp.data+" ");
			temp=temp.next;
		}
	}
}
public class QueueUsingLinkList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QOperations<Integer> q=new QOperations<>();
		q.enqueue(new QNode<Integer>(10));
		q.enqueue(new QNode<Integer>(20));
		q.enqueue(new QNode<Integer>(30));
		q.enqueue(new QNode<Integer>(40));
		q.print();
		q.dequeue();
		q.dequeue();
		q.print();
	}

}
