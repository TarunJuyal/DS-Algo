package oneDArray;

class Array{
	private int[] items;
	private int size;
	
	public Array(int length) {
		items=new int[length];
	}
	
	public void insert(int item) {
		//If array gets full,resize it.
		if(items.length==size) {
			int[] newArray=new int[2*size];
			for(int i=0;i<size;i++) {
				newArray[i]=items[i];
			}
			items=newArray;	
		}
		//Addition at end
		items[size]=item;
		size++;
	}
	
	public void insertAt(int item,int index) {
		//Insert at a position already present.
		if(index<0||index>=size) {
			throw new IllegalArgumentException();
		}
		//If array gets full,resize it.
		if(items.length==size) {
			int[] newArray=new int[2*size];
			for(int i=0;i<size;i++) {
				newArray[i]=items[i];
			}
			items=newArray;	
			}
		if(index==size) {
			items[index]=item;
		}else {
			for(int i=size;i>index;i--) {
				items[i]=items[i-1];
			}
			items[index]=item;
		}
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
	
	public int indexOf(int item) {
		for(int i=0;i<size;i++) {
			if(items[i]==item)
				return i;
		}
		return -1;
	}
	
	public int max() {
		int max=items[0];
		for(int i=1;i<size;i++) {
			if(items[i]>max)
				max=items[i];
		}
		return max;
	}
	
	public void reverse() {
		for(int i=0,j=size-1;i<=j;i++,j--) {
			int temp=items[i];
			items[i]=items[j];
			items[j]=temp;
		}
	}
	
	public void intersect(int a[]) {
		boolean flag=false;
		System.out.println("Intersections");
		for(int i=0;i<size;i++) {
			for(int j:a) {
				if(items[i]==j) {
					flag=true;
					System.out.print(items[i]+" ");
				}
			}
		}
		if(!flag)
			System.out.println("No intersections");
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
		Array numbers=new Array(3);
		numbers.insert(10);
		numbers.insert(20);
		numbers.insert(30);
		numbers.insert(40);
		numbers.removeAt(2);
		numbers.print();
		System.out.println("index: "+numbers.indexOf(30));
		System.out.println("max: "+numbers.max());
		numbers.reverse();
		numbers.insertAt(50, 1);
		numbers.print();
		numbers.intersect(new int[]{50,90,80,40});
	}

}
