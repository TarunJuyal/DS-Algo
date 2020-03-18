package oneDArray;

public class TrapRainWaterProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {3,0,0,2,0,4,0,1,2};  //represents heights of bar.
		System.out.print("Given Lengths of bars :");
		for(int i:a) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("Trapped Water is: "+trappedWater(a));
	}
	static int trappedWater(int a[]) {
		int totalWater=0;
		int leftPillars[]=new int[a.length];
		int rightPillars[]=new int[a.length];
		int maxLeft=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]>maxLeft)
				maxLeft=a[i];
			leftPillars[i]=maxLeft;
		}
		int maxRight=0;
		for(int i=a.length-1;i>=0;i--) {
			if(a[i]>maxRight)
				maxRight=a[i];
			rightPillars[i]=maxRight;
		}
		for(int i=0;i<a.length;i++) {
			totalWater+=findMin(leftPillars[i], rightPillars[i])-a[i];
		}
		return totalWater;
	}
	static int findMin(int a, int b) {
		if(a>b)
			return b;
		else
			return a;
	}

}
