package oneDArray;

public class PrefixSumAlgo {
	static int findSumOfRange(int[]a,int start,int end) {
		if(start==0)
			return a[end];
		else
			return a[end]-a[start-1];
	}
	static int[] prefixSum(int[] a) {
		for(int i=1;i<a.length;i++) {
			a[i]=a[i]+a[i-1];
		}
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {9,8,1,2,3,6,4};
		int[] e=prefixSum(a);
		System.out.println("Sum in Range: "+findSumOfRange(e,0,4));                    //range 0-4
		System.out.println("Sum in Range: "+findSumOfRange(e,1,3));                    //range 1-3
		System.out.println("Sum in Range: "+findSumOfRange(e,3,5));                    //range 3-5
	}

}
