package sorting;

import java.util.Arrays;

//for only iterative and no recursion extra stack data structure needs to be used.

public class QuickSort {

	private static void swap(int a[],int first,int second) {
		int temp=a[first];
		a[first]=a[second];
		a[second]=temp;
	}
	
	public static void sort(int a[]) {
		sort(a,0,a.length-1);
	}
	private static void sort(int a[],int start,int end) {
		
		if(start>=end)
			return;
		
		int boundary=partition(a,start,end);
		
		sort(a, start, boundary-1);
		sort(a,boundary,end);
	}
	private static int partition(int a[],int start,int end) {
		int boundary=start-1,pivot=a[end];
		for(int i=start;i<=end;i++)
			if(a[i]<=pivot)
				swap(a, i, ++boundary);
		return boundary;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {7,3,1,5,2};
		sort(a);
		System.out.println("Sorted array: "+Arrays.toString(a));
	}

}
