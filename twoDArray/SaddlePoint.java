package twoDArray;

// A Saddle point is element of matrix such that it is minimum element in its row and maximum element in its column. There can be only one saddle point.

public class LuckyNumberInMatrix {

	static void findLuckyNumber(int[][] matrix) {
		for(int i=0; i < matrix.length;i++){
			int smallestInRow=0;
			for(int j=0; j < matrix[0].length;j++){
				if(matrix[i][j]<matrix[i][smallestInRow])
					smallestInRow=j;
			}
			boolean flag=true;
			for(int k=0; k < matrix.length;k++){
				if(matrix[k][smallestInRow]>matrix[i][smallestInRow]){
					flag=false;
					break
				}
			}
			if(flag){
			System.out.println(matrix[i][smallestInRow]);
			return;
			}
		}
		System.out.println("No saddle point");
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
