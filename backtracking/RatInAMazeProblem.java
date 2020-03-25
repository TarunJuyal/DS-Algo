package backtracking;

/*a maze is given in which a mouse can travel either vertically or horizontally one step at a time.The mouse can travel only at 1 ie path having 0 as element means 
 * it is blocked. we have to find the path to reach at the end of the maze of possible.
 */

public class RatInAMazeProblem {

	static boolean isSafe(int maze[][], int x, int y) 
	{ 
	    if (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1) 
	        return true; 
	    return false; 
	} 
	static boolean findSolution(int maze[][],int x, int y,int solution[][]) {
		if(x==maze.length-1 && y==maze.length-1) {
			solution[x][y]=1;
			return true;
		}
		if(isSafe(maze, x, y)) {
			solution[x][y]=1;
			if(findSolution(maze, x+1, y, solution))
				return true;
			if(findSolution(maze, x, y+1, solution))
				return true;
			solution[x][y]=0;
		}
		return false;
	}
 	static void printSolution(int a[][],int N) 
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
		int maze[][]= { { 1, 1, 0, 0 }, 
					  { 0, 1, 1, 0 }, 
                      { 0, 0, 1, 1 }, 
                      { 1, 1, 1, 1 } };
		int solution[][]= new int[maze.length][maze.length];
		if(findSolution(maze,0,0,solution )==false) {
			System.out.println("solutuion doesn't exist!!");
		}
		else {
			System.out.println("given maze:");
			printSolution(maze, maze.length);
			System.out.println("Solution path is:");
			printSolution(solution,maze.length);
		}
	}

}
