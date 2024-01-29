class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();

        int n=heights.length,m=heights[0].length;

        boolean pacificVisited[][] = new boolean[n][m];
        boolean atlanticVisited[][] = new boolean[n][m];

        for(int i=0;i<n;i++)
        {
            dfs(i,0,heights,pacificVisited,0);
            dfs(i,m-1,heights,atlanticVisited,0);
        }

        for(int j=0;j<m;j++)
        {
            dfs(0,j,heights,pacificVisited,0);
            dfs(n-1,j,heights,atlanticVisited,0);
        }

        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(pacificVisited[i][j] && atlanticVisited[i][j]) {
                    ArrayList<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        return result;
    }

    void dfs(int row,int col,int[][] heights,boolean[][] visited,int prevHeight)
    {
        if(row<0 || col<0 || row==heights.length || col==heights[0].length ||  visited[row][col] || heights[row][col]<prevHeight)
            return ;
        
        visited[row][col]=true;

        dfs(row-1,col,heights,visited,heights[row][col]);
        dfs(row+1,col,heights,visited,heights[row][col]);
        dfs(row,col-1,heights,visited,heights[row][col]);
        dfs(row,col+1,heights,visited,heights[row][col]);
    }
}