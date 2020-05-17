package oneDArray;

public class WindowSlidingTechnique {
	static void dynamic() {					//finds minimum window size for which condition is satisfied by continuously expanding and shrinking the window size whenever necessary.
		int a[]= {3,4,2,1,5,6,2,1,6};
		int target=7;
		int windowStartingSize=0;
		int currentSum=0;
		int minWindowSize=Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++) {
			currentSum+=a[i];
			while(currentSum>=target) {
				int currentWindowSize=i-windowStartingSize+1;
				minWindowSize=Math.min(minWindowSize, currentWindowSize);
				currentSum=currentSum-a[windowStartingSize];
				windowStartingSize++;
			}
		}
		System.out.println("Min window size is: "+minWindowSize);
	}
	static void fixed(int windowSize) {                                       //for a fixed window size
		int a[]= {3,10,2,1,5,6,2,1,9,7};
		int max=Integer.MIN_VALUE;
		int currentSum=0;
		for(int i=0;i<a.length;i++) {
			currentSum+=a[i];
			if(i>=windowSize-1) {
				max=Math.max(max, currentSum);
				currentSum=currentSum-a[i-windowSize+1];
			}
		}
		System.out.println("Max sum for window size of "+windowSize+" is: "+max);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fixed(2);
		fixed(4);
		dynamic();
	}

}
