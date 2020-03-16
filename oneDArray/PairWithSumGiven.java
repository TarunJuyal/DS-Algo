package oneDArray;

public class PairWithSumGiven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int a[]= {2,9,6,3,5,4,10};
         int sum=9;
         System.out.print("Given Array ");
 		for(int i:a) {
 			System.out.print(" "+i);
 		}
 		System.out.println();
 		System.out.println("Approach 1  ");
         findPair(a,sum);
         System.out.println("Approach 2  ");
         findPair2(a, sum);
	}
	//approach 1: get an element and find for that is equal to sum-that element.
	static void findPair(int a[],int s) {
		for(int i=0;i<a.length;i++) {
			int value=s-a[i];
			if(findIfPair(a,value))
				System.out.println("Pair  "+a[i]+" "+value);
		}
	}
	static boolean findIfPair(int a[],int value) {
		for(int i=0;i<a.length;i++) {
			if(a[i]==value)
				return true;
		}
		return false;
	}
	
	//approach 2:Hashing;
	static void findPair2(int a[],int s) {
        int max=a[0];
     for(int i =0;i<=a.length-1;i++) {
     if(a[i]>max)
    	 max=a[i];
     }
     boolean[] a1=new boolean[max+1];
     for(int i =0;i<=a.length-1;i++) {
    	  a1[a[i]]=true;
    	   }
     for(int i=0;i<a1.length;i++) {
		int value;
    	 if(a1[i]) {
			 value=s-i;
			if( findIfPair2(a1, value))
				System.out.println("Pair  "+i+" "+value);
    	 }
	}
}
	static boolean findIfPair2(boolean a1[],int value) {
		if(a1[value])
			return true;
		return false;
	}
}