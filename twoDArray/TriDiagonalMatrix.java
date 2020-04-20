package twoDArray;

/*  a Tridiagonal matrix is a matrix that has nonzero elements on the main diagonal, the first diagonal below this, and the first diagonal above the main 
 * diagonal only. all other elements are zero.*/
public class TriDiagonalMatrix {
	static boolean isTriDiagonal(int matrix[][]) {
		for(int i=0;i<=matrix.length-1;i++) {
			for(int j=0;j<=matrix[i].length-1;j++) {
				if((i==j)||(i-1==j)||(i+1==j)) {
					if(matrix[i][j]==0) {
						return false;
					}
				}
				else {
					if(matrix[i][j]!=0) {
						return false;
						
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int matrix[][]= {{1,4,0,0},{3,4,1,0},{0,2,3,4},{0,0,1,3}};
		System.out.println(isTriDiagonal(matrix)?"TriDiagonal Matrix":"Not TriDiagonal Matrix");
	}
}
