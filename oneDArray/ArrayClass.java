package oneDArray;

class Array<T>{
	private T[] items;
	private int size;
	
	@SuppressWarnings("unchecked")
	public Array(int length) {
		items=(T[]) new Object[length];
	}
	
	public void insert(T item) {
		//If array gets full,resize it.
		if(items.length==size) {
			@SuppressWarnings("unchecked")
			T[] newArray=(T[]) new Object[2*size];
			for(int i=0;i<size;i++) {
				newArray[i]=items[i];
			}
			items=newArray;	
		}
		//Addition at end
		items[size]=item;
		size++;
	}
	
	public void removeAt(int index) {
		if(index<0||index>=size) {
			throw new IllegalArgumentException();
		}
		for(int i=index;i<size;i++) {
			items[i]=items[i+1];
		}
		size--;
	}
	
	public int indexOf(T item) {
		for(int i=0;i<size;i++) {
			if(items[i]==item)
				return i;
		}
		return -1;
	}
	
	public void print() {
		for(int i=0;i<size;i++) {
			System.out.println(items[i]);
		}
	}
}

public class ArrayClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array<Integer> numbers=new Array(3);
		numbers.insert(10);
		numbers.insert(20);
		numbers.insert(30);
		numbers.insert(40);
		numbers.removeAt(2);
		numbers.print();
		System.out.println("index: "+numbers.indexOf(30));
	}

}
