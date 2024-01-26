class Solution {
    int[][][] dp;
    int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn)  {
        dp = new int[m][n][maxMove + 1];
        for (int[][] array2D : dp)
            for (int[] array1D : array2D)
                Arrays.fill(array1D, -1);
        return countPaths(m,n,maxMove,startRow,startColumn);   
    }

    int  countPaths(int m, int n, int moves, int row, int col)
    {
        if(row<0 || col<0 || row>=m || col>=n)
        {
            return 1;
        }
        if(moves==0)
             return 0;
        
        if (dp[row][col][moves] != -1)
            return dp[row][col][moves];

        long path =0;   
        path+= countPaths(m,n,moves-1,row-1,col);  
        path+= countPaths(m,n,moves-1,row+1,col);  
        path+= countPaths(m,n,moves-1,row,col-1);  
        path+= countPaths(m,n,moves-1,row,col+1);    

         dp[row][col][moves] = (int) (path % mod);
        return dp[row][col][moves];     
    }
}