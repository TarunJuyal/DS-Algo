package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

	public static void sort(int a[],int numberOfBuckets) {
		int i=0;
		for(List<Integer> bucket : createBuckets(a,numberOfBuckets)) {
			Collections.sort(bucket);
			for(int item:bucket)
				a[i++]=item;
		}
	}
	private static List<List<Integer>> createBuckets(int[] a,int numberOfBuckets){
		List<List<Integer>> buckets=new ArrayList<>();
		for(int i=0;i<numberOfBuckets;i++)
			buckets.add(new ArrayList<>());
		for(int item:a)
			buckets.get(item/numberOfBuckets).add(item);
		return buckets;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {7,1,5,3,2};
		sort(a,3);
		System.out.println("Sorted array: ");
		for(int i:a)
			System.out.print(i+" ");
	}

}
