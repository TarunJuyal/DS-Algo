package arrangingZerosandOnes;

public class approach1 {

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
		int count=0;
		for(int ele:a) {
			if(ele==0)
				count++;
		}
		for(int i =0;i<count;i++) {
			a[i]=0;
		}
		for(int i =count;i<a.length;i++) {
			a[i]=1;
		}
		return a;
	}

}
