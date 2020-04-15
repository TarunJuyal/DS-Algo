package twoDArray;

public class ToeplitzMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int matrix[][]= {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
			//System.out.println(matrix.length);
			boolean flag=true;
			outer:
			for(int i=0;i<matrix.length-1;i++) {
				for(int j=0;j<matrix[i].length-1;j++) {
					if(matrix[i][j]!=matrix[i+1][j+1]) {
						flag=false;
						break outer;
					}
				}
			}
			System.out.println(flag?"Toeplitz Matrix":"Not Toeplitz Matrix");
		}

}
