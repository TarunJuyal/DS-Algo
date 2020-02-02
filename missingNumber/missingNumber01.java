package missingNumber;

public class missingNumber01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,4,6,7};
        int max=arr[0];
     for(int i =0;i<=arr.length-1;i++) {
     if(arr[i]>max)
      max=arr[i];
     }
     
     int sumTotal=0;
   for(int i =0;i<=max;i++) {
    sumTotal+=i;
   }
   int sumGiven=0;
  for(int i =0;i<=arr.length-1;i++) {
   sumGiven+=arr[i];
	}
   int missingNo=sumTotal-sumGiven;
   if(missingNo!=0)
   System.out.println("Missing number is "+missingNo);
   else
	   System.out.println("No missing number");
}}
