class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> a = new ArrayList<>();
        int minc=0,minr=0,maxr=matrix.length-1,maxc=matrix[0].length-1;
        int c=0,total=matrix.length*matrix[0].length;
        
        while(c<total){
            for(int i=minr,j=minc;j<=maxc && c<total;j++){
                a.add(matrix[i][j]);
                c++;
            }
            minr++;
            for(int i=minr,j=maxc;i<=maxr && c<total;i++){
                a.add(matrix[i][j]);
                c++;
            }
            maxc--;
            for(int i=maxr,j=maxc;j>=minc && c<total;j--){
                a.add(matrix[i][j]);
                c++;
            }
            maxr--;
            for(int i=maxr,j=minc;i>=minr && c<total;i--){
                a.add(matrix[i][j]);
                c++;
            }
            minc++;
        }
        
        return a;
    }
}
