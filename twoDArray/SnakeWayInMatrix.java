package twoDArray;

//Printing in alternate directions in a matrix.

public class SnakeWayInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][]= {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("Given Matrix: ");
		for(int w[]:a) {
			for(int i:w) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		System.out.println("Snakes way printing: ");
		for(int i=0;i<a.length;i++) {
			if(i%2==0) {
				for(int j=0;j<a[i].length;j++) {
					System.out.print(a[i][j]+" ");
				}
			}
			else {
				for(int j=a[i].length-1;j>=0;j--) {
					System.out.print(a[i][j]+" ");
				}
			}
		}
	}

}
