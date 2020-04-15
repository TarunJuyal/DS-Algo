package twoDArray;

public class Transpose {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][]= {{1,2,3},{5,1,2},{9,5,1}};
		int transpose[][]=new int[3][3];
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				transpose[j][i]=matrix[i][j];
				}
			}
		for(int w[]:transpose) {
			for(int x:w) {
				System.out.print(x+" ");
			}	
			System.out.println();
		}
	}

}
