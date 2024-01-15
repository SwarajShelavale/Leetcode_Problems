class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[]=new int[n];
        
         for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !dfs(i, 1, graph, color)) {
                return false;
            }
        }

        return true;
    }

    boolean dfs(int node,int newColor,int[][] graph,int color[])
    {
        color[node]=newColor;
        for(int i=0;i<graph[node].length;i++)
        {
            int nextNode = graph[node][i];

            if (color[nextNode] == color[node]) {
                return false;
            }

            if (color[nextNode] == 0) {
                if (!dfs(nextNode, 3 - newColor, graph, color)) {
                    return false;
                }
            }

        }

        return true;
    }
}