package oneDArray;

public class SumOfConsecutive {

	static void doSum(int a[],int n) { 
        for (int i = 0; (i+n-1)<a.length; i++)  
        { int sum = 0;
        	for(int j=0;j<n;j++) {
             sum+=a[i+j];   
        }
        System.out.print(sum + " ");
        } 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {10,40,50,3,7,8,9,4,99};
		int n=3; //consecutive elements taken at a time
		doSum(a,n);
	}

}
