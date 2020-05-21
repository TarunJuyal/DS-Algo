package sortUsingRecursion;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,4,3,7,5,6,8,2};
		System.out.println("Given unsorted array ");
		for(int i=0;i<a.length;i++) {
            System.out.print(a[i]+" ");		
		}
		a=selectionSortTech(a,0,1,0);
		System.out.println();
		System.out.println("sorted array ");
		for(int i=0;i<a.length;i++) {
           System.out.print(a[i]+" ");		
		}
	}
	public static int[] selectionSortTech(int a[],int i, int j,int min){
		if(i==a.length) {
			return a;
		}
		if(j==a.length) {
			int temp=a[i];
			a[i]=a[min];
			a[min]=temp;
	   		 return selectionSortTech(a,i+1,i+2,i+1);
		}
		if(a[j]<a[min])
			min=j;
	   	return selectionSortTech(a, i, j+1,min);
	   	}

}
