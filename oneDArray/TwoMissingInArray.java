package oneDArray;

public class TwoMissingInArray {
	static boolean isPresent(int a[],int val) {
		for(int i:a)
			if(i==val)
				return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,3,2,6};
		int givenArraySum=0,naturalRangeSum=0,firstMissing=0,secondMissing=0;
		int max=Integer.MIN_VALUE;
		for(int i:a) {
			givenArraySum+=i;
			if(i>max)
				max=i;
		}
		for(int i=1;i<=max;i++) {
			naturalRangeSum+=i;
		}
		int sumOfMissingNumbers=naturalRangeSum-givenArraySum;
		int average=sumOfMissingNumbers/2;
		for(int i=1;i<=average;i++) {
			if(!isPresent(a,i)) {
				firstMissing=i;
				break;
			}
		}
		secondMissing=sumOfMissingNumbers-firstMissing;
		System.out.println("Missing numbers are: "+firstMissing+" "+secondMissing);
	}

}
