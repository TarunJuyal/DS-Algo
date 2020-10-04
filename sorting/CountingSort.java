package sorting;

//simply count no of occurence of a number in array and then refill the array. extra space : O(max element)  time: O(n)

public class CountingSort {
	
	public static void sort(int a[],int max) {
		int counts[]=new int[max+1];
		for(int i: a)
			counts[i]++;
		int k=0;
		for(int i=0;i<counts.length;i++) {
			for(int j=0;j<counts[i];j++)
				a[k++]=i;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {7,3,5,2,3,1,5,8};
		sort(a,8);
		System.out.println("Sorted array: ");
		for(int i:a)
			System.out.print(i+" ");
	}

}
