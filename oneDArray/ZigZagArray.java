package oneDArray;

//target: a[0]<a[1]>a[2]<a[3]>a[4]...and so on.
// used index as reference (approach 1)
//could have used boolean variable for alternate positions that toggles on every position (approach 2)
public class ZigZagArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[]= {1,2,3,4,5,6,7,8};
		System.out.print("Given Array ");
		for(int i:a) {
			System.out.print(" "+i);
		}
		System.out.println();
		zigZag(a);
		System.out.print("ZigZag Array ");
		for(int i:a) {
			System.out.print(" "+i);
		}
	}
	static void zigZag(int[] a) {
		for(int i=0;i<a.length-1;i++) {
			if(i%2==0) {
				if(a[i]<a[i+1])
					continue;
				else
					swap(a,i,i+1);
			}
			else {
				if(a[i]>a[i+1])
					continue;
				else
					swap(a,i,i+1);
			}
		}
	}
	static void swap(int[] a,int first,int second) {
		int temp = a[first];
		a[first] = a[second];
		a[second] = temp;
	}

}
