//Using Hashing

public class duplicacy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {0,1,2,3,3,5,4,2};
        int max=arr[0];
     for(int i =0;i<=arr.length-1;i++) {
     if(arr[i]>max)
      max=arr[i];
     }
    //System.out.println(max);
     int[] a=new int[max+1];
   for(int i =0;i<=arr.length-1;i++) {
  a[arr[i]]++;
   }
  for(int i =0;i<=a.length-1;i++) {
  if(a[i]>1) {
  System.out.println(i +"is duplicate in array");
 }
 }

	}

}
