package missingNumber;

public class missingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {0,1,2,3,5};
        int max=arr[0];
     for(int i =0;i<=arr.length-1;i++) {
     if(arr[i]>max)
      max=arr[i];
     }
     int[] a=new int[max+1];
   for(int i =0;i<=arr.length-1;i++) {
  a[arr[i]]++;
   }
  for(int i =0;i<=a.length-1;i++) {
  if(a[i]==0) {
  System.out.println(i +"is missing in array");
 }
 }
	}

}
