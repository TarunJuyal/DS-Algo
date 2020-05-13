import java.util.Scanner;

public class MaxAnd {

	static int findMax(int start,int end) {
		int max=Integer.MIN_VALUE;
		for(int i=start;i<=end;i++) {
			for(int j=i+1;j<=end;j++) {
				int operationValue=i & j;
				if(operationValue>max)
					max=operationValue;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("Enter start:");
		int start=s.nextInt();
		System.out.println("Enter end:");
		int end=s.nextInt();
		System.out.println("MAX and is:"+findMax(start,end));
	}

}
