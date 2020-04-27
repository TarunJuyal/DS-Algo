package StackAndQueue;

public class QueueUsingArray<T> {
	private int size,front,rear;
	private T arr[];

	@SuppressWarnings("unchecked")
	QueueUsingArray(int len){
		this.size=0;
		this.front=this.rear=-1;
		arr= (T[]) new Object[len]; 
	}
	boolean isEmpty() {
		if(size==0)
			return true;
		return false;
	}
	boolean isFull() {
		if(size==arr.length)
			return true;
		return false;
	}
	void enqueue(T data) {
		if(isFull())
			throw new RuntimeException("Queue is full!!");
		if(size==0)
			front=0;
		rear++;
		size++;
		if(rear==arr.length)
			rear=0;
		arr[rear]=data;
	}
	T dequeue() {
		if(isEmpty())
			throw new RuntimeException("Queue is empty!!");
		T temp=arr[front];
		front++;
		if(front==arr.length)
			front=0;
		size--;
		if(size==0)
			front=rear=-1;
		return temp;
	}
	void print() {
		if(front==rear)
			System.out.println("Queue is empty");
		else if(front<rear) {
			for(int i=front;i<=rear;i++)
				System.out.print(arr[i]+" ");
		}
		else {
			for(int i=front;i<arr.length;i++)
				System.out.println(arr[i]+" ");
			for(int i=0;i<=rear;i++)
				System.out.println(arr[i]+" ");
		}
			
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingArray<Integer> q= new QueueUsingArray<>(5);
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.dequeue();
		q.dequeue();
		q.enqueue(60);
		q.enqueue(70);
		q.dequeue();
		q.enqueue(90);
		q.print();
	}

}
