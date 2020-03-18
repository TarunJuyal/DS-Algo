package recursionPracticeBasic;

public class AllOccurenceOfElement {

    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {10,20,10,90,10,10,100,10,10};
	    int[] result=allOccurane(a,0,10,0);
	    System.out.print("Occuring at indexes: ");
	    for(int ele: result) {
	    System.out.print(ele+" ");
	}
    }
	static int[] allOccurane(int arr[], int index, int value, int count) {
			if(arr.length==index) {
				 int[]result =new int[count];
				 return result;
				 
			}
			if(arr[index]==value) {
				int[] result=allOccurane(arr,index+1,value,count+1);
				result[count]=index;
				return result;
				
			}
		int[] result= allOccurane(arr,index+1,value,count);
		result[count-1]=index;
		return result;
			
		}


}
