class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                // handled separate corner case for first(j==0) && last(n-1) column
                if(j==0)  
                    matrix[i][j]+=Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                else if(j==n-1)            // prev middle   prev right
                    matrix[i][j]+=Math.min(matrix[i-1][j-1],matrix[i-1][j]);
                else                     //  prev left    prev middle
                    matrix[i][j]+=Math.min(matrix[i-1][j],Math.min(matrix[i-1][j-1],matrix[i-1][j+1]));
                                            //prev left             prev middle      prev right
            }
        }

        //So now last row will have all the possible answers of pathSum
        //So we will find minOfall last row Cells
        int minSum=matrix[n-1][0];
        for(int i=1;i<n;i++)
            minSum=Math.min(minSum,matrix[n-1][i]);

        return minSum;
    }
}


