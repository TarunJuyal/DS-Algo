package arrangingZerosandOnes;

//two pointer approach

public class approach2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int arr[]= {1,0,0,1,1,0,0};
     System.out.print("Given unsorted array ");
     for(int ele:arr) {
		System.out.print(ele+" ");
		}
     System.out.println();
     arr=sort(arr);
     System.out.print("Sorted array ");
     for(int ele:arr) {
 		System.out.print(ele+" ");
 		}
	}
	public static int[] sort(int a[]) {
		int i=0,j=a.length-1;
		while(i!=j) {
			if(a[i]>a[j]) {
				int t=a[i];
				a[i]=a[j];
				a[j]=t;
			    j--;
			}
			i++;
		}
		return a;
	}

}
