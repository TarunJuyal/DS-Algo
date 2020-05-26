package backtracking;

//check for number to be safe in a row then the col and then the square if true move forward if not backtrack.

public class SudokuSolver {
	static boolean isRowSafe(int row,int num,int board[][]) {
		for(int i=0;i<board.length;i++) {
			if(board[row][i]==num)
				return false;
		}
		return true;
	}
	static boolean isColSafe(int col,int num,int board[][]) {
		for(int i=0;i<board.length;i++) {
			if(board[i][col]==num)
				return false;
		}
		return true;
	}
	static boolean isSquareSafe(int row,int col,int num,int board[][]) {
		int rowStart=row-row%3;
		int colStart=col-col%3;
		for(int i=rowStart;i<rowStart+3;i++) {
			for(int j=colStart;j<colStart+3;j++)
				if(board[i][j]==num)
					return false;
		}
		return true;
	}
	static boolean solve(int a[][]) {
		boolean isComplete=true;
		int row=-1,col=-1;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				if(a[i][j]==0) {
					row=i;
					col=j;
					isComplete=false;
					break;
				}
			}
			if(!isComplete)
				break;
		}
		if(isComplete)
			return true;
		for(int n=1;n<=a.length;n++) {
			if(isRowSafe(row, n, a) && isColSafe(col, n, a) && isSquareSafe(row, col, n, a)) {
				a[row][col]=n;
				if(solve(a))
					return true;
				else
					a[row][col]=0;
			}
		}
		return false;
	}
	static void print(int a[][]) {
		for(int []i:a) {
			for(int j:i)
				System.out.print(j+" ");
			System.out.println();
		}
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int board[][]= { { 5 ,0 ,0 ,0 ,0 ,0 ,4 ,2 ,0 }, 
	            { 0 ,0 ,0 ,6 ,0 ,7 ,0 ,1 ,0 }, 
	            { 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,3 }, 
	            { 0 ,0 ,4 ,0 ,0 ,2 ,0 ,0 ,8 }, 
	            { 0 ,0 ,0 ,0 ,7 ,9 ,0 ,0 ,0 }, 
	            { 0 ,1 ,0 ,5 ,0 ,0 ,0 ,0 ,0 }, 
	            { 0 ,0 ,0 ,3 ,4 ,0 ,8 ,0 ,0 }, 
	            { 0 ,5 ,1 ,0 ,2 ,0 ,0 ,0 ,0 }, 
	            { 0 ,7 ,0 ,0 ,0 ,0 ,0 ,0 ,6 } };
		if(solve(board))
			print(board);
		else
			System.out.println("No solution!!");
	}

}
