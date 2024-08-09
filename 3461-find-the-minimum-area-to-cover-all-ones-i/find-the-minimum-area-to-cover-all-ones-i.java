class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        int minRow=n,maxRow=0,minCol=m,maxCol=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    minRow = Math.min(minRow,i);
                    minCol = Math.min(minCol,j);
                    maxRow = Math.max(maxRow,i);
                    maxCol = Math.max(maxCol,j);
                }
            }
        }
        
        return (maxRow-minRow+1)*(maxCol-minCol+1);
    }
}