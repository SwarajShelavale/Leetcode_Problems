class Solution {
    public int numEnclaves(int[][] board) {
        int n=board.length,m=board[0].length;

        //Travel Corners
        for(int i=0;i<n;i++)
        {
            dfs(i,0,board);
            dfs(i,m-1,board);
        }

        for(int j=0;j<m;j++)
        {
            dfs(0,j,board);
            dfs(n-1,j,board);
        }


        int count=0;
        for(int i=1;i<n-1;i++)
        {
            for(int j=1;j<m-1;j++)
            {
                if(board[i][j]==1)
                    count++;
            }
        }

        return count;
    }

     void dfs(int i,int j,int[][] board)
    {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!=1 )
            return;
        board[i][j]=2;

        dfs(i-1,j,board);
        dfs(i+1,j,board);
        dfs(i,j-1,board); 
        dfs(i,j+1,board);
    }
}