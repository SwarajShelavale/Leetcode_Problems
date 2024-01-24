class Solution {
    public int countSquares(int[][] matrix) {
        int count=0;
        int n = matrix.length,m=matrix[0].length;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                    continue;
                if(i==0 || j==0)
                {
                    count++;
                    continue;
                }
                
                matrix[i][j]+=Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j],matrix[i][j-1]));
                    count += matrix[i][j];
            }
        }

        return count;
    }
}