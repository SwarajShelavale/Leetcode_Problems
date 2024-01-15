class Solution {
    public int numEnclaves(int[][] board) {
        int n=board.length,m=board[0].length;
         //Convert all Boundry O to #
        for(int i=0;i<n;i++)
        {
            if(board[i][0]==1)
                dfs(i,0,board);

             if(board[i][m-1]==1)
                dfs(i,m-1,board);
        }

        for(int j=0;j<m;j++)
        {
            if(board[0][j]==1)
                dfs(0,j,board);

             if(board[n-1][j]==1)
                dfs(n-1,j,board);
        }


        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
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