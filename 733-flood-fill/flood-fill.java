class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean visited[][] = new boolean[image.length][image[0].length];
        int oldColor=image[sr][sc];
        dfs(sr,sc,oldColor,color,image,visited);

        return image;
    }

    void dfs(int sr,int sc,int oldColor,int color,int image[][],boolean visited[][])
    {
        if(sr<0 || sc<0 || sr>=image.length || sc>= image[0].length || visited[sr][sc] || image[sr][sc]!=oldColor)
            return;

        image[sr][sc]=color;
        visited[sr][sc]=true;

        dfs(sr+1,sc,oldColor,color,image,visited);
        dfs(sr-1,sc,oldColor,color,image,visited);
        dfs(sr,sc+1,oldColor,color,image,visited);
        dfs(sr,sc-1,oldColor,color,image,visited);
        
    }
}