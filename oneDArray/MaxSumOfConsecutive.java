package oneDArray;

public class MaxSumOfConsecutive {

		static void findMaxSum(int a[],int n) {
		int sum=0;
		for(int i=0;i <n;i++) {
		   sum=sum+a[i];
		}
        int max=sum;
        for(int i=n;i <a.length ;i++){
        	sum=sum+a[i]-a[i-n];
        	if ( sum > max ) 
        		max=sum;
        }
        System.out.println("maximum among sum of elements is "+max);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,2,3,4,6,4,5,8,3,8};
		findMaxSum(a,3);
	}

}
