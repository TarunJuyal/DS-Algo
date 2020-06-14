package graph;

import java.util.LinkedList;

class OPair{
	int row;
	int col;
	OPair(int row, int col) {
		this.row=row;
		this.col=col;
	}
}
public class RottenOranges {

	public static int orangesRotting(int a[][]) {
		int timeTaken=-1;
		int rows=a.length;
		int cols=a[0].length;
		int freshoranges=0;
		LinkedList<OPair> queue=new LinkedList<>();
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(a[i][j]==2)
					queue.addLast(new OPair(i,j));
				else if(a[i][j]==1)
					freshoranges++;
			}
		}
		int directions[][]= {{-1,0},{0,1},{1,0},{0,-1}};
		queue.addLast(new OPair(-1,-1));
		while(!queue.isEmpty()) {
			OPair pair=queue.removeFirst();
			if(pair.row==-1) {
				timeTaken++;
				if(!queue.isEmpty())
					queue.addLast(new OPair(-1,-1));
			}
			for(int direction=0;direction<directions.length;direction++) {
				int neighbourRow=pair.row+directions[direction][0];
				int neighbourCol=pair.col+directions[direction][1];
				if((rows>neighbourRow && neighbourRow>=0) &&
        				(cols>neighbourCol && neighbourCol>=0)) {
        			if(a[neighbourRow][neighbourCol]==1) {
        				a[neighbourRow][neighbourCol]=2;
        				freshoranges--;
        				queue.addLast(new OPair(neighbourRow, neighbourCol));
        			}
        		}
			}
		}
		return freshoranges==0?timeTaken:-1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{2,1,1},{1,1,0},{0,1,1}};
		int result = orangesRotting(grid);
		System.out.println(result);
	}

}
