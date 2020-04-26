package sortUsingRecursion;

public class BubbleSort {

    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,4,3,7,5,6,8,2};
		System.out.println("Given unsorted array ");
		for(int i=0;i<a.length;i++) {
            System.out.print(a[i]+" ");		
		}
		a=bubbleSorttech(a,0,a.length-1);
		System.out.println();
		System.out.println("sorted array ");
		for(int i=0;i<a.length;i++) {
           System.out.print(a[i]+" ");		
		}
		}
    public static int[] bubbleSorttech(int a[],int first, int last) {
   	 if(last==0)
   		 return a;
   	 if(first==last) {
   		 return bubbleSorttech(a,0,last-1);
   	 }
   	 if(a[first]>a[first+1]) {
   		 int temp=a[first];
   		 a[first]=a[first+1];
   		 a[first+1]=temp;
   	 }
   	 return bubbleSorttech(a,first+1,last);
    }


}
