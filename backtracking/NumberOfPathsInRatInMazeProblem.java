package backtracking;

//finds all possible no of paths for rat to travel to destination if the rat can move in all four direction one staep at a time.

public class NumberOfPathsInRatInMazeProblem {
	static int count=0;
	static boolean isSafe(int maze[][], int x, int y) 
	{ 
	    if (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1) 
	    	return true; 
	    return false; 
	} 
	static int findSolution(int maze[][],int x, int y,boolean solution[][],int count) {
		if(x==maze.length-1 && y==maze.length-1) {
			return count+1;
		}
		if(isSafe(maze, x, y)) {
			solution[x][y]=true;
			if (x + 1 < maze.length && !solution[x + 1][y])
				count = findSolution(maze, x + 1, y, solution, count);
			if (y + 1 < maze.length && !solution[x ][y+1])
				count = findSolution(maze, x, y+1, solution, count);
			if (x -1>=0 && !solution[x -1][y])
				count = findSolution(maze, x - 1, y, solution, count);
			if (y - 1 >=0 && !solution[x ][y-1])
				count = findSolution(maze, x, y-1, solution, count);
			solution[x][y]=false;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maze[][]= { { 1, 1, 1, 1 }, 
					  { 1, 1, 0, 1 }, 
                      { 0, 1, 0, 1 }, 
                      { 1, 1, 1, 1 } };
		int count=0;
		boolean solution[][]= new boolean[maze.length][maze.length];
		if(findSolution(maze,0,0,solution,count )==0) {
			System.out.println("solution doesn't exist!!");
		}
		else {
			System.out.println("Total no of paths are: "+findSolution(maze, 0, 0, solution,count));
		}
	}


}
