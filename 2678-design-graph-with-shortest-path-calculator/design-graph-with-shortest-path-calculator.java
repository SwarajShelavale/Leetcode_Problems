class Graph {
    int graph[][];
    int n;
    final int MAX_VALUE = 500_000_000;
    public Graph(int n, int[][] edges) {
        this.n=n;
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = MAX_VALUE;
            }
            graph[i][i] = 0;
        }

        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];

            graph[u][v] = wt;
        }

        //PreCompute Floyd Warshal Algorithm

        for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
        

    }
    
    public void addEdge(int[] edge) {
        int u = edge[0], v = edge[1], wt = edge[2];

        if(graph[u][v] <= wt)
            return;
        graph[u][v]=wt;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = Math.min(graph[i][j], graph[i][u] + graph[v][j] + wt);
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        if(graph[node1][node2]!=MAX_VALUE)
            return graph[node1][node2];
        
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */