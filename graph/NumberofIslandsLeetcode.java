class Solution {
    static int directions[][]= {{-1,0},{0,1},{1,0},{0,-1}};
    void dfs(int i,int j,char grid[][]){
         for(int k=0;k<directions.length;k++){
            int nRow=i+directions[k][0];
            int nCol=j+directions[k][1];
            grid[i][j]='0';
            if((grid.length>nRow && nRow>=0) && (grid[i].length>nCol && nCol>=0) && grid[nRow][nCol]=='1'){
                grid[nRow][nCol]='0';
            	dfs(nRow,nCol,grid);
                
            }
        }
    }
    public int numIslands(char[][] grid) {
       int islandCount=0;
        int noOfIslandsRemaining=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    islandCount++;
                }
            }
        }
         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    noOfIslandsRemaining++;
                }
            }
        }
        return (islandCount>0 || noOfIslandsRemaining>0)?(noOfIslandsRemaining+islandCount):0;
    }
}
