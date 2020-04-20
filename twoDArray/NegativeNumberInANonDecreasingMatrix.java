package twoDArray;

//A matrix sorted in non-increasing order is given both row and column wise.return number of negative numbers in it.

public class NegativeNumberInANonDecreasingMatrix {

	static int countNegativeNumbers(int matrix[][]) {
		int result=0,count=0;
		for(int i=0;i<matrix.length;i++) {
			count=0;
			for(int j=0;j<matrix[i].length;j++) {
				if(matrix[i][j]<0) {
					result+=matrix[i].length-count;
					break;
				}
				count+=1;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][]= {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
		int matrix2[][]= {{3,2},{1,0}};
		int matrix3[][]= {{1,-1},{-1,-1}};
		int matrix4[][]= {{-1}};
		System.out.println("There are "+countNegativeNumbers(matrix)+" negative numbers in the matrix");
		System.out.println("There are "+countNegativeNumbers(matrix2)+" negative numbers in the matrix2");
		System.out.println("There are "+countNegativeNumbers(matrix3)+" negative numbers in the matrix3");
		System.out.println("There are "+countNegativeNumbers(matrix4)+" negative numbers in the matrix4");
	}

}
