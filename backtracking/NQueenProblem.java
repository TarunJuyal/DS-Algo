package backtracking;

import java.util.Scanner;

//queens to be placed such that N  queens on an N×N chess board so that no two queens attack each other. 

public class NQueenProblem {

	static boolean isSafe(int a[][],int row,int col,int N) {
		int i, j; 
		for (i = 0; i < col; i++) 
            if (a[row][i] == 1) 
                return false; 
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
            if (a[i][j] == 1) 
                return false; 
        for (i = row, j = col; j >= 0 && i < N; i++, j--) 
            if (a[i][j] == 1) 
                return false; 
        return true; 
	}
	static boolean findSolution(int a[][],int col,int N) {
		if(col>=N)
			return true;
		for(int i=0;i<N;i++) {
			if(isSafe(a,i,col,N)) {
				a[i][col]=1;
				if(findSolution(a, col+1, N))
					return true;
				a[i][col]=0; //backtrack
			}
		
		}
		return false;
		
	}
	static void printBoard(int a[][],int N) 
	{ 
		for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) 
                System.out.print(" " + a[i][j] 
                                 + " "); 
            System.out.println(); 
        } 
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N;
		Scanner scanner =new Scanner(System.in);
		System.out.print("enter number of queens to be placed: ");
		N=scanner.nextInt();
		int a[][]=new int[N][N];
		if(findSolution(a,0,N)==false) {
			System.out.println("solutuion doesn't exist!!");
		}
		else {
			printBoard(a,N);
		}
		scanner.close();
	}

}
