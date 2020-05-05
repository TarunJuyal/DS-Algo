package twoDArray;

// A lucky number is element of matrix such that it is minimum element in its row and maximum element in its column.

public class LuckyNumberInMatrix {

	static void findLuckyNumber(int[][] matrix) {
		int minRow[]= new int[matrix.length];
		int maxColumn[]= new int[matrix[0].length];
		for(int i=0;i<matrix.length;i++) {
			minRow[i]=matrix[i][0];
			for(int j=0;j<matrix[i].length;j++) {
				minRow[i]=Math.min(minRow[i], matrix[i][j]);
			}
		}
		for(int i=0;i<matrix[0].length;i++) {
			maxColumn[i]=matrix[0][i];
			for(int j=0;j<matrix.length;j++) {
				maxColumn[i]=Math.max(maxColumn[i], matrix[j][i]);
			}
		}
		for(int i=0;i<minRow.length;i++) {
			for(int j=0;j<maxColumn.length;j++) {
				if(minRow[i]==maxColumn[j]) {
					System.out.println("Lucky number is: "+minRow[i]);
					break;
				}
		}
	}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][]= {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
		int matrix1[][]= {{3,7,8},{9,11,13},{15,16,17}};
		int matrix2[][]= {{7,8},{1,2}};
		findLuckyNumber(matrix);
		findLuckyNumber(matrix1);
		findLuckyNumber(matrix2);
}
}
