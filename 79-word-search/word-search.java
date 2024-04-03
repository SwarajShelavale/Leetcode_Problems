class Solution {
    char matrix[][];
    char letters[];
    boolean visited[][];
    public boolean exist(char[][] board, String word) {
        letters = word.toCharArray();
        matrix = board;
        int n=matrix.length,m=matrix[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==letters[0])
                {
                    visited = new boolean[n][m];
                    if(dfs(i,j,0,visited))
                        return true;                 
                }
            }
        }
        return false;
    }

    boolean dfs(int i,int j, int index,boolean visited[][])
    {
        if(index >= letters.length)
            return true;
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || visited[i][j])
            return false;
        if(matrix[i][j]!=letters[index])
            return false;

        visited[i][j]=true;
        boolean bottom=dfs(i+1,j,index+1,visited);
        boolean right=dfs(i,j+1,index+1,visited);
        boolean top=dfs(i-1,j,index+1,visited);
        boolean left=dfs(i,j-1,index+1,visited);
        visited[i][j]=false;

        if(top || right || bottom || left)
            return true; 
        return false;       
        
    }
}
