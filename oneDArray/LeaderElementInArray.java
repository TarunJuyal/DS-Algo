package oneDArray;

//an element is leader if it is greater to all elements to its right.The rightmost element is always a leader.

public class LeaderElementInArray {
	public static void main(String[] args) {
		int arr [] = {300,40,60,90,100,12,16,17,4,3,5,2};
		int max =Integer.MIN_VALUE;
		System.out.println("Leader elements are ");
		for(int i = arr.length-1 ; i>=0; i--) {
			if(arr[i]>max) {
				System.out.println(arr[i]);
				max  = arr[i];
			}
		}

	}
}
