package recursionPracticeBasic;

public class firstOccurenceOfValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int a[]= {1,10,5,10,6,10,9,4};
       int result = find(a,0,10);
       if(result!=-1)
       System.out.println("first occur at position "+(result+1));
       else
    	   System.out.println("Element not present");
	}
	public static int find(int a[],int i,int value) {
		if(i==a.length)
			return -1;
		if(a[i]==value)
			return i;
		else
			return find(a,i+1,value);
	}

}
